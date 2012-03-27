/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.coeia.cases;

import edu.coeia.constants.ApplicationConstants;
import edu.coeia.main.CaseManagerFrame;
import edu.coeia.managers.ApplicationManager;

import edu.coeia.util.FileUtil;
import edu.coeia.util.GUIFileFilter;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author wajdyessam
 */
public class CaseOperations {
    
    private final String caseName ;
    private final JFrame parentFrame;
    private final CASE_OPERATION_TYPE type;
    
    private CaseOperationDialog caseOperationDialog;
    private SwingWorker<Boolean, ProgressData> workerThread;
    
    public static enum CASE_OPERATION_TYPE {REMOVE, EXPORT, IMPORT, LOAD};
    
    public CaseOperations(final JFrame frame, final String caseName, final CASE_OPERATION_TYPE type) {
        this.caseName = caseName;
        this.parentFrame = frame;
        this.type = type;
    }
    
    public void start() {
        this.workerThread = getWorkerThread();
        this.workerThread.execute();
        
        this.caseOperationDialog = new CaseOperationDialog(parentFrame, true, this);
        this.caseOperationDialog.getProgressBar().setIndeterminate(true);
        this.caseOperationDialog.setVisible(true);
    }
    
    void stop() {
        this.workerThread.cancel(true);
    }
    
    private SwingWorker<Boolean, ProgressData> getWorkerThread() {
        SwingWorker<Boolean, ProgressData> worker  = null;
        
        switch(type) {
            case REMOVE:
                worker = new CaseRemoverWorker();
                break;
                
            case EXPORT:
                worker = new CaseExporterWorker();
                break;
                
            case IMPORT:
                worker = new CaseImporterWorker();
                break;
        }
        
        return worker;
    }
    
