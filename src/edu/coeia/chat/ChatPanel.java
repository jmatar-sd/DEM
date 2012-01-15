
package edu.coeia.chat;

import edu.coeia.cases.Case;
import edu.coeia.gutil.GuiUtil;
import edu.coeia.util.Utilities;
import edu.coeia.util.FilesPath ;
import edu.coeia.util.GUIFileFilter ;
import edu.coeia.util.Tuple ;
import edu.coeia.util.DateUtil;

import java.awt.BorderLayout;
import java.awt.event.InputEvent;

import javax.swing.JFileChooser ;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode ;
import javax.swing.tree.DefaultTreeModel ;

import java.io.File ;
import java.io.IOException ;
import java.io.FilenameFilter ;

import java.util.List; 
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.Iterator ;
import java.util.Map ;
import java.util.Set ;
import java.util.logging.Logger;
import java.util.logging.Level;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import edu.coeia.gutil.JTableUtil;
import java.util.Collections;

/*
 * ChatPanel.java
 *
 * @author wajdyessam
 * 
 * Created on Aug 10, 2011, 4:20:30 PM
 * 
 */

public class ChatPanel extends javax.swing.JPanel {

    // msn chat
    private DefaultMutableTreeNode rootMSNNode ;
    private MSNParser msnParser ;
    private JWebBrowser msnChat = new JWebBrowser();

    // yaho chat
    private DefaultMutableTreeNode rootYahooNode;
    private JWebBrowser yahooChat = new JWebBrowser();

    // skype Chat
    private DefaultMutableTreeNode rootSkypeNode ;
    
    private Logger logger = Logger.getLogger(edu.coeia.util.FilesPath.LOG_NAMESPACE);
    private Case index;
    private JFileChooser fileChooser ;
    
    /** Creates new form ChatPanel */
    public ChatPanel(Case aIndex) {
        initComponents();
        
        this.index = aIndex;
        
        // configure file chooser to select files (txt)
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new GUIFileFilter("Text Files (*.txt)", "txt"));
        
        // set msn & yahoo & skype data to thier combobox
//        for (String yahooPath: index.getYahooPath())
//            yahooComboBox.addItem(yahooPath);
//
//        for (String msnPath: index.getMsnPath())
//            msnComboBox.addItem(msnPath);
//
//        for (String skypePath: index.getSkypePath())
//            skypeComboBox.addItem(skypePath);
        
        // yahoo chat display area
        yahooChatContentPanel.add(yahooChat, BorderLayout.CENTER);
        yahooChat.setBarsVisible(false);
        yahooChat.setStatusBarVisible(false);

        // msn chat display area
        msnChat.setBarsVisible(false);
        msnChat.setStatusBarVisible(false);
        msnChatContentPanel.add(msnChat, BorderLayout.CENTER);        
        
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

        chatPanelTappedPane = new javax.swing.JTabbedPane();
        WindowsLivePanel = new javax.swing.JPanel();
        msnChatContentPanel = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        msnChatTree = new javax.swing.JTree();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        msnComboBox = new javax.swing.JComboBox();
        loadMSNButton = new javax.swing.JButton();
        yahooMessangerPanel = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        yahooChatTree = new javax.swing.JTree();
        yahooChatContentPanel = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        yahooComboBox = new javax.swing.JComboBox();
        loadYahooButton = new javax.swing.JButton();
        skypePanel = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        skypeChatTree = new javax.swing.JTree();
        skypeChatContentPanel = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        skypeTable = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        skypeComboBox = new javax.swing.JComboBox();
        loadSkypeButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        WindowsLivePanel.setLayout(new java.awt.BorderLayout());

        msnChatContentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        msnChatContentPanel.setLayout(new java.awt.BorderLayout());
        WindowsLivePanel.add(msnChatContentPanel, java.awt.BorderLayout.CENTER);

