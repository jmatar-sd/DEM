
package edu.coeia.filesystem;

import edu.coeia.filesystem.HashAnalysisPanel;
import edu.coeia.filesystem.FileBrowsingPanel;
import edu.coeia.filesystem.VisualizationPanel;
import edu.coeia.filesystem.TextCloudPanel;
import edu.coeia.filesystem.ApplicationHistoryPanel;
import edu.coeia.cases.Case;
import edu.coeia.filesignature.FileSignaturePanel;
import javax.swing.JFrame;

/*
 * FileSystemPanel.java
 *
 * @author wajdyessam
 * 
 * Created on Aug 10, 2011, 4:14:30 PM
 * 
 */

public class FileSystemPanel extends javax.swing.JPanel {
    
    /** Creates new form FileSystemPanel */
    public FileSystemPanel(Case aIndex, JFrame parentFrame) {
        initComponents();

        //SearchFileSystemPanel searchPanel = new SearchFileSystemPanel(aIndex, parentFrame);
        FileBrowsingPanel fileBrowsingPanel = new FileBrowsingPanel();
        TextCloudPanel textCloudPanel = new TextCloudPanel(aIndex, parentFrame, this);
        VisualizationPanel visualizationPanel = new VisualizationPanel(aIndex, parentFrame, this);
        FileSignaturePanel fileSignaturePanel = new FileSignaturePanel();
        HashAnalysisPanel hashAnalysisPanel = new HashAnalysisPanel();
        ApplicationHistoryPanel applicationHistoryPanel = new ApplicationHistoryPanel();
        
        //this.fileSystemTappedPane.add("Searching", searchPanel);
        this.fileSystemTappedPane.add("Browse", fileBrowsingPanel);
        this.fileSystemTappedPane.add("Text Cloud", textCloudPanel);
        this.fileSystemTappedPane.add("Visualization", visualizationPanel);
        this.fileSystemTappedPane.add("File Signature", fileSignaturePanel);
        this.fileSystemTappedPane.add("Hash Analysis", hashAnalysisPanel);
        this.fileSystemTappedPane.add("Application History", applicationHistoryPanel);
    }

    public void showSearchWithKeyword (String text) {
        fileSystemTappedPane.setSelectedIndex(0);
        //((SearchFileSystemPanel)fileSystemTappedPane.getComponentAt(0)).setSearchKeyword(text);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileSystemTappedPane = new javax.swing.JTabbedPane();

        setLayout(new java.awt.BorderLayout());
        add(fileSystemTappedPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane fileSystemTappedPane;
    // End of variables declaration//GEN-END:variables
}