    private final class CaseImporterWorker extends SwingWorker<Boolean, ProgressData> {
        @Override
        public Boolean doInBackground() {
         
            boolean result = false;
            try {
             final GUIFileFilter SWING_DEM_FILTER = new GUIFileFilter("DEM CASE", 
                ApplicationConstants.CASE_EXPORT_EXTENSION);

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(SWING_DEM_FILTER);

                int resultNo = fileChooser.showOpenDialog(null);
                if ( resultNo == JFileChooser.APPROVE_OPTION ) {
                    File file = fileChooser.getSelectedFile();
                    
                    String fileNameWithOutExt = file.getName().toString().replaceFirst("[.][^.]+$", "");
                    decompress(file.getAbsolutePath(), ApplicationManager.Manager.getCasesPath() );

                    String destPath = ApplicationManager.Manager.getCasesPath() + File.separator + fileNameWithOutExt;
                    String line = fileNameWithOutExt + " - " + destPath;
                    Case aCase = ApplicationManager.Manager.getCase(line);
                    aCase.setCaseLocation(destPath);

                    String prefLocation = aCase.getCaseLocation() + File.separator +  ApplicationConstants.CASE_PREFERENCE_EXTENSION;

                    CaseFacade caseFacade = CaseFacade.openCase(aCase);
                    caseFacade.closeCase();

                    // updating case pointer after closing db
                    // so we know here if db is not found, this is file is currpted so 
                    // ignore it and not added in casees list
                    caseFacade.updateCase(aCase.getCaseName(), destPath);
                    caseFacade.importHistory(prefLocation);

                    ((CaseManagerFrame)parentFrame).readCases();
                }
            }
            catch(Exception e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(parentFrame, "Cannot Importing Case File",
                                "Case file is currept", JOptionPane.ERROR_MESSAGE);
                    }
                });
            }
            return result;
        }
        
        private void decompress(final String srcZip, final String destDir) throws Exception {
            this.decompressFolder(srcZip, destDir);
        }

        private void decompressFolder(final String srcZip, final String destDir) throws Exception {
            ZipInputStream zInputStream = new ZipInputStream(new FileInputStream(srcZip));
            ZipFile zf = new ZipFile(srcZip);

            ZipEntry zipEntry;
            while( (zipEntry = zInputStream.getNextEntry())  != null ) {
                if ( isCancelled())
                    break;

                if ( zipEntry.isDirectory() ) {
                    File newFolder = new File(destDir + File.separator + zipEntry.getName());
                    newFolder.mkdirs();
                    publish(new ProgressData(newFolder.getAbsolutePath()));
                }
                else {
                    if ( zipEntry.getName().endsWith(File.separator) ) { // empty dir
                        File emptyDirectory = new File(destDir + File.separator + zipEntry.getName());
                        emptyDirectory.mkdirs();
                        publish(new ProgressData(emptyDirectory.getAbsolutePath()));
                        continue;
                    }

                    String newPath = destDir + File.separator + zipEntry.getName();
                    File newFile = new File(newPath);

                    if (!newFile.getParentFile().exists() ) {
                        newFile.getParentFile().mkdirs();
                    }

                    publish(new ProgressData(newFile.getAbsolutePath()));
                    
                    InputStream is = zf.getInputStream(zipEntry);
                    FileUtil.saveObject(is, newPath);
                }

                zInputStream.closeEntry();
            }

            zInputStream.close();
        }
    
        @Override
        public void process(final List<ProgressData> items) {
            if ( isCancelled() )
                return;
            
            for(ProgressData item: items) {
                CaseOperations.this.caseOperationDialog.addLine(item.fileName);
            }
        }
        
        @Override
        public void done() {
            try {
                Boolean result = get();
                
                if ( result ) {
                    JOptionPane.showMessageDialog(parentFrame, "Finishing Task Seccesfully");
                }
                else {
                    JOptionPane.showMessageDialog(parentFrame, "The task is canclled by the user");
                }
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(CaseOperations.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (ExecutionException ex) {
                Logger.getLogger(CaseOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                caseOperationDialog.dispose();
                ((CaseManagerFrame)parentFrame).readCases();
                
                return;
            }
        }
    }
    
    
    private final class CaseExporterWorker extends SwingWorker<Boolean, ProgressData> {
        @Override
        public Boolean doInBackground()  {
            boolean result = false;
            
            try {
                CaseFacade caseFacade = ApplicationManager.Manager.openCase(caseName);
                caseFacade.closeCase();
                
                // ask for exported location
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setSelectedFile(new File(caseFacade.getCase().getCaseName() + ApplicationConstants.CASE_EXPORT_EXTENSION) );

                int resultNo = fileChooser.showSaveDialog(parentFrame);
                if ( resultNo == JFileChooser.APPROVE_OPTION ) {
                    File file = fileChooser.getSelectedFile();
                    caseFacade.exportHistory(caseFacade.getCase().getCaseName(), caseFacade.getCasePreferenceFileLocation());
                    compress(caseFacade.getCase().getCaseLocation(), file.getAbsolutePath());
                    result = true;
                }
                
            } catch (Exception ex) {
                Logger.getLogger(CaseOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
            return result;
        }
        
        private void compress(final String srcFolder, final String dest) throws Exception {
            this.compressFolder(srcFolder, dest);
        }

        private void compressFolder (final String srcFolder, final String destZipFile) throws Exception {
            File srcFile = new File(srcFolder);

            if ( srcFile.isDirectory() ) {
                FileOutputStream dest = new FileOutputStream(destZipFile);
                ZipOutputStream out = new ZipOutputStream(dest);
                this.compresFolderContent("", srcFolder, out);
                out.close();
            }
        }

        private void compresFolderContent(final String path, final String srcFile, final ZipOutputStream out) throws Exception {
            File dir = new File(srcFile);
            
            publish(new ProgressData(dir.getAbsolutePath()));
            
            String[] files = dir.list();

            if (files.length > 0) {
                for (String file : files) {
                    if ( isCancelled() ) {
                        break;
                    }

                    String newPath = "";

                    if (path.isEmpty()) {
                        newPath += dir.getName();
                    } else {
                        newPath += path + File.separator + dir.getName();
                    }

                    String newFilePath = srcFile + File.separator + file;
                    this.compressObject(newPath, newFilePath, out);
                }
            } else { // empty folder, zip it
                ZipEntry entry = new ZipEntry(path + File.separator + dir.getName() + File.separator );
                out.putNextEntry(entry);
                out.closeEntry(); 
            }
        }

        private void compressObject(final String path, final String srcFile, final ZipOutputStream out) throws Exception {
            File file = new File(srcFile);

            if ( file.isDirectory() ) {
                this.compresFolderContent(path, srcFile, out);
            }
            else {
                this.compressFile(path, srcFile, out);
            }
        }

        private void compressFile(final String path, final String srcFile, final ZipOutputStream out) throws Exception {
            if ( isCancelled() )
                return;

            File file = new File(srcFile);
            if ( file.isDirectory() ) return;

            final int BUFFER = 2048;
            byte data[] = new byte[BUFFER];

            FileInputStream fileInputStream = new FileInputStream(srcFile);
            ZipEntry entry = new ZipEntry(path + File.separator + file.getName());
            out.putNextEntry(entry);

            int count;
            while ( (count = fileInputStream.read(data)) > 0 ) 
                out.write(data, 0, count);

            fileInputStream.close();
            out.closeEntry(); 
        }
    
        @Override
        public void process(final List<ProgressData> items) {
            if ( isCancelled() )
                return;
            
            for(ProgressData item: items) {
                CaseOperations.this.caseOperationDialog.addLine(item.fileName);
            }
        }
        
        @Override
        public void done() {
            try {
                Boolean result = get();
                
                if ( result ) {
                    JOptionPane.showMessageDialog(parentFrame, "Finishing Task Seccesfully");
                }
                else {
                    JOptionPane.showMessageDialog(parentFrame, "The task is canclled by the user");
                }
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(CaseOperations.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (ExecutionException ex) {
                Logger.getLogger(CaseOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                caseOperationDialog.dispose();
                ((CaseManagerFrame)parentFrame).readCases();
                
                return;
            }
        }
    }
    
    private final class CaseRemoverWorker extends SwingWorker<Boolean, ProgressData> {
        @Override
        public Boolean doInBackground() {
            boolean removeCase = false;
            
            try {
                CaseFacade caseFacade = ApplicationManager.Manager.openCase(caseName);
                caseFacade.closeCase();
                removeCase = removeDirectory(new File(caseFacade.getCaseFolderLocation()));
            } catch (Exception ex) {
                Logger.getLogger(CaseOperations.class.getName()).log(Level.SEVERE, null, ex);
            }

            return removeCase;
        }
        
        private boolean removeDirectory (File dirPath) {
            if ( dirPath.isDirectory() ) {
                File[] files = dirPath.listFiles() ;

                for(File file: files ) {
                    publish(new ProgressData(file.getAbsolutePath()));
                    
                    if ( file.isDirectory() )
                        removeDirectory(file);
                    else {
                       file.delete() ;
                    }
                }
            }

            return dirPath.delete() ;
        }
        
        @Override
        public void process(final List<ProgressData> items) {
            if ( isCancelled() )
                return;
            
            for(ProgressData item: items) {
                CaseOperations.this.caseOperationDialog.addLine(item.fileName);
            }
        }
        
        @Override
        public void done() {
            try {
                Boolean result = get();
                
                if ( result ) {
                    JOptionPane.showMessageDialog(parentFrame, "Finishing Task Seccesfully");
                }
                else {
                    JOptionPane.showMessageDialog(parentFrame, "The task is canclled by the user");
                }
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(CaseOperations.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (ExecutionException ex) {
                Logger.getLogger(CaseOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                caseOperationDialog.dispose();
                ((CaseManagerFrame)parentFrame).readCases();
                
                return;
            }
        }
    }
    
    private final class ProgressData {
        String fileName;
        
        public ProgressData(final String name) {
            this.fileName = name;
        }
    }
}