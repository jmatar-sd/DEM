/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TextCloudPanel.java
 *
 * Created on Oct 5, 2011, 11:22:23 AM
 */
package edu.coeia.main;

/**
 *
 * @author wajdyessam
 */

import edu.coeia.cases.Case;
import edu.coeia.indexing.IndexReaderThread ;
import edu.coeia.gutil.InfiniteProgressPanel;
import edu.coeia.gutil.WrapLayout;
import edu.coeia.gutil.GuiUtil;
import edu.coeia.util.Utilities;
import edu.coeia.util.FilesPath;

import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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

public class TextCloudPanel extends javax.swing.JPanel {

    private Case caseObj;
    private JFrame parentFrame;
    private FileSystemPanel parentPanel;
    private final static Logger logger = Logger.getLogger(edu.coeia.util.FilesPath.LOG_NAMESPACE);
    
    /** Creates new form TextCloudPanel */
    public TextCloudPanel(Case aIndex, JFrame aParentFrame, FileSystemPanel aParentPanel) {
        initComponents();
        
        this.caseObj = aIndex;
        this.parentFrame = aParentFrame;
        this.parentPanel = aParentPanel;

        Utilities.setTableAlignmentValue(cloudsTable, 1);
        //add a native web browser
        tagsPanel.setLayout(new WrapLayout());

        cloudsFilterTextField.getDocument().addDocumentListener(new CloudsInputListener());

        disableNotIndexedComponent();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        textCloudsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        textCloudsPanel.setLayout(new java.awt.BorderLayout());

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Index Tags Cloud", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tagSelectButton.setFont(new java.awt.Font("Tahoma", 1, 11));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(textCloudsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(textCloudsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tagSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagSelectButtonActionPerformed

        generateTextCloud();     }//GEN-LAST:event_tagSelectButtonActionPerformed

    private void tagsExcludeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagsExcludeTextFieldActionPerformed

