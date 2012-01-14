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
import edu.coeia.cases.CasePathHandler;
import edu.coeia.gutil.GuiUtil;
import edu.coeia.indexing.IndexingConstant;
import edu.coeia.main.CaseFrame;
import edu.coeia.util.FilesPath;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 *
 * @author wajdyessam
 */
public class ReportPanel extends javax.swing.JPanel {

    private Case aCase;
    private CasePathHandler handler;
    private JFrame parentFrame; 
    
    /** Creates new form ReportPanel */
    public ReportPanel(final Case aCase, final CaseFrame frame) {
        try {
            initComponents();
            this.aCase = aCase;
            this.parentFrame = frame;
            
            handler = CasePathHandler.newInstance(aCase.getCaseLocation());
            handler.readConfiguration();
        } catch (IOException ex) {
            Logger.getLogger(ReportPanel.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        ReportOptionsPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jToolBar4 = new javax.swing.JToolBar();
        reportConfigurationButton = new javax.swing.JButton();
        fileSystemOptionButton = new javax.swing.JButton();
        OptionsPanels = new javax.swing.JPanel();
        fileSystemPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        filesButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fileExtensionButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        filesSizeButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        filesDateButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        fileAuthersButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        casesButton = new javax.swing.JButton();
        reportConfigPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();

        setLayout(new java.awt.BorderLayout());

        ReportOptionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Report Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        ReportOptionsPanel.setPreferredSize(new java.awt.Dimension(200, 459));

        jToolBar4.setFloatable(false);
        jToolBar4.setOrientation(javax.swing.JToolBar.VERTICAL);
        jToolBar4.setRollover(true);

        reportConfigurationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/finish.png"))); // NOI18N
        reportConfigurationButton.setText("Report Configuration");
        reportConfigurationButton.setFocusable(false);
        reportConfigurationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reportConfigurationButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        reportConfigurationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportConfigurationButtonActionPerformed(evt);
            }
        });
        jToolBar4.add(reportConfigurationButton);

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
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
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

        jLabel3.setText("Report about all files extensions inside the case");

        fileExtensionButton.setText("Options...");
        fileExtensionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileExtensionButtonActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filesButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fileExtensionButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filesSizeButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filesDateButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fileAuthersButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(casesButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filesButton)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fileExtensionButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(filesSizeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filesDateButton)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fileAuthersButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(casesButton)
                    .addComponent(jLabel7))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fileSystemPanelLayout = new javax.swing.GroupLayout(fileSystemPanel);
        fileSystemPanel.setLayout(fileSystemPanelLayout);
        fileSystemPanelLayout.setHorizontalGroup(
            fileSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileSystemPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        fileSystemPanelLayout.setVerticalGroup(
            fileSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileSystemPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        OptionsPanels.add(fileSystemPanel, "fileSystemCard");

        reportConfigPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Report Panel"));

        jLabel1.setText("Select the type of report do you want:");

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("PDF Report");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("HTML Report");

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("MS-WORD Report");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton5))))
                .addContainerGap(319, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton5)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout reportConfigPanelLayout = new javax.swing.GroupLayout(reportConfigPanel);
        reportConfigPanel.setLayout(reportConfigPanelLayout);
        reportConfigPanelLayout.setHorizontalGroup(
            reportConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportConfigPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        reportConfigPanelLayout.setVerticalGroup(
            reportConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportConfigPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        OptionsPanels.add(reportConfigPanel, "reportCard");

        add(OptionsPanels, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void fileSystemOptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSystemOptionButtonActionPerformed
        GuiUtil.showPanel("fileSystemCard", this.OptionsPanels);
    }//GEN-LAST:event_fileSystemOptionButtonActionPerformed

    private void fileAuthersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileAuthersButtonActionPerformed
        ReportOptionDialog dialog = new ReportOptionDialog(this.parentFrame, true,
                new FilesAutherReportPanel());
        dialog.setVisible(true);
    }//GEN-LAST:event_fileAuthersButtonActionPerformed

    private void filesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filesButtonActionPerformed
        ReportOptionDialog dialog = new ReportOptionDialog(this.parentFrame, true,
                new FilesReportPanel());
        dialog.setVisible(true);
    }//GEN-LAST:event_filesButtonActionPerformed

    private void fileExtensionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileExtensionButtonActionPerformed
                ReportOptionDialog dialog = new ReportOptionDialog(this.parentFrame, true,
                new FilesExtensionReportPanel());
        dialog.setVisible(true);
    }//GEN-LAST:event_fileExtensionButtonActionPerformed

    private void filesSizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filesSizeButtonActionPerformed
        ReportOptionDialog dialog = new ReportOptionDialog(this.parentFrame, true,
                new FilesSizeReportPanel());
        dialog.setVisible(true);
    }//GEN-LAST:event_filesSizeButtonActionPerformed

    private void filesDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filesDateButtonActionPerformed
        ReportOptionDialog dialog = new ReportOptionDialog(this.parentFrame, true,
                new FilesTimeReportPanel());
        dialog.setVisible(true);
    }//GEN-LAST:event_filesDateButtonActionPerformed

    private void casesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casesButtonActionPerformed
        ReportOptionDialog dialog = new ReportOptionDialog(this.parentFrame, true,
                new CasesReportPanel());
        dialog.setVisible(true);
    }//GEN-LAST:event_casesButtonActionPerformed

    private void reportConfigurationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportConfigurationButtonActionPerformed

        GuiUtil.showPanel("reportCard", this.OptionsPanels);     }//GEN-LAST:event_reportConfigurationButtonActionPerformed

    private void generateReport() {
        try {
            String strXmlSource = RawResultFile.getFileSystemXmlFile(IndexUtil.getAllFilePaths(aCase, handler)
                    ,aCase);
            File file = new File(FilesPath.TEMPLATES+"\\filesystem_report.jasper");
            String strJasperFile = file.getAbsolutePath(); //"C:/Users/Farhan/Desktop/projects/DEM/templates/filesystem_report.jasper";
            String strReportOutputPath = aCase.getCaseLocation()+DisclosureReport.REPORTFOLDER;
            String strReportName = "filesystem";
            
            DisclosureReport disReport = new DisclosureReport(strJasperFile,
                                                              strXmlSource,
                                                              strReportOutputPath,strReportName);
            
            disReport.setOutputFileExtension(DisclosureReport.REPORT_TYPE.PDF);
            disReport.setRootXPath("/dem/detail/effectivefiles/file");
            disReport.Generate();
        }
        catch(Exception ex)
        {
            System.out.println("CAUSE: " + ex.getCause());
            System.out.println("MESSAGE" + ex.getMessage());
        }
    }
    

        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel OptionsPanels;
    private javax.swing.JPanel ReportOptionsPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton casesButton;
    private javax.swing.JButton fileAuthersButton;
    private javax.swing.JButton fileExtensionButton;
    private javax.swing.JButton fileSystemOptionButton;
    private javax.swing.JPanel fileSystemPanel;
    private javax.swing.JButton filesButton;
    private javax.swing.JButton filesDateButton;
    private javax.swing.JButton filesSizeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JPanel reportConfigPanel;
    private javax.swing.JButton reportConfigurationButton;
    // End of variables declaration//GEN-END:variables
}
