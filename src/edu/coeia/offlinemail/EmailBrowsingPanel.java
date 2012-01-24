/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * OfflineEmailBrowsingPanel.java
 *
 * Created on Jan 9, 2012, 11:44:37 AM
 */
package edu.coeia.offlinemail;

import edu.coeia.cases.Case;
import edu.coeia.cases.CasePathHandler;
import edu.coeia.gutil.InfiniteProgressPanel;
import edu.coeia.gutil.JTableUtil;
import edu.coeia.main.CaseFrame;
import edu.coeia.task.EmailLoadingTask;
import edu.coeia.task.EmailRefreshTask;
import edu.coeia.viewer.SearchResultParamter;
import edu.coeia.viewer.SourceViewerDialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.pff.PSTFile;

/**
 *
 * @author wajdyessam
 */
public class EmailBrowsingPanel extends javax.swing.JPanel {

    private Case aCase;
    private DefaultListModel emailSourcrListModel;
    private final List<Integer> documentIds = new ArrayList<Integer>();
    private JFrame parentFrame ;
    
    /** Creates new form OfflineEmailBrowsingPanel */
    public EmailBrowsingPanel(final Case aCase, final CaseFrame frame) {
        initComponents();
        this.emailSourcrListModel = new DefaultListModel();
        this.aCase = aCase;
        this.parentFrame = (JFrame) frame;
        
        /**
         * Filter email table by keyword written into filter text field
         */
        this.filterEmailsTextField.getDocument().addDocumentListener(
            new DocumentListener() {
                @Override
                public void changedUpdate(DocumentEvent event) { filterTable(); }

                @Override
                public void removeUpdate(DocumentEvent event) { filterTable(); }

                @Override
                public void insertUpdate(DocumentEvent event) { filterTable(); }
                
                private void filterTable() {
                     JTableUtil.filterTable(emailsTable, filterEmailsTextField.getText().trim());
                }
            }
        );
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        emailSourceJList = new javax.swing.JList();
        loadEmailSourceButton = new javax.swing.JButton();
        refreshEmailSourceButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        emailsTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        filterEmailsTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        factorSelectionPanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        correlationComboBox = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Email Sources"));

        jScrollPane1.setViewportView(emailSourceJList);

        loadEmailSourceButton.setText("Load Selecte dEmail Source");
        loadEmailSourceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadEmailSourceButtonActionPerformed(evt);
            }
        });

        refreshEmailSourceButton.setText("Refresh Email Source");
        refreshEmailSourceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshEmailSourceButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadEmailSourceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshEmailSourceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshEmailSourceButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadEmailSourceButton))
        );

        add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Email Content"));

        emailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Folder Name", "From", "To", "Subject", "Date", "Has Attachment"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        emailsTable.setFillsViewportHeight(true);
        emailsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(emailsTable);

        jLabel1.setText("Filter:");

        filterEmailsTextField.setText(" ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterEmailsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filterEmailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Email Statistics"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sender", "Reciever", "Number of Messages"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFillsViewportHeight(true);
        jScrollPane3.setViewportView(jTable1);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel20.setForeground(new java.awt.Color(0, 70, 213));
        jLabel20.setText("Statistics For:");
        factorSelectionPanel.add(jLabel20);

        correlationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inbox Folder", "Send Items Folder", "Messages Domain Name ", "Messages Origin Country", "Messages Frequency" }));
        factorSelectionPanel.add(correlationComboBox);

        jButton1.setText("Process Email");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        factorSelectionPanel.add(jButton1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
            .addComponent(factorSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(factorSelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel4, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void loadEmailSourceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadEmailSourceButtonActionPerformed
        JTableUtil.removeAllRows(this.emailsTable);
        EmailLoadingTask task = new EmailLoadingTask(aCase, this);
        task.startTask();
    }//GEN-LAST:event_loadEmailSourceButtonActionPerformed

    private void emailsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailsTableMouseClicked
        if ( evt.getClickCount() == 2 ) { // Double Click
            // other click event
            int row = this.emailsTable.getSelectedRow();
            if ( row < 0 ) return ; // if not select row

            String fileId = String.valueOf(this.emailsTable.getValueAt(row, 0));
            int currentId = Integer.parseInt(fileId);

            SearchResultParamter searchViewer = new SearchResultParamter("",currentId, this.documentIds);
            SourceViewerDialog panel = new SourceViewerDialog(this.parentFrame, true, searchViewer);
            panel.setVisible(true);
        }
    }//GEN-LAST:event_emailsTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.processEmail();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void refreshEmailSourceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshEmailSourceButtonActionPerformed
        // fill email source
        try {
            EmailRefreshTask task = new EmailRefreshTask(aCase, this);
            task.startTask();
        } catch (Exception ex) {
            Logger.getLogger(EmailBrowsingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshEmailSourceButtonActionPerformed

    private void processEmail() {
        // from date to date
        String from = new Date().toString();
        String to   = new Date().toString();

      // if ( !isOfflineEmailSelected() )
          // return;
       
        String path = String.valueOf(this.emailSourceJList.getSelectedValue());
        
        try {
            CasePathHandler handler = CasePathHandler.newInstance(this.aCase.getCaseLocation());
            handler.readConfiguration();
            path = handler.getFullPath(path);
        
            PSTFile pstFile = new PSTFile(path);

            int selectedIndex = correlationComboBox.getSelectedIndex();

            switch ( selectedIndex ) {
                case 0 :
                    showVisualization(from, to, pstFile, path, "Inbox Visualization...",
                            "Inbox", EmailVisualizationThread.FolderType.INBOX);
                    break;

                case 1 :
                    showVisualization(from, to, pstFile, path, "Sent Items Visualization...",
                            "Sent Items", EmailVisualizationThread.FolderType.SENT);
                    break;

                case 2 :
                    showVisualization(from, to, pstFile, path, "Email Service Provider Visualization...",
                            "ESP", EmailVisualizationThread.FolderType.ESP);
                    break;

                case 3 :
                    showVisualization(from, to, pstFile, path, "Location Visualization...",
                            "Location", EmailVisualizationThread.FolderType.LOCATION);
                    break;

                case 4 :
                    showVisualization(from, to, pstFile, path, "Messages Communication Visualization...",
                            "Frequency", EmailVisualizationThread.FolderType.FREQUENCY);
                    break;
            }
        } 
        catch (Exception e){
           e.printStackTrace();
        }
    }
    
    private void showVisualization (String from, String to, PSTFile pst,
            String path, String title, String folderName,EmailVisualizationThread.FolderType type) {
        
        InfiniteProgressPanel i = new InfiniteProgressPanel(title);
        parentFrame.setGlassPane(i);
        i.start();

        EmailVisualizationThread thread = new EmailVisualizationThread(null, i, folderName , pst, path, from, to, type);
        thread.execute();
    }
    
    public void setResultIds(final List<Integer> ids) {
        this.documentIds.clear();
        this.documentIds.addAll(Collections.unmodifiableList(ids));
    }
        
    public JList getList() { return this.emailSourceJList ;}
    public DefaultListModel getModel() { return this.emailSourcrListModel ; }
    public JTable getTable() { return this.emailsTable; }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox correlationComboBox;
    private javax.swing.JList emailSourceJList;
    private javax.swing.JTable emailsTable;
    private javax.swing.JPanel factorSelectionPanel;
    private javax.swing.JTextField filterEmailsTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton loadEmailSourceButton;
    private javax.swing.JButton refreshEmailSourceButton;
    // End of variables declaration//GEN-END:variables
}