        msnChatTree.setModel(null);
        msnChatTree.setShowsRootHandles(true);
        msnChatTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                msnChatTreeValueChanged(evt);
            }
        });
        jScrollPane20.setViewportView(msnChatTree);

        WindowsLivePanel.add(jScrollPane20, java.awt.BorderLayout.WEST);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setForeground(new java.awt.Color(0, 70, 213));
        jLabel7.setText("Select Window Live File From Index:");
        jPanel14.add(jLabel7, java.awt.BorderLayout.WEST);

        jPanel14.add(msnComboBox, java.awt.BorderLayout.CENTER);

        loadMSNButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        loadMSNButton.setText("Load Conversations");
        loadMSNButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMSNButtonActionPerformed(evt);
            }
        });
        jPanel14.add(loadMSNButton, java.awt.BorderLayout.EAST);

        WindowsLivePanel.add(jPanel14, java.awt.BorderLayout.NORTH);

        chatPanelTappedPane.addTab("Windows Live Messanger", WindowsLivePanel);

        yahooMessangerPanel.setLayout(new java.awt.BorderLayout());

        yahooChatTree.setModel(null);
        yahooChatTree.setShowsRootHandles(true);
        yahooChatTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                yahooChatTreeValueChanged(evt);
            }
        });
        jScrollPane21.setViewportView(yahooChatTree);

        yahooMessangerPanel.add(jScrollPane21, java.awt.BorderLayout.WEST);

        yahooChatContentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        yahooChatContentPanel.setLayout(new java.awt.BorderLayout());
        yahooMessangerPanel.add(yahooChatContentPanel, java.awt.BorderLayout.CENTER);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel17.setLayout(new java.awt.BorderLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel9.setForeground(new java.awt.Color(0, 70, 213));
        jLabel9.setText("Select Yahoo File From Index:");
        jPanel17.add(jLabel9, java.awt.BorderLayout.WEST);

        jPanel17.add(yahooComboBox, java.awt.BorderLayout.CENTER);

        loadYahooButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        loadYahooButton.setText("Load Conversations");
        loadYahooButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadYahooButtonActionPerformed(evt);
            }
        });
        jPanel17.add(loadYahooButton, java.awt.BorderLayout.EAST);

        yahooMessangerPanel.add(jPanel17, java.awt.BorderLayout.NORTH);

        chatPanelTappedPane.addTab("Yahoo Messanger", yahooMessangerPanel);

        skypePanel.setLayout(new java.awt.BorderLayout());

        skypeChatTree.setModel(null);
        skypeChatTree.setShowsRootHandles(true);
        skypeChatTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                skypeChatTreeValueChanged(evt);
            }
        });
        jScrollPane23.setViewportView(skypeChatTree);

        skypePanel.add(jScrollPane23, java.awt.BorderLayout.WEST);

        skypeChatContentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        skypeTable.setFont(new java.awt.Font("Tahoma", 1, 11));
        skypeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Auther","Partner","Time","Message"
            }
        ));
        skypeTable.setGridColor(new java.awt.Color(255, 255, 255));
        skypeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                skypeTableMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                skypeTableMouseReleased(evt);
            }
        });
        jScrollPane18.setViewportView(skypeTable);

        javax.swing.GroupLayout skypeChatContentPanelLayout = new javax.swing.GroupLayout(skypeChatContentPanel);
        skypeChatContentPanel.setLayout(skypeChatContentPanelLayout);
        skypeChatContentPanelLayout.setHorizontalGroup(
            skypeChatContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
        );
        skypeChatContentPanelLayout.setVerticalGroup(
            skypeChatContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
        );

        skypePanel.add(skypeChatContentPanel, java.awt.BorderLayout.CENTER);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel20.setLayout(new java.awt.BorderLayout());

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel28.setForeground(new java.awt.Color(0, 70, 213));
        jLabel28.setText("Select Skypee File From Index:");
        jPanel20.add(jLabel28, java.awt.BorderLayout.WEST);
        jPanel20.add(skypeComboBox, java.awt.BorderLayout.CENTER);

        loadSkypeButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        loadSkypeButton.setText("Load Conversations");
        loadSkypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadSkypeButtonActionPerformed(evt);
            }
        });
        jPanel20.add(loadSkypeButton, java.awt.BorderLayout.EAST);

        skypePanel.add(jPanel20, java.awt.BorderLayout.NORTH);

        chatPanelTappedPane.addTab("Skype Messanger", skypePanel);

        add(chatPanelTappedPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void msnChatTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_msnChatTreeValueChanged
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) msnChatTree.getLastSelectedPathComponent();

        if ( node == null || node.isRoot() )
            return ;

        String parent = node.getParent().toString();

        if ( FilesPath.getOSType() == FilesPath.OS_TYPE.XP){
            String value = msnParser.getAllUserLoggingPath().get(parent);

            if ( value != null ) {
                File file = new File( msnParser.getFileFromPath(value,node.getUserObject().toString()));
                if ( file.exists() ) {
                    msnChat.navigate(file.getAbsolutePath());
                    msnChatContentPanel.revalidate();
                }
            }
            else {
                if ( ! node.isLeaf() )
                    msnChat.setHTMLContent("");
                else
                    msnChat.setHTMLContent("there is no history for this user");

                msnChatContentPanel.revalidate();
            }
        }
        else {
            File file = new File( msnComboBox.getSelectedItem() + "\\" + node.getUserObject().toString());
            if ( file.exists() ) {
                msnChat.navigate(file.getAbsolutePath());
                msnChatContentPanel.revalidate();
            }
        }
}//GEN-LAST:event_msnChatTreeValueChanged

