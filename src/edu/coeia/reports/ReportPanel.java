/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ReportPanel.java
 *
 * Created on Oct 5, 2011, 11:10:41 AM
 */
package edu.coeia.reports;

import edu.coeia.cases.Case;
import edu.coeia.cases.CaseFacade;
import edu.coeia.gutil.GuiUtil;
import edu.coeia.main.CaseMainFrame;
import edu.coeia.reports.panels.CasesReportPanel;
import edu.coeia.reports.panels.FilesAutherReportPanel;
import edu.coeia.reports.panels.FilesReportPanel;
import edu.coeia.reports.panels.FilesSizeReportPanel;
import edu.coeia.reports.panels.FilesTimeReportPanel;
import edu.coeia.reports.panels.TaggedItemsReportPanel;

import javax.swing.JFrame;

/**
 *
 * @author wajdyessam
 */
public class ReportPanel extends javax.swing.JPanel {

    private final CaseFacade caseFacade ;
    private final CaseMainFrame caseFrame ;
    private final Case aCase ;

    /** Creates new form ReportPanel */
    public ReportPanel(final JFrame frame) {
        initComponents();

        this.caseFrame = (CaseMainFrame) frame;
        this.aCase =  this.caseFrame.getCaseFacade().getCase();
        this.caseFacade = this.caseFrame.getCaseFacade();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        ReportOptionsPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jToolBar4 = new javax.swing.JToolBar();
        fileSystemOptionButton = new javax.swing.JButton();
        OptionsPanels = new javax.swing.JPanel();
        fileSystemPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        filesButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        filesSizeButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        filesDateButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        fileAuthersButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        casesButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        taggedItemsButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        ReportOptionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Report Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        ReportOptionsPanel.setPreferredSize(new java.awt.Dimension(200, 459));

        jToolBar4.setFloatable(false);
        jToolBar4.setOrientation(javax.swing.JToolBar.VERTICAL);
        jToolBar4.setRollover(true);

        fileSystemOptionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/view_text.png"))); // NOI18N
        fileSystemOptionButton.setText("File System Option");
        fileSystemOptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSystemOptionButtonActionPerformed(evt);
            }
        });
        jToolBar4.add(fileSystemOptionButton);

        jScrollPane8.setViewportView(jToolBar4);

        javax.swing.GroupLayout ReportOptionsPanelLayout = new javax.swing.GroupLayout(ReportOptionsPanel);
        ReportOptionsPanel.setLayout(ReportOptionsPanelLayout);
        ReportOptionsPanelLayout.setHorizontalGroup(
            ReportOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );
        ReportOptionsPanelLayout.setVerticalGroup(
            ReportOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );

        add(ReportOptionsPanel, java.awt.BorderLayout.WEST);

        OptionsPanels.setLayout(new java.awt.CardLayout());

        fileSystemPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("File System Options"));

        jLabel2.setText("Report about all files inside the case");

        filesButton.setText("Options...");
        filesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filesButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Report about all files size inside the case");

        filesSizeButton.setText("Options...");
        filesSizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filesSizeButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Report about all files date inside the case");

        filesDateButton.setText("Options...");
        filesDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filesDateButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Report about all files authers inside the case");

        fileAuthersButton.setText("Options...");
        fileAuthersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileAuthersButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Report about all cases in this machine");

        casesButton.setText("Options...");
        casesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casesButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Report about all tagged items in the case");

        taggedItemsButton.setText("Options...");
        taggedItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taggedItemsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addGap(38, 38, 38)
                        .addComponent(filesSizeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addGap(35, 35, 35)
                        .addComponent(taggedItemsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addGap(52, 52, 52)
                        .addComponent(casesButton, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                        .addGap(19, 19, 19)
                        .addComponent(fileAuthersButton, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                        .addGap(34, 34, 34)
                        .addComponent(filesDateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addGap(59, 59, 59)
                        .addComponent(filesButton, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel5)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(filesButton)
                        .addGap(6, 6, 6)
                        .addComponent(filesSizeButton)
                        .addGap(6, 6, 6)
                        .addComponent(filesDateButton)
                        .addGap(11, 11, 11)
                        .addComponent(fileAuthersButton)
                        .addGap(6, 6, 6)
                        .addComponent(casesButton)
                        .addGap(6, 6, 6)
                        .addComponent(taggedItemsButton)))
                .addGap(311, 311, 311))
        );

        javax.swing.GroupLayout fileSystemPanelLayout = new javax.swing.GroupLayout(fileSystemPanel);
        fileSystemPanel.setLayout(fileSystemPanelLayout);
        fileSystemPanelLayout.setHorizontalGroup(
            fileSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileSystemPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fileSystemPanelLayout.setVerticalGroup(
            fileSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileSystemPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addContainerGap())
        );

        OptionsPanels.add(fileSystemPanel, "fileSystemCard");

        add(OptionsPanels, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void fileAuthersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileAuthersButtonActionPerformed
        ReportOptionDialog dialog = new ReportOptionDialog(this.caseFrame, true,
            new FilesAutherReportPanel(this), this);
        dialog.setVisible(true);
    }//GEN-LAST:event_fileAuthersButtonActionPerformed

    private void filesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filesButtonActionPerformed
        ReportOptionDialog dialog = new ReportOptionDialog(this.caseFrame, true,
            new FilesReportPanel(this), this);
        dialog.setVisible(true);
    }//GEN-LAST:event_filesButtonActionPerformed

    /** Extension Report
         ReportOptionDialog dialog = new ReportOptionDialog(this.caseFrame, true,
            new FilesExtensionReportPanel(this), this);
        dialog.setVisible(true);
     * @param evt 
     */
    private void filesSizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filesSizeButtonActionPerformed
        ReportOptionDialog dialog = new ReportOptionDialog(this.caseFrame, true,
            new FilesSizeReportPanel(this), this);
        dialog.setVisible(true);
    }//GEN-LAST:event_filesSizeButtonActionPerformed

    private void filesDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filesDateButtonActionPerformed
        ReportOptionDialog dialog = new ReportOptionDialog(this.caseFrame, true,
            new FilesTimeReportPanel(this), this);
        dialog.setVisible(true);
    }//GEN-LAST:event_filesDateButtonActionPerformed

    private void casesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casesButtonActionPerformed
        ReportOptionDialog dialog = new ReportOptionDialog(this.caseFrame, true,
            new CasesReportPanel(this), this);
        dialog.setVisible(true);
    }//GEN-LAST:event_casesButtonActionPerformed

    private void taggedItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taggedItemsButtonActionPerformed
        ReportOptionDialog dialog = new ReportOptionDialog(this.caseFrame, true,
                new TaggedItemsReportPanel(this),this);
        dialog.setVisible(true);
    }//GEN-LAST:event_taggedItemsButtonActionPerformed

    private void fileSystemOptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSystemOptionButtonActionPerformed
        GuiUtil.showPanel("fileSystemCard", this.OptionsPanels);     
    }//GEN-LAST:event_fileSystemOptionButtonActionPerformed

    public Case getCase() { return this.aCase; }
    public CaseFacade getCaseFacade() { return this.caseFacade; }
    public JFrame getCaseFrame() { return (JFrame) this.caseFrame; }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel OptionsPanels;
    private javax.swing.JPanel ReportOptionsPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton casesButton;
    private javax.swing.JButton fileAuthersButton;
    private javax.swing.JButton fileSystemOptionButton;
    private javax.swing.JPanel fileSystemPanel;
    private javax.swing.JButton filesButton;
    private javax.swing.JButton filesDateButton;
    private javax.swing.JButton filesSizeButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JButton taggedItemsButton;
    // End of variables declaration//GEN-END:variables
}
