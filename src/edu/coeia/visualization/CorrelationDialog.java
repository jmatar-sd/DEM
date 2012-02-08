/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CorrelationDialog.java
 *
 * Created on May 25, 2010, 9:30:26 AM
 */

package edu.coeia.visualization;

import edu.coeia.charts.BarChartPanel;
import edu.coeia.constants.ApplicationConstants ;

import java.awt.BorderLayout;
import java.awt.Toolkit ;

import java.util.Set ;
import java.util.Iterator ;
import java.util.Map ;
import java.util.WeakHashMap ;
import java.util.SortedSet ;
import java.util.TreeSet;

import javax.xml.stream.XMLStreamException ;

import java.io.FileNotFoundException;
import java.io.File ;
import java.io.IOException ;

import javax.swing.JComboBox;

/**
 *
 * @author wajdyessam
 *
 */

public final class CorrelationDialog extends javax.swing.JDialog {
    private Map<String,Integer> data  ;
    private Map<String,Double> doubleMap  ;
    private Map<String,Integer> tmpIntMap    ;
    
    private File fileName = new File(ApplicationConstants.CORRE_FILE);
    private String user ;
    private String type ;

    private final static int PAGE_ONE = 1 ;
    private final static int PAGE_TWO = 2 ;
    private int page = PAGE_ONE;
    
    /** Creates new form CorrelationDialog */
    public CorrelationDialog(java.awt.Frame parent,
            boolean modal,Map<String,Integer> t,String user,
            String type ) throws Exception{

        super(parent, modal);
        this.data = t ;
        this.user = user ;
        this.type = type ;
        this.doubleMap = getHashMapDouble();
        
        tmpIntMap = new WeakHashMap<String, Integer>();
        
        this.setUndecorated(true);
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize()); // maximize JDialog

        initComponents();
        
        showGraph(data);
        fillBox();
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
        graphPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        numLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        graphRadioButton = new javax.swing.JRadioButton();
        pieRadioButton = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        valueBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        graphPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Number Of Object:");

        numLbl.setFont(new java.awt.Font("Arial", 1, 11));
        numLbl.setForeground(new java.awt.Color(0, 0, 204));
        numLbl.setText(" ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Visualization Method:");

        graphRadioButton.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(graphRadioButton);
        graphRadioButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        graphRadioButton.setSelected(true);
        graphRadioButton.setText("Graph View");
        graphRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphRadioButtonActionPerformed(evt);
            }
        });

        pieRadioButton.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(pieRadioButton);
        pieRadioButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        pieRadioButton.setText("Bar Chart View");
        pieRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieRadioButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Limit Object Less Than:");

        valueBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(graphRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pieRadioButton)
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(valueBox, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(graphRadioButton)
                    .addComponent(pieRadioButton)
                    .addComponent(valueBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(numLbl))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(graphPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1165, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pieRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieRadioButtonActionPerformed
        try {
            int value = (Integer) valueBox.getSelectedItem();
            showBar(filterHashMapForChart(value));
            page = PAGE_TWO;
        }
        catch (Exception E){
            //E.printStackTrace();
        }        
    }//GEN-LAST:event_pieRadioButtonActionPerformed

    private void graphRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphRadioButtonActionPerformed
        try {
            int value = (Integer) valueBox.getSelectedItem();
            showGraph(filterHashMapForGraph(value));
            page = PAGE_ONE;
        }
        catch (Exception e){
            //e.printStackTrace();
        }
    }//GEN-LAST:event_graphRadioButtonActionPerformed

    private void valueBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueBoxActionPerformed
        JComboBox tmp = (JComboBox) evt.getSource();
        int value = (Integer) tmp.getSelectedItem();
        
        try {
            numLbl.setText(value + "");

            if ( page == PAGE_ONE )
                showGraph(filterHashMapForGraph(value));
            else
                showBar(filterHashMapForChart(value));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_valueBoxActionPerformed

    private void fillBox () {
        SortedSet<Integer> set = new TreeSet<Integer>();

        if ( data.isEmpty() )
            return ;
        
        for (Map.Entry<String,Integer> map: data.entrySet()) {
            int value = map.getValue() ;
            set.add(value);
        }

        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            Integer value = itr.next();
            valueBox.addItem(value);
        }

        set.clear();
    }
    
    public void showGraph (Map<String,Integer> tmp) throws XMLStreamException,FileNotFoundException  {
        new XMLHandler(tmp,fileName,user);
        numLbl.setText(tmp.size() + "" );

        String infile = fileName.getAbsolutePath();
        String label = "name";

        graphPanel.removeAll();
        graphPanel.add( RadialGraphView.demo(infile, label), BorderLayout.CENTER);
        graphPanel.validate();
    }

    public void showBar (Map<String,Double> chart) throws IOException {
        graphPanel.removeAll();

        BarChartPanel panel = new BarChartPanel(type, user, 0, 100);
        graphPanel.add(panel.getBarChartPanel(chart));
        graphPanel.validate();

        panel.releaseMemory();
    }

    public Map<String,Double> filterHashMapForChart (int value) {
        doubleMap.clear();
        
        for(Map.Entry<String,Integer> tmp: data.entrySet()) {
            int val = tmp.getValue();

            if ( val >= value ) {
                doubleMap.put(tmp.getKey(), Double.valueOf(val));
            }
        }

        return doubleMap;
    }

    public Map<String,Integer> filterHashMapForGraph (int value) {
        tmpIntMap.clear();

        for(Map.Entry<String,Integer> tmp: data.entrySet()) {
            int val = tmp.getValue();

            if ( val >= value ) {
                tmpIntMap.put(tmp.getKey(),(val));
            }
        }

        return tmpIntMap;
    }

    private Map<String,Double> getHashMapDouble () {
        doubleMap = new WeakHashMap<String, Double>();

        Set set = data.entrySet();
        Iterator itr = set.iterator() ;

        while ( itr.hasNext() ) {
            Map.Entry e = (Map.Entry) itr.next();
            String key = (String) e.getKey() ;
            Integer val = (Integer) e.getValue() ;

            doubleMap.put(key, Double.valueOf(val));
        }

        return doubleMap;
    }
    
    public void releaseMemory () {
        for(Map.Entry<String,Integer> tmp: data.entrySet()) {
            Integer val = tmp.getValue();
            String key = tmp.getKey();

            val = null;
            key = null;
        }

        data.clear();
        doubleMap.clear();
        tmpIntMap.clear();

        doubleMap  = null ;
        tmpIntMap = null;
        data = null ;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JRadioButton graphRadioButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel numLbl;
    private javax.swing.JRadioButton pieRadioButton;
    private javax.swing.JComboBox valueBox;
    // End of variables declaration//GEN-END:variables

}