private void loadMSNButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMSNButtonActionPerformed
        String path = (String) msnComboBox.getSelectedItem();

        try {
            fillMessangerTree(path);
            msnChatTree.setModel(new DefaultTreeModel(rootMSNNode));
        }
        catch (IOException e){
            logger.log(Level.SEVERE, "Uncaught exception", e);
        }
}//GEN-LAST:event_loadMSNButtonActionPerformed

private void yahooChatTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_yahooChatTreeValueChanged
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) yahooChatTree.getLastSelectedPathComponent();

        if ( node == null || node.isRoot() || ! node.isLeaf()) {
            return ;
        }

        String parent = node.getParent().toString();
        String current= node.getUserObject().toString();
        
        try {
            String path = (String) yahooComboBox.getSelectedItem() ;
            List<List<YahooMessage>> msgs  = null; //YahooMessageReader.getInstance(path).get(parent).get(current) ;
            if ( msgs == null ) {
                return ;
            }

            StringBuilder text = new StringBuilder("");
            
            for (List<YahooMessage> aList: msgs) {
                for (YahooMessage msg: aList) {
                    if ( msg.getMessagePath() == YahooMessage.MESSAGE_PATH.SOURCE_TO_DEST ) {
                        text.append(msg.getProfileName() + " at (" );
                    }
                    else {
                        text.append(msg.getDestinationName() + " at (" );
                    }

                    text.append( DateUtil.formatDateTime(msg.getTimeStamp()) + ") :  " );
                    
                    byte[] cipher = msg.getCipherText();
                    String name   = msg.getProfileName();
                    byte[] plainText  = YahooMessageDecoder.decode(cipher,name);

                    String plain = new String(plainText, "UTF-8");
                    text.append( plain );
                    text.append("<br>");
                }

                text.append("<br>");
                text.append("<br>");
            }

            yahooChat.setHTMLContent(text.toString());
            yahooChatContentPanel.revalidate();
        }
        catch (IOException e){
            logger.log(Level.SEVERE, "Uncaught exception", e);

        }
}//GEN-LAST:event_yahooChatTreeValueChanged

private void loadYahooButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadYahooButtonActionPerformed
        String path = (String) yahooComboBox.getSelectedItem();
        
        try {
            fillYahooTree(path);
            yahooChatTree.setModel(new DefaultTreeModel(rootYahooNode));
        }
        catch (IOException e){
            logger.log(Level.SEVERE, "Uncaught exception", e);
        }  
}//GEN-LAST:event_loadYahooButtonActionPerformed

private void skypeTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skypeTableMousePressed
        if ( (evt.getModifiersEx() & InputEvent.BUTTON3_DOWN_MASK ) != 0 ) {
            if ( skypeTable.isEnabled() )
                GuiUtil.showPopup(evt);
        }
}//GEN-LAST:event_skypeTableMousePressed

