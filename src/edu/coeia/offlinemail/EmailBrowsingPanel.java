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

import edu.coeia.main.CaseMainFrame;
import edu.coeia.cases.Case;
import edu.coeia.cases.CaseFacade;
import edu.coeia.gutil.InfiniteProgressPanel;
import edu.coeia.gutil.JTableUtil;
import edu.coeia.gutil.GuiUtil;
import edu.coeia.viewer.SearchResultParamter;
import edu.coeia.viewer.SourceViewerDialog;
import edu.coeia.tasks.EmailLoadingTask;
import edu.coeia.tasks.EmailRefreshTask;
import edu.coeia.tasks.EmailProcessingTask;

import java.util.ArrayList;
import java.util.Collections;
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

    private final DefaultListModel emailSourcrListModel;
    private final List<Integer> documentIds = new ArrayList<Integer>();;
    
    private final CaseMainFrame caseFrame ;
    private final Case aCase ;    
    private final CaseFacade caseFacade ;

    public enum EMAIL_PROCESSING_TYPE { INBOX, SEND_ITEM, FREQUENCY } ;
    
    /** Creates new form OfflineEmailBrowsingPanel */
    public EmailBrowsingPanel(final JFrame frame) {
        initComponents();
        this.emailSourcrListModel = new DefaultListModel();
        this.caseFrame = (CaseMainFrame) frame;
        this.caseFacade = this.caseFrame.getCaseFacade();
        this.aCase =  this.caseFrame.getCaseFacade().getCase();
        
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
        
//        TableColumn tableColumn = this.emailsTable.getColumnModel().getColumn(3);
//        tableColumn.setCellRenderer(new LabelCellRenderer());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadingPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        emailSourceJList = new javax.swing.JList();
        loadEmailSourceButton = new javax.swing.JButton();
        refreshEmailSourceButton = new javax.swing.JButton();
        vewingPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        emailsTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        filterEmailsTextField = new javax.swing.JTextField();
        statisticsPanel = new javax.swing.JPanel();
        factorSelectionPanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox();
        processEmailButton = new javax.swing.JButton();
        visualizationButton = new javax.swing.JButton();
        cardsPanel = new javax.swing.JPanel();
        messagesResultPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        messageResultTable = new javax.swing.JTable();
        messagesDateResultPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        messagesDateResultTable = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        loadingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Email Sources"));

        jScrollPane1.setViewportView(emailSourceJList);

        loadEmailSourceButton.setText("Load Selected Email Source");
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

        javax.swing.GroupLayout loadingPanelLayout = new javax.swing.GroupLayout(loadingPanel);
        loadingPanel.setLayout(loadingPanelLayout);
        loadingPanelLayout.setHorizontalGroup(
            loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingPanelLayout.createSequentialGroup()
                .addGroup(loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadEmailSourceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshEmailSourceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                .addContainerGap())
        );
        loadingPanelLayout.setVerticalGroup(
            loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadingPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshEmailSourceButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadEmailSourceButton))
        );

        add(loadingPanel, java.awt.BorderLayout.WEST);

        vewingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Email Content"));

        emailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Subject", "From", "To", "Folder Name", "Date", "Has Attachment"
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
                .addComponent(filterEmailsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
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

        javax.swing.GroupLayout vewingPanelLayout = new javax.swing.GroupLayout(vewingPanel);
        vewingPanel.setLayout(vewingPanelLayout);
        vewingPanelLayout.setHorizontalGroup(
            vewingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vewingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vewingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        vewingPanelLayout.setVerticalGroup(
            vewingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vewingPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(vewingPanel, java.awt.BorderLayout.CENTER);

        statisticsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Email Statistics"));

        factorSelectionPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 70, 213));
        jLabel20.setText("Statistics For:");
        factorSelectionPanel.add(jLabel20);

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inbox", "Send Items", "Frequency" }));
        typeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboBoxActionPerformed(evt);
            }
        });
        factorSelectionPanel.add(typeComboBox);

        processEmailButton.setText("Process Email");
        processEmailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processEmailButtonActionPerformed(evt);
            }
        });
        factorSelectionPanel.add(processEmailButton);

        visualizationButton.setText("Visualization");
        visualizationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizationButtonActionPerformed(evt);
            }
        });
        factorSelectionPanel.add(visualizationButton);

        cardsPanel.setLayout(new java.awt.CardLayout());

        messagesResultPanel.setLayout(new java.awt.BorderLayout());

        messageResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "From", "To", "# No of Messages"
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
        messageResultTable.setFillsViewportHeight(true);
        jScrollPane3.setViewportView(messageResultTable);

        messagesResultPanel.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        cardsPanel.add(messagesResultPanel, "messageCard");

        messagesDateResultPanel.setLayout(new java.awt.BorderLayout());

        messagesDateResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "From", "To", "Month/Year", "#No of Messages"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        messagesDateResultTable.setFillsViewportHeight(true);
        jScrollPane4.setViewportView(messagesDateResultTable);

        messagesDateResultPanel.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        cardsPanel.add(messagesDateResultPanel, "messageDateCard");

        javax.swing.GroupLayout statisticsPanelLayout = new javax.swing.GroupLayout(statisticsPanel);
        statisticsPanel.setLayout(statisticsPanelLayout);
        statisticsPanelLayout.setHorizontalGroup(
            statisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statisticsPanelLayout.createSequentialGroup()
                .addComponent(cardsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 568, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(factorSelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        statisticsPanelLayout.setVerticalGroup(
            statisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(factorSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
            .addComponent(cardsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
        );

        add(statisticsPanel, java.awt.BorderLayout.SOUTH);
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
            SourceViewerDialog panel = new SourceViewerDialog(this.caseFrame, true, searchViewer);
            panel.setVisible(true);
        }
    }//GEN-LAST:event_emailsTableMouseClicked

    private void processEmailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processEmailButtonActionPerformed
        this.processEmail(this.getSelectedProcessingType());
    }//GEN-LAST:event_processEmailButtonActionPerformed

    private void refreshEmailSourceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshEmailSourceButtonActionPerformed
        // fill email source
        try {
            EmailRefreshTask task = new EmailRefreshTask(aCase, this);
            task.startTask();
        } catch (Exception ex) {
            Logger.getLogger(EmailBrowsingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshEmailSourceButtonActionPerformed

    private void typeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboBoxActionPerformed
        EMAIL_PROCESSING_TYPE type = this.getSelectedProcessingType();

        if ( type == EMAIL_PROCESSING_TYPE.INBOX ||
                type == EMAIL_PROCESSING_TYPE.SEND_ITEM) {
            GuiUtil.showPanel("messageCard", this.cardsPanel);
        }
        else {
            GuiUtil.showPanel("messageDateCard", this.cardsPanel);
        }
    }//GEN-LAST:event_typeComboBoxActionPerformed

    private void visualizationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizationButtonActionPerformed
        this.doVisualization();
    }//GEN-LAST:event_visualizationButtonActionPerformed

    private void doVisualization() {
        
    }
    
    private EMAIL_PROCESSING_TYPE getSelectedProcessingType() {
        String value = String.valueOf(this.typeComboBox.getSelectedItem());
        EMAIL_PROCESSING_TYPE type;  
        
        if ( value.equalsIgnoreCase("Inbox") ) {
           type =  EMAIL_PROCESSING_TYPE.INBOX;
        }
        else if ( value.equalsIgnoreCase("Send Items")) {
            type = EMAIL_PROCESSING_TYPE.SEND_ITEM;
        }
        else {
            type = EMAIL_PROCESSING_TYPE.FREQUENCY;
        }
        
        return type;
    }
    
    private void processEmail(final EMAIL_PROCESSING_TYPE type) {
        JTableUtil.removeAllRows(this.messageResultTable);
        JTableUtil.removeAllRows(this.messagesDateResultTable);
        
        EmailProcessingTask task = new EmailProcessingTask(type, this);
        task.startTask();
    }
    
    public boolean isOfflineEmailSelected() {
        Object selectedValue = this.getList().getSelectedValue();
        if ( selectedValue == null )
            return false;
        
        return String.valueOf(this.getList().getSelectedValue()).endsWith(".pst") ||
               String.valueOf(this.getList().getSelectedValue()).endsWith(".ost");
    }
    
    public boolean isOnlineEmailSelected() {
        Object selectedValue = this.getList().getSelectedValue();
        if ( selectedValue == null )
            return false;
        
        String value = String.valueOf(selectedValue);
        return !value.endsWith(".pst") && !value.endsWith(".ost");
    }
    
    private void showVisualization (String from, String to, PSTFile pst,
            String path, String title, String folderName,EmailVisualizationThread.FolderType type) {
        
        InfiniteProgressPanel i = new InfiniteProgressPanel(title);
        caseFrame.setGlassPane(i);
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
    public JTable getEmailProcessingTable() { return this.messageResultTable; }
    public JTable getEmailDateProcessingTable() { return this.messagesDateResultTable; }
    public CaseFacade getCaseFacade() { return this.caseFacade ; }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardsPanel;
    private javax.swing.JList emailSourceJList;
    private javax.swing.JTable emailsTable;
    private javax.swing.JPanel factorSelectionPanel;
    private javax.swing.JTextField filterEmailsTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton loadEmailSourceButton;
    private javax.swing.JPanel loadingPanel;
    private javax.swing.JTable messageResultTable;
    private javax.swing.JPanel messagesDateResultPanel;
    private javax.swing.JTable messagesDateResultTable;
    private javax.swing.JPanel messagesResultPanel;
    private javax.swing.JButton processEmailButton;
    private javax.swing.JButton refreshEmailSourceButton;
    private javax.swing.JPanel statisticsPanel;
    private javax.swing.JComboBox typeComboBox;
    private javax.swing.JPanel vewingPanel;
    private javax.swing.JButton visualizationButton;
    // End of variables declaration//GEN-END:variables
}
