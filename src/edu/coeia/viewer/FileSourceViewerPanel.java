/* 
 * Copyright (C) 2014 Center of Excellence in Information Assurance
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.coeia.viewer;

import edu.coeia.util.Utilities;
import edu.coeia.items.FileItem;
import edu.coeia.items.Item;

import java.awt.BorderLayout;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

/**
 *
 * @author wajdyessam
 */

class FileSourceViewerPanel extends javax.swing.JPanel {

    private final JWebBrowser fileBrowser;
    private final Item item;
    private final String keyword ;
    private final SourceViewerDialog searchViewerDialog ;
    
    /** Creates new form FileSourceViewerPanel */
    public FileSourceViewerPanel(SourceViewerDialog dialog, final Item item) {
        this.initComponents();
        
        this.searchViewerDialog = dialog;
        this.keyword = dialog.getQueryString();
        this.item = item;
                
        // add file browser
        this.fileBrowser = new JWebBrowser();
        this.fileBrowser.setBarsVisible(false);
        this.fileBrowser.setStatusBarVisible(false);
        this.fileRenderPanel.add(fileBrowser, BorderLayout.CENTER); 
        
        this.displayDocumentInformation();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewPanel = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        fileRenderPanel = new javax.swing.JPanel();
        textViewerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        planTextArea = new javax.swing.JTextArea();
        FileMetaDataPanel = new javax.swing.JPanel();
        jScrollPane28 = new javax.swing.JScrollPane();
        metaDataTextArea = new javax.swing.JTextArea();
        properitiesPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fileNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        filePathTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mimeTextField = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        fileRenderPanel.setLayout(new java.awt.BorderLayout());
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("edu/coeia/viewer/Bundle"); // NOI18N
        jTabbedPane2.addTab(bundle.getString("FileSourceViewerPanel.fileRenderPanel.TabConstraints.tabTitle"), fileRenderPanel); // NOI18N

        textViewerPanel.setLayout(new java.awt.BorderLayout());

        planTextArea.setColumns(20);
        planTextArea.setEditable(false);
        planTextArea.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        planTextArea.setRows(5);
        jScrollPane1.setViewportView(planTextArea);

        textViewerPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab(bundle.getString("FileSourceViewerPanel.textViewerPanel.TabConstraints.tabTitle"), textViewerPanel); // NOI18N

        FileMetaDataPanel.setLayout(new java.awt.BorderLayout());

        metaDataTextArea.setColumns(20);
        metaDataTextArea.setEditable(false);
        metaDataTextArea.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        metaDataTextArea.setRows(5);
        jScrollPane28.setViewportView(metaDataTextArea);

        FileMetaDataPanel.add(jScrollPane28, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab(bundle.getString("FileSourceViewerPanel.FileMetaDataPanel.TabConstraints.tabTitle"), FileMetaDataPanel); // NOI18N

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                .addContainerGap())
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(viewPanel, java.awt.BorderLayout.CENTER);

        jLabel1.setText(bundle.getString("FileSourceViewerPanel.jLabel1.text")); // NOI18N

        fileNameTextField.setEditable(false);
        fileNameTextField.setText(bundle.getString("FileSourceViewerPanel.fileNameTextField.text")); // NOI18N

        jLabel2.setText(bundle.getString("FileSourceViewerPanel.jLabel2.text")); // NOI18N

        filePathTextField.setEditable(false);
        filePathTextField.setText(bundle.getString("FileSourceViewerPanel.filePathTextField.text")); // NOI18N

        jLabel3.setText(bundle.getString("FileSourceViewerPanel.jLabel3.text")); // NOI18N

        dateTextField.setEditable(false);
        dateTextField.setText(bundle.getString("FileSourceViewerPanel.dateTextField.text")); // NOI18N

        jLabel4.setText(bundle.getString("FileSourceViewerPanel.jLabel4.text")); // NOI18N

        mimeTextField.setEditable(false);
        mimeTextField.setText(bundle.getString("FileSourceViewerPanel.mimeTextField.text")); // NOI18N

        javax.swing.GroupLayout properitiesPanelLayout = new javax.swing.GroupLayout(properitiesPanel);
        properitiesPanel.setLayout(properitiesPanelLayout);
        properitiesPanelLayout.setHorizontalGroup(
            properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(properitiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mimeTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                    .addComponent(dateTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                    .addComponent(filePathTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                    .addComponent(fileNameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE))
                .addContainerGap())
        );
        properitiesPanelLayout.setVerticalGroup(
            properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(properitiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(filePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(properitiesPanel, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents
        
    private void displayDocumentInformation () {        
        FileItem fileItem = (FileItem) this.item;

        String fileName = fileItem.getFileName();
        String filePath = fileItem.getFilePath();
        String date = fileItem.getFileDate();
        String mime = fileItem.getFileMimeType();
        String content = fileItem.getFileContent();
        String metadata = fileItem.getMetadata();

        this.fileNameTextField.setText(fileName);
        this.filePathTextField.setText(filePath);
        this.dateTextField.setText(date);
        this.mimeTextField.setText(mime);
        this.fileBrowser.setHTMLContent(Utilities.highlightString(content, this.keyword));
        this.planTextArea.setText(content);
        this.metaDataTextArea.setText(metadata);

        //TODO: replace metadate view to browser or html type to support html rendering
        //metaDataTextArea.setText(highlightString(metadata, keyword));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FileMetaDataPanel;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JTextField filePathTextField;
    private javax.swing.JPanel fileRenderPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea metaDataTextArea;
    private javax.swing.JTextField mimeTextField;
    private javax.swing.JTextArea planTextArea;
    private javax.swing.JPanel properitiesPanel;
    private javax.swing.JPanel textViewerPanel;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