private void skypeTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skypeTableMouseReleased
        if ( (evt.getModifiersEx() & InputEvent.BUTTON3_DOWN_MASK ) != 0 ) {
            if ( skypeTable.isEnabled() )
                GuiUtil.showPopup(evt);
        }
}//GEN-LAST:event_skypeTableMouseReleased

private void skypeChatTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_skypeChatTreeValueChanged
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) skypeChatTree.getLastSelectedPathComponent();

        if ( node == null || node.isRoot() || ! node.isLeaf()) {
            return ;
        }

        String current= node.getUserObject().toString();

        try {
            String path = (String) skypeComboBox.getSelectedItem() ;
            SkypeParser parser = new SkypeParser();
            List<Tuple<String, List<SkypeMessage>>> msgs = parser.parseSkypeFile(path);

            for (Tuple<String, List<SkypeMessage>> user: msgs) {
                if ( user.getA().equals(current)) {
                    DefaultTableModel model = (DefaultTableModel) skypeTable.getModel();
                    for (SkypeMessage msg: user.getB()) {
                        model.addRow(new Object[] {
                            msg.getAuther(),msg.getPartner(), msg.getDate(), msg.getMessageText()
                        });
                    }
                    return ;
                }
            }
        }
        catch (Exception e){
            logger.log(Level.SEVERE, "Uncaught exception", e);
        }
}//GEN-LAST:event_skypeChatTreeValueChanged

