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
package edu.coeia.reports.panels;

import edu.coeia.reports.ReportPanel;
import edu.coeia.reports.DatasourceXml;
import edu.coeia.reports.IndexUtil;
import edu.coeia.reports.RawResultFile;
import edu.coeia.util.SizeUtil;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wajdyessam
 */
public class FilesSizeReportPanel extends javax.swing.JPanel implements ReportGenerator{

    private ReportPanel reportPanel ;
    
    /** Creates new form ListFilesSizeReportPanel */
    public FilesSizeReportPanel(ReportPanel panel) {
        initComponents();
        this.reportPanel = panel;
    }

    @Override
    public DatasourceXml generateReport() {
        DatasourceXml objXmlSource = new DatasourceXml();
        
        long from = (long) SizeUtil.fromMBtoByte(Long.valueOf(this.fromSizeTextField.getText().trim()));
        long to = (long) SizeUtil.fromMBtoByte(Long.valueOf(this.toSizeTextField.getText().trim()));
        
        try {
            objXmlSource = RawResultFile.getFileSystemXmlFile(
                    IndexUtil.getAllFilesBetweenSize(this.reportPanel.getCaseFacade(),
                    from, to)
            ,this.reportPanel.getCaseFacade());
        } catch (IOException ex) {
            Logger.getLogger(FilesReportPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return objXmlSource;
    }
        
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fromSizeTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        toSizeTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setText("this report will display all the files that have specific file size ");

        jLabel2.setText("please specify range if you want to filter the result depend of some size");

        jLabel3.setText("From Size:");

        fromSizeTextField.setText(" ");
        fromSizeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromSizeTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("MB");

        jLabel5.setText("to Size:");

        toSizeTextField.setText(" ");

        jLabel6.setText("MB");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(toSizeTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fromSizeTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fromSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(toSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void fromSizeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromSizeTextFieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_fromSizeTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fromSizeTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField toSizeTextField;
    // End of variables declaration//GEN-END:variables
}
