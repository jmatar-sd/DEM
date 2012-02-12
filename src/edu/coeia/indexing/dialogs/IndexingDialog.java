/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IndexingDialog.java
 *
 * Created on Sep 10, 2011, 9:01:08 AM
 */
package edu.coeia.indexing.dialogs;

import edu.coeia.cases.CaseFacade;
import edu.coeia.gutil.GuiUtil;
import edu.coeia.gutil.JTableUtil;
import edu.coeia.indexing.CrawlerIndexerThread;
import edu.coeia.util.FileUtil;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.File;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable ;

/**
 *
 * @author wajdyessam
 */
public final class IndexingDialog extends javax.swing.JDialog {

    private final CaseFacade caseFacade;
    
    private CrawlerIndexerThread indexerThread ;
    private boolean loggingAppearanceFlag;
    
    private final EmailCrawlingProgressPanel emailCrawlingPanel ;
    private final FileSystemCrawlingProgressPanel fileSystemCrawlingPanel;
    
    /** Creates new form IndexingDialog */
    public IndexingDialog(java.awt.Frame parent, boolean modal,
            final CaseFacade caseFacade, boolean startIndexNow) {
        
        super(parent, modal);
        initComponents();
       
        this.emailCrawlingPanel = new EmailCrawlingProgressPanel();
        this.fileSystemCrawlingPanel = new FileSystemCrawlingProgressPanel();
        
        this.objectPanel.add(this.emailCrawlingPanel, "EMAIL");
        this.objectPanel.add(this.fileSystemCrawlingPanel, "FILE");
        
        GuiUtil.showPanel("FILE", this.objectPanel);
        
        this.loggingAppearanceFlag = false;
        this.caseFacade = caseFacade;
        this.showLoggingPanel(this.loggingAppearanceFlag);
        
        // set start and end button
        resettingButtons(true);
        
        // close thread if the thread running and user close the window
        this.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosed (WindowEvent event){
                try {
                    stopIndexerThread();
                    hideIndexingDialog();
                } catch (IOException ex) {
                    Logger.getLogger(IndexingDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        // if user select start indexing when finish case creation
        // then start indexing direct
        if ( startIndexNow ) {
            try {
                startIndexerThread();
            } catch (IOException ex) {
                Logger.getLogger(IndexingDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        indexPanel = new javax.swing.JPanel();
        objectPanel = new javax.swing.JPanel();
        progressStatusPanel = new javax.swing.JPanel();
        bigSizeMsgLbl = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jLabel27 = new javax.swing.JLabel();
        numberOfFilesLbl = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        numberOfErrorFilesLbl = new javax.swing.JLabel();
        indexControlPanel = new javax.swing.JPanel();
        startIndexButton = new javax.swing.JButton();
        stopIndexingButton = new javax.swing.JButton();
        displayLoggingButton = new javax.swing.JButton();
        loggingPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        indexTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Case Indexing Window");

        indexPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        indexPanel.setMaximumSize(new java.awt.Dimension(550, 2147483647));
        indexPanel.setLayout(new javax.swing.BoxLayout(indexPanel, javax.swing.BoxLayout.PAGE_AXIS));

        objectPanel.setLayout(new java.awt.CardLayout());
        indexPanel.add(objectPanel);

        progressStatusPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Index Case", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        progressStatusPanel.setLayout(new javax.swing.BoxLayout(progressStatusPanel, javax.swing.BoxLayout.PAGE_AXIS));

        bigSizeMsgLbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bigSizeMsgLbl.setForeground(new java.awt.Color(255, 0, 0));
        bigSizeMsgLbl.setText(" ");
        progressStatusPanel.add(bigSizeMsgLbl);
        progressStatusPanel.add(progressBar);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Number of Files in Index:");
        progressStatusPanel.add(jLabel27);

        numberOfFilesLbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        numberOfFilesLbl.setForeground(new java.awt.Color(0, 0, 255));
        numberOfFilesLbl.setText(" ");
        progressStatusPanel.add(numberOfFilesLbl);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Number of Files Cannot Indexed:");
        progressStatusPanel.add(jLabel41);

        numberOfErrorFilesLbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        numberOfErrorFilesLbl.setForeground(new java.awt.Color(0, 0, 255));
        numberOfErrorFilesLbl.setText(" ");
        progressStatusPanel.add(numberOfErrorFilesLbl);

        indexPanel.add(progressStatusPanel);

        indexControlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        startIndexButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        startIndexButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/new-edit-find-replace.png"))); // NOI18N
        startIndexButton.setText("Start Indexing");
        startIndexButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startIndexButtonActionPerformed(evt);
            }
        });
        indexControlPanel.add(startIndexButton);

        stopIndexingButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        stopIndexingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/cancel.png"))); // NOI18N
        stopIndexingButton.setText("Stop Indexing");
        stopIndexingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopIndexingButtonActionPerformed(evt);
            }
        });
        indexControlPanel.add(stopIndexingButton);

        displayLoggingButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        displayLoggingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/1274599246_text-x-log.png"))); // NOI18N
        displayLoggingButton.setText("Display Logging");
        displayLoggingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayLoggingButtonActionPerformed(evt);
            }
        });
        indexControlPanel.add(displayLoggingButton);

        indexPanel.add(indexControlPanel);

        loggingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "logging", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        loggingPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 100));

        indexTable.setAutoCreateRowSorter(true);
        indexTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "File Type", "File Path", "Indexing Status"
            }
        ));
        jScrollPane1.setViewportView(indexTable);

        loggingPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        indexPanel.add(loggingPanel);

        getContentPane().add(indexPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startIndexButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startIndexButtonActionPerformed
        try {
            startIndexerThread();
        } catch (IOException ex) {
            Logger.getLogger(IndexingDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_startIndexButtonActionPerformed

    private void stopIndexingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopIndexingButtonActionPerformed
        try {
            stopIndexerThread();
        } catch (IOException ex) {
            Logger.getLogger(IndexingDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_stopIndexingButtonActionPerformed

    private void displayLoggingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayLoggingButtonActionPerformed
        this.loggingAppearanceFlag = !loggingAppearanceFlag;
        this.showLoggingPanel(loggingAppearanceFlag);
    }//GEN-LAST:event_displayLoggingButtonActionPerformed

    private void showLoggingPanel(boolean flag) {
        this.loggingPanel.setVisible(flag);
        //this.pack();
    }
    
    private void startIndexerThread () throws IOException{
        resettingButtons(false);
        JTableUtil.removeAllRows(indexTable);

        // starting thread
        indexerThread = new CrawlerIndexerThread(this);
        indexerThread.execute();
    }
    
    private void stopIndexerThread() throws IOException {
        if ( indexerThread != null) {
            this.clearFields();
            indexerThread.stopIndexingThread();
        }
    }
    
    public void hideIndexingDialog() {
        this.dispose();
    }
    
    private void resettingButtons(boolean state) {
        startIndexButton.setEnabled(state);
        stopIndexingButton.setEnabled(!state);
    }
   
    public CaseFacade getCaseFacade() { return this.caseFacade; }

    public JTable getLoggingTable () { return this.indexTable; }
    public JProgressBar getProgressBar() { return this.progressBar ; }
    
    public void showFileSystemPanel(final FileSystemCrawlingProgressPanel.FileSystemCrawlerData data) {
        EventQueue.invokeLater(new Runnable() { 
            @Override
            public void run() {
                fileSystemCrawlingPanel.setCurrentFile(data.getFileName());
                fileSystemCrawlingPanel.setFileExtension(data.getFileExtension());
                fileSystemCrawlingPanel.setFileSize(data.getFileSize());
                fileSystemCrawlingPanel.setFileDate(data.getFileDate());
                fileSystemCrawlingPanel.setEmbeddedDocuments(data.getEmbeddedDocuments());
                GuiUtil.showPanel("FILE", objectPanel);
            }
        });
    }
    
    public void showEmailPanel(final EmailCrawlingProgressPanel.EmailCrawlingData data) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                emailCrawlingPanel.setAgentType(data.getAgentType());
                emailCrawlingPanel.setCurrentFolder(data.getCurrentFolder());
                emailCrawlingPanel.setCurrentMessageSubject(data.getSubject());
                emailCrawlingPanel.setMessageDate(data.getDate());
                emailCrawlingPanel.setHasAttachment(data.getHasAttachment());
                emailCrawlingPanel.setFrom(data.getFrom());
                emailCrawlingPanel.setTo(data.getTo());
                emailCrawlingPanel.setAttachment(data.getAttachments());
                GuiUtil.showPanel("EMAIL", objectPanel);
            }
        });
    }
    
    public void addErrorMessage(final File filePath, final String message) {
        Object[] data = { FileUtil.getExtension(filePath.getPath()), filePath.getPath(), message};
        JTableUtil.addRowToJTable(this.getLoggingTable(), data);
    }
    
    public void setNumberOfFiles(final String no) { this.numberOfFilesLbl.setText(no); }
    public void setNumberOfFilesError(final String no) { this.numberOfErrorFilesLbl.setText(no); }
    public void setprogressBar(final int value) { this.progressBar.setValue(value); }
    public void setBigSizeLabel(final String text) { this.bigSizeMsgLbl.setText(text); }
    public void setProgressIndetermined(final boolean status) { this.progressBar.setIndeterminate(status); }
    public void setStartButtonStatus(final boolean status) { this.startIndexButton.setEnabled(status); }
    public void setStopButtonStatus(final boolean status) { this.stopIndexingButton.setEnabled(status); }
    
    public void clearFields() {
        this.setBigSizeLabel("");
        this.setprogressBar(0);
        this.getProgressBar().setStringPainted(false);
        this.setProgressIndetermined(false);
        this.setStartButtonStatus(true);
        this.setStopButtonStatus(false);
    }
    
    // used to pack the GUI when new type of 
    // panel used in indexing process
    // so the gui will increase/decrease automaticlly
    //private String currentPanel = "";
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bigSizeMsgLbl;
    private javax.swing.JButton displayLoggingButton;
    private javax.swing.JPanel indexControlPanel;
    private javax.swing.JPanel indexPanel;
    private javax.swing.JTable indexTable;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel loggingPanel;
    private javax.swing.JLabel numberOfErrorFilesLbl;
    private javax.swing.JLabel numberOfFilesLbl;
    private javax.swing.JPanel objectPanel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JPanel progressStatusPanel;
    private javax.swing.JButton startIndexButton;
    private javax.swing.JButton stopIndexingButton;
    // End of variables declaration//GEN-END:variables
}