private void loadSkypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadSkypeButtonActionPerformed
        String path = (String) skypeComboBox.getSelectedItem();
        
        try {
            if ( skypeTable.getModel().getRowCount() > 0 )
                 JTableUtil.removeAllRows(skypeTable);
            
            fillSkypeTree(path);
            skypeChatTree.setModel(new DefaultTreeModel(rootSkypeNode));
        }
        catch (IOException e){
            logger.log(Level.SEVERE, "Uncaught exception", e);
        }
}//GEN-LAST:event_loadSkypeButtonActionPerformed

    private void fillSkypeTree (String path) throws IOException {
        rootSkypeNode = new DefaultMutableTreeNode("Skype Chat");
        SkypeParser parser = new SkypeParser();
        
        try {
            List<Tuple<String, List<SkypeMessage>>> msgs = parser.parseSkypeFile(path);

            if ( msgs == null)
                return ;

            for (Tuple<String, List<SkypeMessage>> user: msgs) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(user.getA());
                rootSkypeNode.add(node);
            }
        }
        catch (Exception e){
        }
    }
    
    public void fillMessangerTree (String path) throws IOException {
        rootMSNNode = new DefaultMutableTreeNode("Windows Live Messanger");

        if ( FilesPath.getOSType() == FilesPath.OS_TYPE.XP) {
            path = path.split("\\\\")[0] + "\\" + "WINDOWS\\System32\\reg.exe" ;

            msnParser = new MSNParser(path);
            msnParser.parse();

            Map<String,String> map = msnParser.getAllUserLoggingPath();
            List<String> list = msnParser.getAllUserLoggingToMsn();

            DefaultMutableTreeNode historyNode = new DefaultMutableTreeNode("Users Have Histories");
            DefaultMutableTreeNode normalNode  = new DefaultMutableTreeNode("Users Without Histories");

            rootMSNNode.add(historyNode);
            Set set = map.entrySet();
            Iterator itr = set.iterator();
            while ( itr.hasNext() ) {
                Map.Entry me = (Map.Entry) itr.next();

                String key = (String) me.getKey();
                String value = (String) me.getValue();

                DefaultMutableTreeNode subNode = new DefaultMutableTreeNode(key) ;
                historyNode.add(subNode);
                addOtherUserRelatedToKey(subNode,value);
            }

            rootMSNNode.add(normalNode);
            for (int i=0 ; i<list.size() ; i++)
                normalNode.add(new DefaultMutableTreeNode(list.get(i)));
        }
        else {
            DefaultMutableTreeNode historyNode = new DefaultMutableTreeNode("Users Have Histories");
            rootMSNNode.add(historyNode);

            ArrayList<String> list = getUsersName(path);
            for (String name: list) {
                DefaultMutableTreeNode subNode = new DefaultMutableTreeNode(name) ;
                historyNode.add(subNode);
            }
            
        }
    }

    private ArrayList<String> getUsersName (String path) {
        File[] files = getAllFiles(path);
        ArrayList<String> names = new ArrayList<String>();

        for(File f: files) {
            String name = f.getName();
            names.add(name);
        }

        return names;
    }

    private File[] getAllFiles (String path) {
        File dir = new File(path);

        File[] files = dir.listFiles( new FilenameFilter() {
                public boolean accept (File dir, String name) {
                    return name.toLowerCase().endsWith(".xml");
                }
            }
        );

        return (files);
    }

    private void addOtherUserRelatedToKey (DefaultMutableTreeNode node , String path) throws IOException {
        File[] files = msnParser.getAllFiles(path);

        for (File f: files) {
            DefaultMutableTreeNode tmpNode = new DefaultMutableTreeNode(msnParser.getFileName(f.getName()));
            node.add(tmpNode);
        }
    }
    
    public void fillYahooTree (String path) throws IOException {
        rootYahooNode = new DefaultMutableTreeNode("Yahoo! Chat");
        Map<String, Map<String, List<List<YahooMessage>>>> map = Collections.emptyMap(); //YahooMessageReader.getInstance(path);

        for (Map.Entry<String,Map<String,List<List<YahooMessage>>>> mapEntry: map.entrySet() ) {
            String currentUserName = mapEntry.getKey();
            DefaultMutableTreeNode nameNode = new DefaultMutableTreeNode(currentUserName);
            rootYahooNode.add(nameNode);


            for(Map.Entry<String,List<List<YahooMessage>>> subMapEntry: mapEntry.getValue().entrySet()) {
                String otherUserName = subMapEntry.getKey();
                DefaultMutableTreeNode subNodeName = new DefaultMutableTreeNode(otherUserName);
                nameNode.add(subNodeName);
            }
        }
    }

    private void disableNotIndexedComponent () {
        // close chat panels
//        if (index.getMsnPath().isEmpty()) {
//            WindowsLivePanel.setEnabled(false);
//            msnComboBox.setEnabled(false);
//            msnChat.setEnabled(false);
//            msnChatContentPanel.setEnabled(false);
//            msnChatTree.setEnabled(false);
//            loadMSNButton.setEnabled(false);
//        }
//
//        if ( index.getYahooPath().isEmpty()) {
//            yahooChatContentPanel.setEnabled(false);
//            yahooChat.setEnabled(false);
//            yahooChatTree.setEnabled(false);
//            yahooComboBox.setEnabled(false);
//            yahooMessangerPanel.setEnabled(false);
//            loadYahooButton.setEnabled(false);
//        }
//
//        if (index.getSkypePath().isEmpty() ) {
//            skypePanel.setEnabled(false);
//            loadSkypeButton.setEnabled(false);
//            skypeComboBox.setEnabled(false);
//            skypeChatTree.setEnabled(false);
//            skypeChatContentPanel.setEnabled(false);
//            skypeTable.setEnabled(false);
//        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel WindowsLivePanel;
    private javax.swing.JTabbedPane chatPanelTappedPane;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JButton loadMSNButton;
    private javax.swing.JButton loadSkypeButton;
    private javax.swing.JButton loadYahooButton;
    private javax.swing.JPanel msnChatContentPanel;
    private javax.swing.JTree msnChatTree;
    private javax.swing.JComboBox msnComboBox;
    private javax.swing.JPanel skypeChatContentPanel;
    private javax.swing.JTree skypeChatTree;
    private javax.swing.JComboBox skypeComboBox;
    private javax.swing.JPanel skypePanel;
    private javax.swing.JTable skypeTable;
    private javax.swing.JPanel yahooChatContentPanel;
    private javax.swing.JTree yahooChatTree;
    private javax.swing.JComboBox yahooComboBox;
    private javax.swing.JPanel yahooMessangerPanel;
    // End of variables declaration//GEN-END:variables
}
