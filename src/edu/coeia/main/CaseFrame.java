
package edu.coeia.main;

import edu.coeia.cases.Case;
import edu.coeia.cases.CaseManagerPanel;
import edu.coeia.cases.ReportPanel;
import edu.coeia.util.Utilities;
import edu.coeia.gutil.GuiUtil ;
import edu.coeia.chat.ChatPanel;
import edu.coeia.email.EmailPanel;
import edu.coeia.indexing.IndexingDialog;
import edu.coeia.image.ImagesViewerPanel;
import edu.coeia.internet.InternetSurfingPanel;
import edu.coeia.searching.CaseSearchPanel;
import edu.coeia.util.FileUtil;
import edu.coeia.util.FilesPath;
import edu.coeia.tags.TagsManager ;

import java.awt.Toolkit ;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import java.io.IOException ;

import java.util.List; 
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * OfflineMinningFrame.java
 *
 * @author wajdyessam
 * 
 * Created on Apr 28, 2010, 11:10:01 AM
 * 
 */

public class CaseFrame extends javax.swing.JFrame {
    private final Case caseObj ;
    private final TagsManager tagsManager ;
    
    private final String APPLICATION_NAME = "Digital Evidence Miner: ";
    private final String applicationTitle;
    
    private final List<String> listOfOpeningCase ;
    private static final Logger logger = Logger.getLogger(edu.coeia.util.FilesPath.LOG_NAMESPACE);
    
    // to update the panel after direct indexing 
    private CaseManagerPanel caseManagerPanel;
    private CaseSearchPanel caseSearchPanel ;
    
