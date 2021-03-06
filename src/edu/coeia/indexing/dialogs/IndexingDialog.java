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
package edu.coeia.indexing.dialogs;

import edu.coeia.cases.CaseFacade;
import edu.coeia.constants.ResourceManager;
import edu.coeia.gutil.GuiUtil;
import edu.coeia.indexing.IndexingService;
import edu.coeia.util.ApplicationLogging;
import java.awt.ComponentOrientation;
import java.awt.Cursor;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.IOException;
import java.util.Locale;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wajdyessam
 */
public final class IndexingDialog extends javax.swing.JDialog {

    private final CaseFacade caseFacade;
    
    private final EmailCrawlingProgressPanel emailCrawlingPanel ;
    private final FileSystemCrawlingProgressPanel fileSystemCrawlingPanel;
    
    private final static String EMAIL_PANEL = "EMAIL";
    private final static String FILE_PANEL = "FILE";
    
    //private CrawlerIndexerThread indexerThread ;
    private IndexingService indexingService;
    
    private boolean detailPanelAppearenceFlag;
    
    private final static Logger logger = ApplicationLogging.getLogger();
    
    /** Creates new form IndexingDialog */
    public IndexingDialog(java.awt.Frame parent, boolean modal,
            final CaseFacade caseFacade, boolean startIndexNow) {
        
        super(parent, modal);         
        initComponents();     
        
        this.applyComponentOrientation(ComponentOrientation.getOrientation(ResourceManager.getLanguage()));
        
        this.emailCrawlingPanel = new EmailCrawlingProgressPanel();
        this.fileSystemCrawlingPanel = new FileSystemCrawlingProgressPanel();
        this.caseFacade = caseFacade;
        
        this.addCardsPanel();
        GuiUtil.showPanel(FILE_PANEL, this.objectPanel);
        
        this.hideDetailsPanel();
        this.resettingButtons(true);
        
        this.closeCralwingWhenCloseTheWindow();
        
        if ( startIndexNow ) {
            this.startCrawling();
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

        indexPanel = new javax.swing.JPanel();
        progressStatusPanel = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numberOfItemsInIndexTextField = new javax.swing.JTextField();
        numberOfItemsCannotIndexedTextField = new javax.swing.JTextField();
        numberOfScannedItemsTextField = new javax.swing.JTextField();
        sizeOfScannedItemsTextField = new javax.swing.JTextField();
        progressBarPanel = new javax.swing.JPanel();
        progressBar = new javax.swing.JProgressBar();
        indexControlPanel = new javax.swing.JPanel();
        startIndexButton = new javax.swing.JButton();
        stopIndexingButton = new javax.swing.JButton();
        displayItemDetialButton = new javax.swing.JButton();
        objectPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("edu/coeia/indexing/dialogs/Bundle"); // NOI18N
        setTitle(bundle.getString("IndexingDialog.title")); // NOI18N
        setMaximumSize(new java.awt.Dimension(550, 550));

        indexPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        indexPanel.setMaximumSize(new java.awt.Dimension(550, 550));
        indexPanel.setLayout(new javax.swing.BoxLayout(indexPanel, javax.swing.BoxLayout.PAGE_AXIS));

        progressStatusPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("IndexingDialog.progressStatusPanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        progressStatusPanel.setMaximumSize(new java.awt.Dimension(550, 142));
        progressStatusPanel.setMinimumSize(new java.awt.Dimension(550, 142));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText(bundle.getString("IndexingDialog.jLabel27.text")); // NOI18N

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText(bundle.getString("IndexingDialog.jLabel41.text")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText(bundle.getString("IndexingDialog.jLabel1.text")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText(bundle.getString("IndexingDialog.jLabel2.text")); // NOI18N

        numberOfItemsInIndexTextField.setEditable(false);
        numberOfItemsInIndexTextField.setText(bundle.getString("IndexingDialog.numberOfItemsInIndexTextField.text")); // NOI18N

        numberOfItemsCannotIndexedTextField.setEditable(false);
        numberOfItemsCannotIndexedTextField.setText(bundle.getString("IndexingDialog.numberOfItemsCannotIndexedTextField.text")); // NOI18N

        numberOfScannedItemsTextField.setEditable(false);
        numberOfScannedItemsTextField.setText(bundle.getString("IndexingDialog.numberOfScannedItemsTextField.text")); // NOI18N

        sizeOfScannedItemsTextField.setEditable(false);
        sizeOfScannedItemsTextField.setText(bundle.getString("IndexingDialog.sizeOfScannedItemsTextField.text")); // NOI18N

        javax.swing.GroupLayout progressStatusPanelLayout = new javax.swing.GroupLayout(progressStatusPanel);
        progressStatusPanel.setLayout(progressStatusPanelLayout);
        progressStatusPanelLayout.setHorizontalGroup(
            progressStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressStatusPanelLayout.createSequentialGroup()
                .addGroup(progressStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(jLabel27)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(progressStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numberOfItemsInIndexTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addComponent(numberOfScannedItemsTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addComponent(sizeOfScannedItemsTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addComponent(numberOfItemsCannotIndexedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
                .addContainerGap())
        );
        progressStatusPanelLayout.setVerticalGroup(
            progressStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressStatusPanelLayout.createSequentialGroup()
                .addGroup(progressStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(numberOfItemsInIndexTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(progressStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(numberOfItemsCannotIndexedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(progressStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfScannedItemsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(progressStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sizeOfScannedItemsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        indexPanel.add(progressStatusPanel);

        progressBarPanel.setMaximumSize(new java.awt.Dimension(550, 14));
        progressBarPanel.setLayout(new javax.swing.BoxLayout(progressBarPanel, javax.swing.BoxLayout.PAGE_AXIS));
        progressBarPanel.add(progressBar);

        indexPanel.add(progressBarPanel);

        indexControlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        indexControlPanel.setMaximumSize(new java.awt.Dimension(550, 70));

        startIndexButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        startIndexButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/new-edit-find-replace.png"))); // NOI18N
        startIndexButton.setText(bundle.getString("IndexingDialog.startIndexButton.text")); // NOI18N
        startIndexButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startIndexButtonActionPerformed(evt);
            }
        });
        indexControlPanel.add(startIndexButton);

        stopIndexingButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        stopIndexingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/cancel.png"))); // NOI18N
        stopIndexingButton.setText(bundle.getString("IndexingDialog.stopIndexingButton.text")); // NOI18N
        stopIndexingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopIndexingButtonActionPerformed(evt);
            }
        });
        indexControlPanel.add(stopIndexingButton);

        displayItemDetialButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        displayItemDetialButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/1274599246_text-x-log.png"))); // NOI18N
        displayItemDetialButton.setText(bundle.getString("IndexingDialog.displayItemDetialButton.text")); // NOI18N
        displayItemDetialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayItemDetialButtonActionPerformed(evt);
            }
        });
        indexControlPanel.add(displayItemDetialButton);

        indexPanel.add(indexControlPanel);

        objectPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("IndexingDialog.objectPanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        objectPanel.setMaximumSize(new java.awt.Dimension(550, 550));
        objectPanel.setLayout(new java.awt.CardLayout());
        indexPanel.add(objectPanel);

        getContentPane().add(indexPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startIndexButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startIndexButtonActionPerformed
        try {
            startIndexerThread();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_startIndexButtonActionPerformed

    private void stopIndexingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopIndexingButtonActionPerformed
        try {
            stopIndexerThread();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_stopIndexingButtonActionPerformed

    private void displayItemDetialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayItemDetialButtonActionPerformed
        this.detailPanelAppearenceFlag = !detailPanelAppearenceFlag;
        this.showDetailPanel(detailPanelAppearenceFlag);
    }//GEN-LAST:event_displayItemDetialButtonActionPerformed
   
    public void hideIndexingDialog() {
        this.dispose();
    }
    
    /**
     * Update the GUI label
     * 
     * this code can be work from EDT and other Threads
     * 
     * @param numberOfItemsIndexed
     * @param noItemsCannotIndexed 
     */
    public void updateStatus(final CrawlerStatistics crawlerStatistics) {
        Runnable task = new Runnable() {
          @Override
          public void run() {
              numberOfItemsInIndexTextField.setText(String.valueOf(crawlerStatistics.getNumberOfIndexedItems()));
              numberOfItemsCannotIndexedTextField.setText(String.valueOf(crawlerStatistics.getNumberOfErrorItems()));
              numberOfScannedItemsTextField.setText(String.valueOf(crawlerStatistics.getNumberOfScannedItems()));
              sizeOfScannedItemsTextField.setText(String.valueOf(crawlerStatistics.getSizeOfScannedItems()));
          }
        };
        
        if ( EventQueue.isDispatchThread() )
            task.run();
        else
            EventQueue.invokeLater(task);
        
//        numberOfItemsInIndexTextField.setText(String.valueOf(crawlerStatistics.getNumberOfIndexedItems()));
//        numberOfItemsCannotIndexedTextField.setText(String.valueOf(crawlerStatistics.getNumberOfErrorItems()));
//        numberOfScannedItemsTextField.setText(String.valueOf(crawlerStatistics.getNumberOfScannedItems()));
//        sizeOfScannedItemsTextField.setText(String.valueOf(crawlerStatistics.getSizeOfScannedItems()));
    }
    
    /**
     * Change the current panel in card to file system crawling panel
     * this method can be called form any methods including EDT
     * 
     * @param data 
     */
    public void showFileSystemPanel(final FileSystemCrawlingProgressPanel.FileSystemCrawlerData data) {
        Runnable task = new Runnable() { 
            @Override
            public void run() {
                fileSystemCrawlingPanel.setCurrentFile(data.getFileName());
                fileSystemCrawlingPanel.setFileExtension(data.getFileExtension());
                fileSystemCrawlingPanel.setFileSize(data.getFileSize());
                fileSystemCrawlingPanel.setFileDate(data.getFileDate());
                fileSystemCrawlingPanel.setEmbeddedDocuments(data.getEmbeddedDocuments());
                GuiUtil.showPanel(FILE_PANEL, objectPanel);
            }
        };
        
        if ( EventQueue.isDispatchThread())
            task.run();
        else
            EventQueue.invokeLater(task);
    }
    
    // called from other threads, must workin on EDT
    public void showEmailPanel(final EmailCrawlingProgressPanel.EmailCrawlingData data) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                emailCrawlingPanel.setAgentType(data.getAgentType());
                emailCrawlingPanel.setCurrentFolder(data.getCurrentFolder());
                emailCrawlingPanel.setCurrentMessageSubject(data.getSubject());
                emailCrawlingPanel.setMessageDate(data.getDate());
                emailCrawlingPanel.setFrom(data.getFrom());
                emailCrawlingPanel.setTo(data.getTo());
                emailCrawlingPanel.setAttachment(data.getAttachments());
                GuiUtil.showPanel(EMAIL_PANEL, objectPanel);
            }
        });
    }
   
    public CaseFacade getCaseFacade() { 
        return this.caseFacade;
    }
    
    public void clearFields() {
        assert EventQueue.isDispatchThread();
        
        this.progressBar.setValue(0);
        this.progressBar.setStringPainted(false);
        this.progressBar.setIndeterminate(false);
        this.startIndexButton.setEnabled(true);
        this.stopIndexingButton.setEnabled(false);
    }
    
    private void showDetailPanel(boolean flag) {
        this.objectPanel.setVisible(flag);
        
        if ( flag )
            this.setSize(520,580);
        else
            this.setSize(520,280);
    }
    
    private void startIndexerThread () throws Exception{
        resettingButtons(false);
        this.progressBar.setIndeterminate(true);

        Thread thread = new Thread(
            new Runnable() {
                @Override
                public void run() {
                    try {
                        indexingService = new IndexingService(IndexingDialog.this);
                        indexingService.startService();
                    } catch (Exception ex) {
                        Logger.getLogger(IndexingDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        );
        
        thread.start();
    }
    
    private void stopIndexerThread() throws Exception {
        if ( indexingService != null) {
            this.clearFields();
            this.preventClickOnAnyComponents();
            
            indexingService.stopService();
            //indexingService.updateHistory(false, "time");
            indexingService = null;
                        
            this.enableClickOnAnyComponents();
        }
    }
    
    private void preventClickOnAnyComponents() {
        this.startIndexButton.setEnabled(false);
        this.displayItemDetialButton.setEnabled(false);
        
        this.getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        this.getGlassPane().setVisible(true);
        this.getGlassPane().requestFocusInWindow();
    }
    
    private void enableClickOnAnyComponents() {
        //this.startIndexButton.setEnabled(true);
        //this.displayItemDetialButton.setEnabled(true);
        this.getRootPane().getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    private void resettingButtons(boolean state) {
        startIndexButton.setEnabled(state);
        stopIndexingButton.setEnabled(!state);
    }
    
    private void addCardsPanel() {
        this.objectPanel.add(this.emailCrawlingPanel, EMAIL_PANEL);
        this.objectPanel.add(this.fileSystemCrawlingPanel, FILE_PANEL);
    }
    
    private void hideDetailsPanel() {
        this.detailPanelAppearenceFlag = false;
        this.showDetailPanel(this.detailPanelAppearenceFlag);
    }
    
    private void closeCralwingWhenCloseTheWindow() {
        this.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosed (WindowEvent event){
                try {
                    stopIndexerThread();
                    hideIndexingDialog();
                } catch (Exception ex) {
                    logger.log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void startCrawling() {
       try {
            startIndexerThread();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton displayItemDetialButton;
    private javax.swing.JPanel indexControlPanel;
    private javax.swing.JPanel indexPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JTextField numberOfItemsCannotIndexedTextField;
    private javax.swing.JTextField numberOfItemsInIndexTextField;
    private javax.swing.JTextField numberOfScannedItemsTextField;
    private javax.swing.JPanel objectPanel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JPanel progressBarPanel;
    private javax.swing.JPanel progressStatusPanel;
    private javax.swing.JTextField sizeOfScannedItemsTextField;
    private javax.swing.JButton startIndexButton;
    private javax.swing.JButton stopIndexingButton;
    // End of variables declaration//GEN-END:variables
}
