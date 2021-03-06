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
package edu.coeia.cases.management;

import edu.coeia.constants.ResourceManager;
import edu.coeia.util.DateUtil;
import java.awt.ComponentOrientation;
import java.io.File;
import java.util.Date;
import javax.swing.JProgressBar;

/**
 *
 * @author wajdyessam
 */
public class CaseOperationDialog extends javax.swing.JDialog {

    private CaseOperations caseOperations;
    
    /** Creates new form CaseOperationDialog */
    public CaseOperationDialog(java.awt.Frame parent, boolean modal,
            CaseOperations caseOperations) {
        
        super(parent, modal);
        initComponents();
        
        this.applyComponentOrientation(ComponentOrientation.getOrientation(ResourceManager.getLanguage()));
        this.setLocationRelativeTo(parent);
        this.caseOperations = caseOperations;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        dataPanel = new javax.swing.JPanel();
        fileLabel = new javax.swing.JLabel();
        fileTextField = new javax.swing.JTextField();
        sizeLabel = new javax.swing.JLabel();
        sizeTextField = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        dateTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        progressPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/delete.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("edu/coeia/cases/management/Bundle"); // NOI18N
        cancelButton.setText(bundle.getString("CaseOperationDialog.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText(bundle.getString("CaseOperationDialog.jLabel1.text")); // NOI18N

        javax.swing.GroupLayout progressPanelLayout = new javax.swing.GroupLayout(progressPanel);
        progressPanel.setLayout(progressPanelLayout);
        progressPanelLayout.setHorizontalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(progressPanelLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addContainerGap(105, Short.MAX_VALUE))
                        .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, progressPanelLayout.createSequentialGroup()
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
        );
        progressPanelLayout.setVerticalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("CaseOperationDialog.dataPanel.border.title"))); // NOI18N
        dataPanel.setLayout(new javax.swing.BoxLayout(dataPanel, javax.swing.BoxLayout.PAGE_AXIS));

        fileLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fileLabel.setText(bundle.getString("CaseOperationDialog.fileLabel.text")); // NOI18N
        dataPanel.add(fileLabel);

        fileTextField.setEditable(false);
        fileTextField.setText(bundle.getString("CaseOperationDialog.fileTextField.text")); // NOI18N
        dataPanel.add(fileTextField);

        sizeLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sizeLabel.setText(bundle.getString("CaseOperationDialog.sizeLabel.text")); // NOI18N
        dataPanel.add(sizeLabel);

        sizeTextField.setEditable(false);
        sizeTextField.setText(bundle.getString("CaseOperationDialog.sizeTextField.text")); // NOI18N
        dataPanel.add(sizeTextField);

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dateLabel.setText(bundle.getString("CaseOperationDialog.dateLabel.text")); // NOI18N
        dataPanel.add(dateLabel);

        dateTextField.setEditable(false);
        dateTextField.setText(bundle.getString("CaseOperationDialog.dateTextField.text")); // NOI18N
        dataPanel.add(dateTextField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(progressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.caseOperations.stop();
    }//GEN-LAST:event_cancelButtonActionPerformed

    public void addLine(final String fileName) {
        File file = new File(fileName);
        
        fileTextField.setText(file.getAbsolutePath());
        sizeTextField.setText(String.valueOf(file.length()));
        dateTextField.setText(DateUtil.formatedDateWithTime(new Date(file.lastModified())));
    }
    
    public JProgressBar getProgressBar() {
        return this.progressBar;
    }
    
    public void hideDataPanel() {
        this.dataPanel.setVisible(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JLabel fileLabel;
    private javax.swing.JTextField fileTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JPanel progressPanel;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JTextField sizeTextField;
    // End of variables declaration//GEN-END:variables
}
