/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ListFileAutherReportPanel.java
 *
 * Created on Jan 14, 2012, 8:17:57 AM
 */
package edu.coeia.reports;

/**
 *
 * @author wajdyessam
 */
public class ListFileAutherReportPanel extends javax.swing.JPanel implements ReportGenerator{

    /** Creates new form ListFileAutherReportPanel */
    public ListFileAutherReportPanel() {
        initComponents();
    }
    
    @Override
    public String generateReport() {
        return "list of file authers";
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
