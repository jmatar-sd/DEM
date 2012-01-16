/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ListFileTimeReportPanel.java
 *
 * Created on Jan 14, 2012, 8:17:44 AM
 */
package edu.coeia.reports;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wajdyessam
 */
public class FilesTimeReportPanel extends javax.swing.JPanel implements ReportGenerator {

    private ReportPanel reportPanel ;
    
    /** Creates new form ListFileTimeReportPanel */
    public FilesTimeReportPanel(ReportPanel panel) {
        initComponents();
        this.reportPanel = panel;
        
        toDatePanel.add(new JDateChooser(new Date()),BorderLayout.CENTER);
        fromDatePanel.add(new JDateChooser(new Date(0)),BorderLayout.CENTER); 
    }

    @Override
    public DatasourceXml generateReport() {
        DatasourceXml xmlSource= new DatasourceXml();
        Date from = ((JDateChooser) fromDatePanel.getComponent(0)).getDate();
        Date to   = ((JDateChooser) toDatePanel.getComponent(0)).getDate();
        
        String strXmlSource = "";
        
        try {
            xmlSource = RawResultFile.getFileSystemXmlFile(
                    IndexUtil.getAllFilesBetweenDates(this.reportPanel.getCase(), this.reportPanel.getCasePathHandler(),
                    from, to)
            ,this.reportPanel.getCase());
        } catch (IOException ex) {
            Logger.getLogger(FilesReportPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return xmlSource;
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
        jLabel4 = new javax.swing.JLabel();
        toDatePanel = new javax.swing.JPanel();
        fromDatePanel = new javax.swing.JPanel();

        jLabel1.setText("this report will display all the files that have specific creation date");

        jLabel2.setText("please specify the renge of dates");

        jLabel3.setText("From Date:");

        jLabel4.setText("to Date:");

        toDatePanel.setLayout(new java.awt.BorderLayout());

        fromDatePanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toDatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(fromDatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromDatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(toDatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fromDatePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel toDatePanel;
    // End of variables declaration//GEN-END:variables
}
