/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConnectedSearchPanel.java
 *
 * Created on Oct 22, 2011, 8:18:10 AM
 */
package edu.coeia.searching;

import edu.coeia.cases.Case;
import edu.coeia.gutil.JTableUtil;
import edu.coeia.items.FileItem;
import edu.coeia.items.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author wajdyessam
 */
public class ConnectedSearchPanel extends javax.swing.JPanel {
    private JFrame parentFrame ;
    private CaseSearchPanel parentPanel ;
    private SearchResultPanel searchResultPanel;
    
    /** Creates new form ConnectedSearchPanel */
    public ConnectedSearchPanel(Case aIndex, JFrame aParentFrame, JPanel parentPanel) {
        initComponents();
        
        this.parentPanel = (CaseSearchPanel) parentPanel;
        this.parentFrame = aParentFrame;
        
        this.searchResultPanel = new SearchResultPanel(parentFrame);
        this.CenterPanel.removeAll();
        this.CenterPanel.add(this.searchResultPanel);
        this.CenterPanel.revalidate();
    }

    void updateSavedSearchTable() {
        List<CaseSearchPanel.SearchHistory> options = this.parentPanel.getSearchOptions();
        JTableUtil.removeAllRows(this.savedSearchTable);
        this.resetOptionsLabel();
        
        for(int i=0; i<options.size(); i++) {
            Object[] obj = { "Result #" + (i+1) , false };
            JTableUtil.addRowToJTable(this.savedSearchTable, obj);
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

        LeftPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        savedSearchTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        connectedSearchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        scopeTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        noOfItemsTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dateTextField = new javax.swing.JTextField();
        CenterPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        headerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Saved Search Result"));

        savedSearchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Search Result", "Included"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        savedSearchTable.setFillsViewportHeight(true);
        savedSearchTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                savedSearchTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(savedSearchTable);

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Options"));

        connectedSearchButton.setText("Connected Search");
        connectedSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectedSearchButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Search Name:");

        searchNameTextField.setEditable(false);
        searchNameTextField.setText(" ");

        jLabel2.setText("Scope:");

        scopeTextField.setEditable(false);
        scopeTextField.setText(" ");

        jLabel3.setText("# of Items:");

        noOfItemsTextField.setEditable(false);
        noOfItemsTextField.setText(" ");

        jLabel4.setText("Date:");

        dateTextField.setEditable(false);
        dateTextField.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(connectedSearchButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scopeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(searchNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(noOfItemsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(dateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(scopeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(noOfItemsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(connectedSearchButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(LeftPanel, java.awt.BorderLayout.WEST);

        CenterPanel.setLayout(new java.awt.BorderLayout());
        add(CenterPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void savedSearchTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savedSearchTableMouseClicked
        int row = this.savedSearchTable.getSelectedRow();
        if ( row < 0 )
            return;
        
        CaseSearchPanel.SearchHistory option = this.parentPanel.getSearchOptions().get(row);
        fillOptionsLabel(option);
    }//GEN-LAST:event_savedSearchTableMouseClicked

    private void connectedSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectedSearchButtonActionPerformed
        JTableUtil.removeAllRows(this.searchResultPanel.getSearchTable());
        
        List<Integer> indexs = this.getSavedSearchSelectedRowIndexes();
        Set<Item> items = new HashSet<Item>();
        
        for(int index: indexs) {
            CaseSearchPanel.SearchHistory option = this.parentPanel.getSearchOptions().get(index);
            
            for(Item item: option.documents) {
                items.add(item);
            }
        }
        
        List<Integer> ids = new ArrayList<Integer>();
        for(Item item: items) {
           FileItem fileItem = (FileItem) item;
           
           Object[] data = {
               fileItem.getDocumentId(), fileItem.getFilePath(),fileItem.getFileDate(),
               "FILE", fileItem.getFileName()
           };
           
           JTableUtil.addRowToJTable(this.searchResultPanel.getSearchTable(), data);
           ids.add(fileItem.getDocumentId());
        }
        
        // set keywords and documentids
        this.searchResultPanel.setQueryText(items.toString());
        this.searchResultPanel.setResultIds(ids);
    }//GEN-LAST:event_connectedSearchButtonActionPerformed

    private List<Integer> getSavedSearchSelectedRowIndexes() {
        int rows = this.savedSearchTable.getRowCount();
        
        List<Integer> indexOfSelectedRows = new ArrayList<Integer>();
        for(int i=0; i<rows; i++) {
            int row = i;
            boolean status = Boolean.valueOf(String.valueOf(this.savedSearchTable.getValueAt(row, 1)));
            
            if ( status ) {
                indexOfSelectedRows.add(row);
            }
        }
        
        return indexOfSelectedRows;
    }
    
    private void fillOptionsLabel(final CaseSearchPanel.SearchHistory option) {
        this.searchNameTextField.setText(option.query);
        this.scopeTextField.setText(option.scope.toString());
        this.dateTextField.setText(option.time);
        this.noOfItemsTextField.setText(String.valueOf(option.documents.size()));
    }
    
    private void resetOptionsLabel() {
        this.searchNameTextField.setText("");
        this.scopeTextField.setText("");
        this.dateTextField.setText("");
        this.noOfItemsTextField.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CenterPanel;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JButton connectedSearchButton;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField noOfItemsTextField;
    private javax.swing.JTable savedSearchTable;
    private javax.swing.JTextField scopeTextField;
    private javax.swing.JTextField searchNameTextField;
    // End of variables declaration//GEN-END:variables
}