    /** Creates new form OfflineMinningFrame 
     * 
     * @param aCase case opened in CaseManager
     * @param list a list of all openings case
     */
    public CaseFrame(Case aCase, List<String> list) {
        initComponents();
        logger.info("OfflineMining Frame Constructor, Open Case: " + aCase.getIndexName());
        
        /*
         * set frame resizable and set frame title
         */
        Toolkit kit = Toolkit.getDefaultToolkit();
        this.applicationTitle = "File System Search Window";
        this.setIconImage(kit.getImage(this.getClass().getResource("resources/dem-icon.png")));
        this.setTitle(APPLICATION_NAME + applicationTitle);
        this.setResizable(true);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(850, 650);
        
        /*
         * initializing class
         */
        this.caseObj = aCase ;
        this.listOfOpeningCase = list;
        this.tagsManager = TagsManager.getTagsManager(this.caseObj.getCaseLocation() + "\\" + FilesPath.CASE_TAGS);
        
        /**
         * Remove Case Name From the list when Frame Closed
         */
        this.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent event){
                promptUserToSaveCase();
                closeCaseFrame();
            }
        });

        // Get Tags Manager for this Case
        
        // add gui panels
        FileSystemPanel fileSystemPanel = new FileSystemPanel(this.caseObj, this);
        EmailPanel emailPanel = new EmailPanel(this.caseObj, this);
        InternetSurfingPanel internetPanel = new InternetSurfingPanel(this.caseObj);
        ChatPanel chatPanel = new ChatPanel(this.caseObj);
        ImagesViewerPanel imgPanel = new ImagesViewerPanel(this.caseObj);
        caseSearchPanel = new CaseSearchPanel(this.caseObj, this);
        caseManagerPanel = new CaseManagerPanel(this);
        ReportPanel reportPanel = new ReportPanel();
        
        this.CardPanel.add(fileSystemPanel, "fileSystemCard");
        this.CardPanel.add(emailPanel, "emailCard");
        this.CardPanel.add(internetPanel, "internetSurfingCard");
        this.CardPanel.add(chatPanel, "chatCard");
        this.CardPanel.add(imgPanel, "imagesViewerCard");
        this.CardPanel.add(caseSearchPanel, "searchCard");
        this.CardPanel.add(caseManagerPanel, "caseManagerCard");
        this.CardPanel.add(reportPanel, "reportCard");
        
        searchToggleButtonActionPerformed(null);
        
       GuiUtil.showPanel("caseManagerCard",CardPanel);
       this.setTitle(APPLICATION_NAME + "Case Manager Window");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerGroupButton = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        caseManagerToggleButton = new javax.swing.JToggleButton();
        searchToggleButton = new javax.swing.JToggleButton();
        fileSystemToggleButton = new javax.swing.JToggleButton();
        emailToggleButton = new javax.swing.JToggleButton();
        internetSurfingToggleButton = new javax.swing.JToggleButton();
        chatToggleButton = new javax.swing.JToggleButton();
        imageViewerToggleButton = new javax.swing.JToggleButton();
        reportToggleButton = new javax.swing.JToggleButton();
        CardPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        caseIndexingMenuItem = new javax.swing.JMenuItem();
        toolsMenu = new javax.swing.JMenu();
        windowsMenuItem = new javax.swing.JMenuItem();
        recentMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        viewLogMenuItem = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Digital Evidence Miner ");
        setIconImages(null);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        headerGroupButton.add(caseManagerToggleButton);
        caseManagerToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        caseManagerToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/1274612774_kservices.png"))); // NOI18N
        caseManagerToggleButton.setText("Case Manager");
        caseManagerToggleButton.setFocusable(false);
        caseManagerToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        caseManagerToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        caseManagerToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caseManagerToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(caseManagerToggleButton);

        headerGroupButton.add(searchToggleButton);
        searchToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        searchToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/Copy of search.png"))); // NOI18N
        searchToggleButton.setText("Case Search");
        searchToggleButton.setFocusable(false);
        searchToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        searchToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        searchToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(searchToggleButton);

        headerGroupButton.add(fileSystemToggleButton);
        fileSystemToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fileSystemToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/file-manager.png"))); // NOI18N
        fileSystemToggleButton.setText("File System");
        fileSystemToggleButton.setFocusable(false);
        fileSystemToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fileSystemToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        fileSystemToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSystemToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(fileSystemToggleButton);

        headerGroupButton.add(emailToggleButton);
        emailToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        emailToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/email.png"))); // NOI18N
        emailToggleButton.setText("Online and Offline Email");
        emailToggleButton.setEnabled(false);
        emailToggleButton.setFocusable(false);
        emailToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        emailToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        emailToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(emailToggleButton);

        headerGroupButton.add(internetSurfingToggleButton);
        internetSurfingToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        internetSurfingToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/webButton.png"))); // NOI18N
        internetSurfingToggleButton.setText("Internet Browsing");
        internetSurfingToggleButton.setEnabled(false);
        internetSurfingToggleButton.setFocusable(false);
        internetSurfingToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        internetSurfingToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        internetSurfingToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                internetSurfingToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(internetSurfingToggleButton);

        headerGroupButton.add(chatToggleButton);
        chatToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        chatToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/Chat.png"))); // NOI18N
        chatToggleButton.setText("Instant Chat  IM");
        chatToggleButton.setEnabled(false);
        chatToggleButton.setFocusable(false);
        chatToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        chatToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        chatToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(chatToggleButton);

        headerGroupButton.add(imageViewerToggleButton);
        imageViewerToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        imageViewerToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/kview.png"))); // NOI18N
        imageViewerToggleButton.setText("Multimedia Viewer");
        imageViewerToggleButton.setEnabled(false);
        imageViewerToggleButton.setFocusable(false);
        imageViewerToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        imageViewerToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        imageViewerToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageViewerToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(imageViewerToggleButton);

        headerGroupButton.add(reportToggleButton);
        reportToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        reportToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/1274614668_filesave.png"))); // NOI18N
        reportToggleButton.setText("Report");
        reportToggleButton.setEnabled(false);
        reportToggleButton.setFocusable(false);
        reportToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reportToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        reportToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(reportToggleButton);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);

        CardPanel.setPreferredSize(new java.awt.Dimension(600, 400));
        CardPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(CardPanel, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");
        fileMenu.setFont(new java.awt.Font("Tahoma", 1, 11));

        exitMenuItem.setText(" Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jMenuBar1.add(fileMenu);

        jMenu1.setText("Options");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        caseIndexingMenuItem.setText("Case Indexing");
        caseIndexingMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caseIndexingMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(caseIndexingMenuItem);

        jMenuBar1.add(jMenu1);

        toolsMenu.setText("Tools");
        toolsMenu.setFont(new java.awt.Font("Tahoma", 1, 11));

        windowsMenuItem.setText("Windows Information");
        windowsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windowsMenuItemActionPerformed(evt);
            }
        });
        toolsMenu.add(windowsMenuItem);

        recentMenuItem.setText("Recent Documents");
        recentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recentMenuItemActionPerformed(evt);
            }
        });
        toolsMenu.add(recentMenuItem);
        toolsMenu.add(jSeparator2);

        viewLogMenuItem.setText("View Logs");
        viewLogMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewLogMenuItemActionPerformed(evt);
            }
        });
        toolsMenu.add(viewLogMenuItem);

        jMenuBar1.add(toolsMenu);

        aboutMenu.setText("About");
        aboutMenu.setFont(new java.awt.Font("Tahoma", 1, 11));

        helpMenuItem.setText("Help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        aboutMenu.add(helpMenuItem);
        aboutMenu.add(jSeparator1);

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        aboutMenu.add(aboutMenuItem);

        jMenuBar1.add(aboutMenu);

        setJMenuBar(jMenuBar1);

        getAccessibleContext().setAccessibleName("DEM");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void windowsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windowsMenuItemActionPerformed
        try {
            List<String> data = FileUtil.readProgramOutputStream("systeminfo.exe");

            WindowsInfoDialog wid = new WindowsInfoDialog(CaseFrame.this, true, data);
            wid.setVisible(true);
        }
        catch (IOException e) {
            logger.log(Level.SEVERE, "Uncaught exception", e);
        }
    }//GEN-LAST:event_windowsMenuItemActionPerformed

    private void recentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recentMenuItemActionPerformed
        RecentDialog rd = new RecentDialog(CaseFrame.this, true);
        rd.setVisible(true);
    }//GEN-LAST:event_recentMenuItemActionPerformed
    
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        this.closeCaseFrame();
        this.dispose();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "please return to CoEIA web site",
                "to get more help", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_helpMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "All right is reserved to CoEIA 2010",
                "about product", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void fileSystemToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSystemToggleButtonActionPerformed
        GuiUtil.showPanel("fileSystemCard",CardPanel);
        this.setTitle(APPLICATION_NAME + "File System Search Window");
    }//GEN-LAST:event_fileSystemToggleButtonActionPerformed

    private void emailToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailToggleButtonActionPerformed
       GuiUtil.showPanel("emailCard",CardPanel);
       this.setTitle(APPLICATION_NAME + "Email Search Window");
    }//GEN-LAST:event_emailToggleButtonActionPerformed

    private void internetSurfingToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_internetSurfingToggleButtonActionPerformed
       GuiUtil.showPanel("internetSurfingCard",CardPanel);
       this.setTitle(APPLICATION_NAME + "Internet Surfing Search Window");
    }//GEN-LAST:event_internetSurfingToggleButtonActionPerformed

    private void chatToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatToggleButtonActionPerformed
        GuiUtil.showPanel("chatCard",CardPanel);
        this.setTitle(APPLICATION_NAME + "Instance Chat Search Window");
    }//GEN-LAST:event_chatToggleButtonActionPerformed

    private void imageViewerToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageViewerToggleButtonActionPerformed
         GuiUtil.showPanel("imagesViewerCard", CardPanel);
         this.setTitle(APPLICATION_NAME + "Image Viewer Window");
    }//GEN-LAST:event_imageViewerToggleButtonActionPerformed

    private void viewLogMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewLogMenuItemActionPerformed
        try {
            Utilities.selectObjectInExplorer(FilesPath.APPLICATION_LOG_PATH);
        }
        catch(Exception e) {
            logger.log(Level.SEVERE, "Exception When Opening Folder", e);
        }
    }//GEN-LAST:event_viewLogMenuItemActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void caseIndexingMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caseIndexingMenuItemActionPerformed
        showIndexDialog(false);
    }//GEN-LAST:event_caseIndexingMenuItemActionPerformed

    private void searchToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchToggleButtonActionPerformed
       GuiUtil.showPanel("searchCard",CardPanel);
       this.setTitle(APPLICATION_NAME + "Search Window");
       this.caseSearchPanel.setFocusInAdvancedSearchPanel();
    }//GEN-LAST:event_searchToggleButtonActionPerformed

    private void caseManagerToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caseManagerToggleButtonActionPerformed
       GuiUtil.showPanel("caseManagerCard",CardPanel);
       this.setTitle(APPLICATION_NAME + "Case Manager Window");
    }//GEN-LAST:event_caseManagerToggleButtonActionPerformed

    private void reportToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportToggleButtonActionPerformed
       GuiUtil.showPanel("reportCard",CardPanel);
       this.setTitle(APPLICATION_NAME + "Report Manager Window");
    }//GEN-LAST:event_reportToggleButtonActionPerformed
    
    public void showIndexDialog(boolean startIndex) {
        IndexingDialog indexPanel = new IndexingDialog(this, true, caseObj, startIndex);
        indexPanel.setLocationRelativeTo(this);
        indexPanel.setVisible(true);
        
        caseManagerPanel.displayCaseInformationPanel();
        caseManagerPanel.displayMutableCaseInformationPanel();
    }
    
    private void closeCaseFrame() {
        try {
            if ( this.caseObj != null ) {
                String caseName = this.caseObj.getIndexName() ;

                if ( !caseName.isEmpty() )
                    this.listOfOpeningCase.remove(caseName);
            }

            if ( this.tagsManager !=  null ) {
                this.tagsManager.closeManager();
            }
            
            if ( this.caseSearchPanel != null ) {
                this.caseSearchPanel.closeSearcher();
            }
        }
        catch (Exception e){
            logger.log(Level.SEVERE, "Uncaught exception", e);
        }
    }
    
    /**
     * Ask User to save case if he add new tags
     * and not save the case
     */
    private void promptUserToSaveCase() {
        if ( this.tagsManager.isTagsDbModified() ) {
            askForSavingMessage();
        }
    }
    
    /**
     * the message ask user for save the case
     */
    private void askForSavingMessage() {
        int value = JOptionPane.showConfirmDialog(this,
                    "The case is not saved, Do you want to save it?",
                    applicationTitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    
        if ( value == JOptionPane.YES_OPTION ) {
            this.caseManagerPanel.saveCaseModifications();
        }
    }
    
    public Case getCase() { return this.caseObj ; }
    public TagsManager getTagsManager() { return this.tagsManager; }
    
    public void refreshTagsList() {
        this.caseManagerPanel.initializingTagsPanel();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardPanel;
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem caseIndexingMenuItem;
    private javax.swing.JToggleButton caseManagerToggleButton;
    private javax.swing.JToggleButton chatToggleButton;
    private javax.swing.JToggleButton emailToggleButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JToggleButton fileSystemToggleButton;
    private javax.swing.ButtonGroup headerGroupButton;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JToggleButton imageViewerToggleButton;
    private javax.swing.JToggleButton internetSurfingToggleButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem recentMenuItem;
    private javax.swing.JToggleButton reportToggleButton;
    private javax.swing.JToggleButton searchToggleButton;
    private javax.swing.JMenu toolsMenu;
    private javax.swing.JMenuItem viewLogMenuItem;
    private javax.swing.JMenuItem windowsMenuItem;
    // End of variables declaration//GEN-END:variables
}