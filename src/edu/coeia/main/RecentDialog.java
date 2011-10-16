/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Recentdialog.java
 *
 * Created on Jul 22, 2010, 10:54:14 AM
 */

package edu.coeia.main;

/**
 *
 * @author wajdyessam
 */

import edu.coeia.util.Utilities ;
import edu.coeia.util.FilesPath ;
import edu.coeia.internet.IEHandler ;

import java.util.ArrayList ;
import java.text.SimpleDateFormat ;
import java.io.File ;
import javax.swing.table.DefaultTableModel ;

public class RecentDialog extends javax.swing.JDialog {

    /** Creates new form Recentdialog */
    public RecentDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(parent);
        setTitle("Recent Documents");
        
        fillTable();
    }

    private void fillTable () {
        ArrayList<String> filesName = new ArrayList<String>();
        String path = FilesPath.RECENT ;
        IEHandler.getFiles(new File(path) , filesName);
        SimpleDateFormat sdf = new SimpleDateFormat("d/m/yyyy    hh:mm:ss");

        // remove old data
        if ( recentFilesTable.getModel().getRowCount() > 0 )
             Utilities.removeAllRows(recentFilesTable);

        for (int i=0; i<filesName.size() ; i++){
            File file = new File( filesName.get(i) );

            ( (DefaultTableModel) recentFilesTable.getModel() ).addRow(
                    new Object[] { file.getName(), sdf.format(file.lastModified()), file.getAbsolutePath() } );
        }

        // Pack the all columns of the table
        int margin = 1;
        Utilities.packColumns(recentFilesTable, margin);

        Utilities.sortTable(recentFilesTable,1);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane12 = new javax.swing.JScrollPane();
        recentFilesTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        recentFilesTable.setAutoCreateRowSorter(true);
        recentFilesTable.setFont(new java.awt.Font("Tahoma", 1, 11));
        recentFilesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "NAME","ACCESS TIME","PATH"
            }
        ));
        recentFilesTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane12.setViewportView(recentFilesTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RecentDialog dialog = new RecentDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JTable recentFilesTable;
    // End of variables declaration//GEN-END:variables

}
