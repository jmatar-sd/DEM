/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EmailSourceViewerPanel.java
 *
 * Created on Dec 3, 2011, 2:37:27 PM
 */
package edu.coeia.viewer;

import edu.coeia.indexing.IndexingConstant;
import edu.coeia.searching.LuceneSearcher;
import edu.coeia.util.Utilities;

import java.awt.BorderLayout;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import org.apache.lucene.document.Document;

/**
 *
 * @author wajdyessam
 */
class OnlineEmailSourceViewerPanel extends javax.swing.JPanel {

    private Document document ;
    
    private String keyword ;
    private SourceViewerDialog dialog ;
    private LuceneSearcher searcher ;
    private String currentId ;
    
    private JWebBrowser emailContentBrowser = new JWebBrowser();
    
    /** Creates new form EmailSourceViewerPanel */
    public OnlineEmailSourceViewerPanel(SourceViewerDialog dialog) {
        initComponents();
        
        this.dialog = dialog;
        this.keyword = dialog.getQueryString();
        this.searcher = dialog.getLuceneSearch();
        this.currentId = dialog.getCurrentId() ;
        
        try {
             this.document = this.searcher.getLuceneDocumentById(String.valueOf(this.currentId));
             //this.parentDocument = this.searcher.getParentDocument(this.document.get(IndexingConstant.DOCUMENT_PARENT_ID));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        // add file browser
        emailContentBrowser.setBarsVisible(false);
        emailContentBrowser.setStatusBarVisible(false);
        messagePanel.add(emailContentBrowser, BorderLayout.CENTER); 
        
        displayDocumentInformation();
    }
    
    private void displayDocumentInformation () {
        try {
            // show file properities
            String emailAgent = this.document.get(IndexingConstant.ONLINE_EMAIL_FOLDER_NAME);
            String emailSource = this.document.get(IndexingConstant.ONLINE_EMAIL_FROM);
            String emailDate = this.document.get(IndexingConstant.ONLINE_EMAIL_SENT_DATE);
            String emailMessage = this.document.get(IndexingConstant.ONLINE_EMAIL_BODY);
            String emailSubject = this.document.get(IndexingConstant.ONLINE_EMAIL_SUBJECT);
            
            String emailTo = this.document.get(IndexingConstant.ONLINE_EMAIL_TO);
            String emailFrom = this.document.get(IndexingConstant.ONLINE_EMAIL_FROM);
            String emailCC = this.document.get(IndexingConstant.ONLINE_EMAIL_CC);
            String emailBCC = this.document.get(IndexingConstant.ONLINE_EMAIL_BCC);
            
            this.emailAgentTextField.setText(emailAgent);
            this.emailSourceTextField.setText(emailSource);
            this.messageDateTextFeild.setText(emailDate);
            this.messageTextField.setText(emailSubject);
            this.emailToTextField.setText(emailTo);
            this.emailFromTextField.setText(emailFrom);
            this.ccTextField.setText(emailCC);
            this.bccTextField.setText(emailBCC);
            
            // Show File Content
            emailContentBrowser.setHTMLContent(Utilities.highlightString(emailMessage, this.keyword));
            messagePanel.validate();
        }
        catch(Exception e) {
            e.printStackTrace();
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

        viewPanel = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        messagePanel = new javax.swing.JPanel();
        emailRenderPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        emailTable = new javax.swing.JTable();
        emailMetaDataPanel = new javax.swing.JPanel();
        jScrollPane28 = new javax.swing.JScrollPane();
        metaDataTextArea = new javax.swing.JTextArea();
        properitiesPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        emailAgentTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        emailSourceTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        messageDateTextFeild = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        messageTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emailFromTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        emailToTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ccTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bccTextField = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        messagePanel.setLayout(new java.awt.BorderLayout());
        jTabbedPane2.addTab("Message Content", messagePanel);

        emailRenderPanel.setLayout(new java.awt.BorderLayout());

        emailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "From", "To", "Date", "Message"
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
        emailTable.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(emailTable);

        emailRenderPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Conversation", emailRenderPanel);

        metaDataTextArea.setColumns(20);
        metaDataTextArea.setFont(new java.awt.Font("Tahoma", 0, 14));
        metaDataTextArea.setRows(5);
        jScrollPane28.setViewportView(metaDataTextArea);

        javax.swing.GroupLayout emailMetaDataPanelLayout = new javax.swing.GroupLayout(emailMetaDataPanel);
        emailMetaDataPanel.setLayout(emailMetaDataPanelLayout);
        emailMetaDataPanelLayout.setHorizontalGroup(
            emailMetaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane28, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        );
        emailMetaDataPanelLayout.setVerticalGroup(
            emailMetaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane28, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("MetaData", emailMetaDataPanel);

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addContainerGap())
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(viewPanel, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Email Agent:");

        emailAgentTextField.setEditable(false);
        emailAgentTextField.setText(" ");

        jLabel2.setText("Email Source:");

        emailSourceTextField.setEditable(false);
        emailSourceTextField.setText(" ");

        jLabel3.setText(" Date:");

        messageDateTextFeild.setEditable(false);
        messageDateTextFeild.setText(" ");

        jLabel4.setText("Subject:");

        messageTextField.setEditable(false);
        messageTextField.setText(" ");

        jLabel5.setText(" From:");

        emailFromTextField.setEditable(false);
        emailFromTextField.setText(" ");

        jLabel6.setText(" To:");

        emailToTextField.setEditable(false);
        emailToTextField.setText(" ");

        jLabel7.setText("CC:");

        ccTextField.setEditable(false);
        ccTextField.setText(" ");

        jLabel8.setText("BCC:");

        bccTextField.setEditable(false);
        bccTextField.setText(" ");

        javax.swing.GroupLayout properitiesPanelLayout = new javax.swing.GroupLayout(properitiesPanel);
        properitiesPanel.setLayout(properitiesPanelLayout);
        properitiesPanelLayout.setHorizontalGroup(
            properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(properitiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(messageDateTextFeild, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(emailSourceTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(emailAgentTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(emailFromTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(emailToTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(ccTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(bccTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
                .addContainerGap())
        );
        properitiesPanelLayout.setVerticalGroup(
            properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(properitiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(emailAgentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(emailSourceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(messageDateTextFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(emailFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(emailToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(bccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(properitiesPanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bccTextField;
    private javax.swing.JTextField ccTextField;
    private javax.swing.JTextField emailAgentTextField;
    private javax.swing.JTextField emailFromTextField;
    private javax.swing.JPanel emailMetaDataPanel;
    private javax.swing.JPanel emailRenderPanel;
    private javax.swing.JTextField emailSourceTextField;
    private javax.swing.JTable emailTable;
    private javax.swing.JTextField emailToTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField messageDateTextFeild;
    private javax.swing.JPanel messagePanel;
    private javax.swing.JTextField messageTextField;
    private javax.swing.JTextArea metaDataTextArea;
    private javax.swing.JPanel properitiesPanel;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