        // TODO add your handling code here:}//GEN-LAST:event_tagsExcludeTextFieldActionPerformed
    }
    
        private void cloudsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cloudsTableMousePressed

        showPopUp(evt);     }//GEN-LAST:event_cloudsTableMousePressed

    private void cloudsTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cloudsTableMouseReleased

        showPopUp(evt);     }//GEN-LAST:event_cloudsTableMouseReleased

    
    
    private void showPopUp(java.awt.event.MouseEvent evt) {
        if ((evt.getModifiersEx() & InputEvent.BUTTON3_DOWN_MASK) != 0) {
            if (cloudsTable.isEnabled()) {
                GuiUtil.showPopup(evt);
            }
        }
    }
        
    private void generateTextCloud() {
        try {
            if (caseObj.getIndexStatus() == false) {
                JOptionPane.showMessageDialog(this, "please do the indexing operation first before do any operation",
                        "Case is not indexed", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // remove data
            Utilities.removeAllRows(cloudsTable);
            tagsPanel.removeAll();

            tagsPanel.repaint();
            tagsPanel.validate();

            InfiniteProgressPanel i = new InfiniteProgressPanel("Loading Index Tags Clouds...");
            parentFrame.setGlassPane(i);
            i.start();

            String indexPath = caseObj.getIndexLocation() + "\\" + FilesPath.INDEX_PATH;
            String indexName = caseObj.getIndexName();

            IndexReaderThread thread = new IndexReaderThread(i, indexPath, indexName, IndexReaderThread.IndexItem.TAGS, this);
            thread.execute();

            tagsPanel.repaint();
            tagsPanel.validate();
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(this, "number is not correct",
                    "integer number is no correct", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Uncaught exception", n);
        } catch (IOException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "Uncaught exception", e);
        }
    }
    
    public void setTags(HashMap<String, Integer> tagsMap) {
        int excludeNumber = Integer.parseInt(tagsExcludeTextField.getText().trim());
        int tagsNumber = Integer.parseInt(tagsNumberTextField.getText().trim());

        if (excludeNumber < 0) {
            logger.log(Level.INFO, "exlude number less than zero");
            JOptionPane.showMessageDialog(this, "number is not correct", "please enter valid integer", JOptionPane.ERROR_MESSAGE);

            return;
        }

        if (tagsNumber < 0) {
            logger.log(Level.INFO, "tags number less than zero");
            JOptionPane.showMessageDialog(this, "number is not correct", "please enter valid integer", JOptionPane.ERROR_MESSAGE);

            return;
        }

        if (tagsNumber > tagsMap.size()) {
            JOptionPane.showMessageDialog(this, "number is greater than words in index",
                    "Too Much Input", JOptionPane.ERROR_MESSAGE);
            tagsNumberTextField.setText((tagsMap.size() / 3) + "");
            return;
        }

        // create cloud
        Cloud cloud = new Cloud();
        cloud.setMaxWeight(50.0);
        cloud.setThreshold(excludeNumber); //show just tags with this number
        cloud.setMaxTagsToDisplay(tagsNumber);

        Set set = tagsMap.entrySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            Map.Entry me = (Map.Entry) itr.next();

            String text = (String) me.getKey();
            int value = (Integer) me.getValue();

            ((DefaultTableModel) cloudsTable.getModel()).addRow(new Object[]{text, value});

            Tag tag = new Tag(text, value);
            tag.setLink("Term: " + text + " Frequnecy: " + value);
            tag.setScore(value);

            cloud.addTag(tag);
        }

        List<Tag> tags = null;

        if (tagsDisplayComboBox.getSelectedIndex() == 0) {
            tags = cloud.tags(new Tag.NameComparatorAsc());
        } else if (tagsDisplayComboBox.getSelectedIndex() == 1) {
            tags = cloud.tags(new Tag.NameComparatorDesc());
        } else if (tagsDisplayComboBox.getSelectedIndex() == 2) {
            tags = cloud.tags(new Tag.ScoreComparatorAsc());
        } else if (tagsDisplayComboBox.getSelectedIndex() == 3) {
            tags = cloud.tags(new Tag.ScoreComparatorDesc());
        }

        for (Tag tag : tags) {
            JLabel lbl = new JLabel(tag.getName());
            lbl.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, tag.getWeightInt()));
            lbl.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    JLabel m = (JLabel) e.getSource();
                    doSearch(m.getText());
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    JLabel m = (JLabel) e.getSource();
                    doSearch(m.getText());
                }

                public void doSearch(String text) {
                    parentPanel.showSearchWithKeyword(text);
                }
            });

            lbl.setToolTipText(tag.getName() + " repeated: " + tag.getScoreInt());
            lbl.setForeground(java.awt.Color.BLUE.darker());
            lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            tagsPanel.add(lbl);
            lbl = null;
        }
    }

    public void filterCloudTable() {
        String text = cloudsFilterTextField.getText().trim();
        GuiUtil.filterTable(cloudsTable, text);
    }

    private class CloudsInputListener implements DocumentListener {

        public void changedUpdate(DocumentEvent e) {
            filterCloudTable();
        }

        public void removeUpdate(DocumentEvent e) {
            filterCloudTable();
        }

        public void insertUpdate(DocumentEvent e) {
            filterCloudTable();
        }
    }
    
    private void disableNotIndexedComponent() {
        if (caseObj.getDocumentInIndex().isEmpty()) {
            tagSelectButton.setEnabled(false);
            cloudsTable.setEnabled(false);
        }
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cloudsFilterTextField;
    private javax.swing.JTable cloudsTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton tagSelectButton;
    private javax.swing.JComboBox tagsDisplayComboBox;
    private javax.swing.JTextField tagsExcludeTextField;
    private javax.swing.JTextField tagsNumberTextField;
    private javax.swing.JPanel tagsPanel;
    private javax.swing.JPanel textCloudsPanel;
    // End of variables declaration//GEN-END:variables
}