/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IndexPanel.java
 *
 * Created on Aug 14, 2011, 1:52:14 PM
 */
package edu.coeia.filesystem.index;

import edu.coeia.cases.Case;
import edu.coeia.filesystem.gui.FileSystemPanel;
import edu.coeia.main.gui.util.InfiniteProgressPanel;
import edu.coeia.main.gui.util.WrapLayout;
import edu.coeia.main.gui.util.GuiUtil;
import edu.coeia.main.util.Utilities;
import edu.coeia.main.util.FilesPath;

import java.awt.BorderLayout;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JFrame;

import java.io.IOException;

import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.mcavallo.opencloud.Cloud;
import org.mcavallo.opencloud.Tag;

/**
 *
 * @author wajdyessam
 */
public class IndexFileSystemPanel extends javax.swing.JPanel {

    private Case caseObj;
    private JFrame parentFrame;
    private FileSystemPanel parentPanel;
    private final static Logger logger = Logger.getLogger(edu.coeia.main.util.FilesPath.LOG_NAMESPACE);

    /** Creates new form IndexPanel */
    public IndexFileSystemPanel(Case aIndex, JFrame aParentFrame, FileSystemPanel aParentPanel) {
        initComponents();

        this.caseObj = aIndex;
        this.parentFrame = aParentFrame;
        this.parentPanel = aParentPanel;

        Utilities.setTableAlignmentValue(cloudsTable, 1);
        //add a native web browser
        tagsPanel.setLayout(new WrapLayout());

        

        //disableNotIndexedComponent();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        indexGroupButton = new javax.swing.ButtonGroup();
        indexFileSystemButtonsPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jToolBar4 = new javax.swing.JToolBar(javax.swing.JToolBar.VERTICAL);
        textCloudsToggleButton = new javax.swing.JToggleButton();
        indexVisualizationToggleButton = new javax.swing.JToggleButton();
        indexCardsPanel = new javax.swing.JPanel();
        textCloudsPanel = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        tagSelectButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tagsNumberTextField = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        tagsExcludeTextField = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        tagsDisplayComboBox = new javax.swing.JComboBox();
        jPanel16 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane10 = new javax.swing.JScrollPane();
        tagsPanel = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        cloudsTable = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        cloudsFilterTextField = new javax.swing.JTextField();
        indexVisualizingPanel = new javax.swing.JPanel();
        indexVisualizationButtonPanel = new javax.swing.JPanel();
        indexVisulizingButton = new javax.swing.JButton();
        indexVisualizingPiePanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        indexFileSystemButtonsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        indexFileSystemButtonsPanel.setPreferredSize(new java.awt.Dimension(150, 408));

        jToolBar4.setFloatable(false);
        jToolBar4.setOrientation(javax.swing.JToolBar.VERTICAL);
        jToolBar4.setRollover(true);

        indexGroupButton.add(textCloudsToggleButton);
        textCloudsToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        textCloudsToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/gui/resources/old-edit-find.png"))); // NOI18N
        textCloudsToggleButton.setText("Index Tags Cloud");
        textCloudsToggleButton.setFocusable(false);
        textCloudsToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textCloudsToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        textCloudsToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCloudsToggleButtonActionPerformed(evt);
            }
        });
        jToolBar4.add(textCloudsToggleButton);

        indexGroupButton.add(indexVisualizationToggleButton);
        indexVisualizationToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        indexVisualizationToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/gui/resources/pie_chart.png"))); // NOI18N
        indexVisualizationToggleButton.setText("Index Visualization");
        indexVisualizationToggleButton.setFocusable(false);
        indexVisualizationToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        indexVisualizationToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        indexVisualizationToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indexVisualizationToggleButtonActionPerformed(evt);
            }
        });
        jToolBar4.add(indexVisualizationToggleButton);

        jScrollPane2.setViewportView(jToolBar4);

        javax.swing.GroupLayout indexFileSystemButtonsPanelLayout = new javax.swing.GroupLayout(indexFileSystemButtonsPanel);
        indexFileSystemButtonsPanel.setLayout(indexFileSystemButtonsPanelLayout);
        indexFileSystemButtonsPanelLayout.setHorizontalGroup(
            indexFileSystemButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indexFileSystemButtonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        indexFileSystemButtonsPanelLayout.setVerticalGroup(
            indexFileSystemButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indexFileSystemButtonsPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(indexFileSystemButtonsPanel, java.awt.BorderLayout.WEST);

        indexCardsPanel.setLayout(new java.awt.CardLayout());

        textCloudsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        textCloudsPanel.setLayout(new java.awt.BorderLayout());

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Index Tags Cloud", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tagSelectButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tagSelectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/gui/resources/textCloud.png"))); // NOI18N
        tagSelectButton.setText("Generate Text Clouds");
        tagSelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagSelectButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Number Of Tags: ");

        tagsNumberTextField.setText(" 200");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel36.setText("Exclude Tags Less Than:");

        tagsExcludeTextField.setText("1");
        tagsExcludeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagsExcludeTextFieldActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel37.setText("Display Type:");

        tagsDisplayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alphabetically Sort - Ascending", "Alphabetically Sort - descending ", "Score Sort - Ascending", "Score Sort - descending" }));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(tagsNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(tagsExcludeTextField))
                    .addComponent(tagsDisplayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(tagSelectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(tagsNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36)
                            .addComponent(tagsExcludeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(tagsDisplayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tagSelectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textCloudsPanel.add(jPanel15, java.awt.BorderLayout.NORTH);

        tagsPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tagsPanelLayout = new javax.swing.GroupLayout(tagsPanel);
        tagsPanel.setLayout(tagsPanelLayout);
        tagsPanelLayout.setHorizontalGroup(
            tagsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1757, Short.MAX_VALUE)
        );
        tagsPanelLayout.setVerticalGroup(
            tagsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );

        jScrollPane10.setViewportView(tagsPanel);

        jTabbedPane1.addTab("Tags Cloud", jScrollPane10);

        jScrollPane22.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        cloudsTable.setFont(new java.awt.Font("Tahoma", 1, 11));
        cloudsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Word", "Frequency"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cloudsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cloudsTableMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cloudsTableMouseReleased(evt);
            }
        });
        jScrollPane22.setViewportView(cloudsTable);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel33.setForeground(new java.awt.Color(0, 70, 213));
        jLabel33.setText("Filter Table:");

        cloudsFilterTextField.setText(" ");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cloudsFilterTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(cloudsFilterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Words Frequency", jPanel19);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        textCloudsPanel.add(jPanel16, java.awt.BorderLayout.CENTER);

        indexCardsPanel.add(textCloudsPanel, "textCloudsCard");

        indexVisualizingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        indexVisualizingPanel.setLayout(new java.awt.BorderLayout());

        indexVisualizationButtonPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Index Visualization", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        indexVisulizingButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        indexVisulizingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/gui/resources/chart_pie.png"))); // NOI18N
        indexVisulizingButton.setText("Index Visualization");
        indexVisulizingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indexVisulizingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout indexVisualizationButtonPanelLayout = new javax.swing.GroupLayout(indexVisualizationButtonPanel);
        indexVisualizationButtonPanel.setLayout(indexVisualizationButtonPanelLayout);
        indexVisualizationButtonPanelLayout.setHorizontalGroup(
            indexVisualizationButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indexVisualizationButtonPanelLayout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(indexVisulizingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
        );
        indexVisualizationButtonPanelLayout.setVerticalGroup(
            indexVisualizationButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indexVisualizationButtonPanelLayout.createSequentialGroup()
                .addComponent(indexVisulizingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        indexVisualizingPanel.add(indexVisualizationButtonPanel, java.awt.BorderLayout.NORTH);

        indexVisualizingPiePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Visualizing File Extension in Index", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        indexVisualizingPiePanel.setLayout(new java.awt.BorderLayout());
        indexVisualizingPanel.add(indexVisualizingPiePanel, java.awt.BorderLayout.CENTER);

        indexCardsPanel.add(indexVisualizingPanel, "indexVisualizingCard");

        add(indexCardsPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void textCloudsToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCloudsToggleButtonActionPerformed
    GuiUtil.showPanel("textCloudsCard", indexCardsPanel);
}//GEN-LAST:event_textCloudsToggleButtonActionPerformed

private void indexVisualizationToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indexVisualizationToggleButtonActionPerformed
    GuiUtil.showPanel("indexVisualizingCard", indexCardsPanel);
}//GEN-LAST:event_indexVisualizationToggleButtonActionPerformed

private void tagsExcludeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagsExcludeTextFieldActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_tagsExcludeTextFieldActionPerformed

private void indexVisulizingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indexVisulizingButtonActionPerformed
    //generateVisualization();
}//GEN-LAST:event_indexVisulizingButtonActionPerformed

    private void tagSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagSelectButtonActionPerformed
        //generateTextCloud();
    }//GEN-LAST:event_tagSelectButtonActionPerformed

    private void cloudsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cloudsTableMousePressed
        showPopUp(evt);
    }//GEN-LAST:event_cloudsTableMousePressed

    private void cloudsTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cloudsTableMouseReleased
        showPopUp(evt);
    }//GEN-LAST:event_cloudsTableMouseReleased



