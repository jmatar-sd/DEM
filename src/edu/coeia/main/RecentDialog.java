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
package edu.coeia.main;

/**
 *
 * @author wajdyessam
 */

import edu.coeia.constants.OpreatingSystemConstants;
import edu.coeia.gutil.JTableUtil;
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
        String path = OpreatingSystemConstants.RECENT ;
        IEHandler.getFiles(new File(path) , filesName);
        SimpleDateFormat sdf = new SimpleDateFormat("d/m/yyyy    hh:mm:ss");

        // remove old data
        if ( recentFilesTable.getModel().getRowCount() > 0 )
             JTableUtil.removeAllRows(recentFilesTable);

        for (int i=0; i<filesName.size() ; i++){
            File file = new File( filesName.get(i) );

            ( (DefaultTableModel) recentFilesTable.getModel() ).addRow(
                    new Object[] { file.getName(), sdf.format(file.lastModified()), file.getAbsolutePath() } );
        }

        // Pack the all columns of the table
        int margin = 1;
        JTableUtil.packColumns(recentFilesTable, margin);

        JTableUtil.sortTable(recentFilesTable,1);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JTable recentFilesTable;
    // End of variables declaration//GEN-END:variables

}
