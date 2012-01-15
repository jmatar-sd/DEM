/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FileSystemCrawlingProgressPanel.java
 *
 * Created on Jan 14, 2012, 2:26:43 PM
 */
package edu.coeia.indexing;

/**
 *
 * @author wajdyessam
 */
public class FileSystemCrawlingProgressPanel extends javax.swing.JPanel {

    /** Creates new form FileSystemCrawlingProgressPanel */
    public FileSystemCrawlingProgressPanel() {
        initComponents();
    }

    void setCurrentFile(final String fileName) { this.currentFileLbl.setText(fileName); }
    void setFileSize(final String size) { this.sizeOfFileLbl.setText(size); }
    void setFileExtension(final String ext) { this.fileExtensionLbl.setText(ext) ; }
    
    void clear() {
        this.setFileExtension("");
        this.setCurrentFile("");
        this.setFileSize("");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progresLabelPanel = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        currentFileLbl = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        sizeOfFileLbl = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        fileExtensionLbl = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel23.setText("Current File:");

        currentFileLbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        currentFileLbl.setForeground(new java.awt.Color(0, 0, 255));
        currentFileLbl.setText(" ");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel25.setText("File Size:");

        sizeOfFileLbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sizeOfFileLbl.setForeground(new java.awt.Color(0, 0, 255));
        sizeOfFileLbl.setText(" ");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel24.setText("File Extension:");

        fileExtensionLbl.setFont(new java.awt.Font("Tahoma", 1, 11));
        fileExtensionLbl.setForeground(new java.awt.Color(0, 0, 255));
        fileExtensionLbl.setText(" ");

        javax.swing.GroupLayout progresLabelPanelLayout = new javax.swing.GroupLayout(progresLabelPanel);
        progresLabelPanel.setLayout(progresLabelPanelLayout);
        progresLabelPanelLayout.setHorizontalGroup(
            progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progresLabelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(progresLabelPanelLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentFileLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
                    .addGroup(progresLabelPanelLayout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileExtensionLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
                    .addGroup(progresLabelPanelLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sizeOfFileLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)))
                .addContainerGap())
        );
        progresLabelPanelLayout.setVerticalGroup(
            progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progresLabelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(currentFileLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(sizeOfFileLbl))
                .addGap(11, 11, 11)
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileExtensionLbl)
                    .addComponent(jLabel24))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        add(progresLabelPanel, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currentFileLbl;
    private javax.swing.JLabel fileExtensionLbl;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel progresLabelPanel;
    private javax.swing.JLabel sizeOfFileLbl;
    // End of variables declaration//GEN-END:variables
}