//private void indexVisualizationToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                               
//    GuiUtil.showPanel("indexVisualizingCard", indexCardsPanel);
//}                                                              
//                          
//
//private void indexVisulizingButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                      
//    generateVisualization();
//}   

    private void showPopUp(java.awt.event.MouseEvent evt) {
        if ((evt.getModifiersEx() & InputEvent.BUTTON3_DOWN_MASK) != 0) {
            if (cloudsTable.isEnabled()) {
                GuiUtil.showPopup(evt);
            }
        }
    }
    

    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cloudsFilterTextField;
    private javax.swing.JTable cloudsTable;
    private javax.swing.JPanel indexCardsPanel;
    private javax.swing.JPanel indexFileSystemButtonsPanel;
    private javax.swing.ButtonGroup indexGroupButton;
    private javax.swing.JPanel indexVisualizationButtonPanel;
    private javax.swing.JToggleButton indexVisualizationToggleButton;
    private javax.swing.JPanel indexVisualizingPanel;
    private javax.swing.JPanel indexVisualizingPiePanel;
    private javax.swing.JButton indexVisulizingButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JButton tagSelectButton;
    private javax.swing.JComboBox tagsDisplayComboBox;
    private javax.swing.JTextField tagsExcludeTextField;
    private javax.swing.JTextField tagsNumberTextField;
    private javax.swing.JPanel tagsPanel;
    private javax.swing.JPanel textCloudsPanel;
    private javax.swing.JToggleButton textCloudsToggleButton;
    // End of variables declaration//GEN-END:variables
}
