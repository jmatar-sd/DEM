/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IndexingDialog.java
 *
 * Created on Sep 10, 2011, 9:01:08 AM
 */
package edu.coeia.onlinemail;

import edu.coeia.cases.Case;

import java.io.IOException;

import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author wajdyessam
 */
public class EmailDownloaderDialog extends javax.swing.JDialog {

    public OnlineEmailDownloader m_ObjDownloader;
    private Case aCase ;   

    
    public EmailDownloaderDialog() throws NoSuchProviderException, MessagingException, IOException, SQLException {

    }

    public EmailDownloaderDialog(java.awt.Frame parent, boolean modal, Case aCase) throws SQLException, NoSuchProviderException, MessagingException, IOException, Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);        
        DownloadProgressBar.setIndeterminate(true);
        this.aCase = aCase;
    }
    
    public JButton getCancelButton()
    {
        return this.jButton1;
    }
    
    public JButton getPauseButton()
    {
        return this.jBtn_Pause;
    }
    
    public Case getCase()
    {
        return this.aCase;
    }

    public JTextField getFrom() {
        return this.from;
    }
//    
//    public void setFrom(final String from) {
//        this.from.setText(from);
//    }

    public JTextField getBCC() {
        return this.bcc;
    }

    public JTextField getCC() {
        return this.cc;
    }

    public JTextField getSentDate() {
        return this.sdate;
    }
 

    public JTextArea getAttachments() {
        return this.attachments;
    }

    public JTextField getSubject() {
        return this.subject;
    }

    public JTextField getTo() {
        return this.to;
    }
    public JProgressBar getDownloadBar()
    {
        return this.DownloadProgressBar;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progresLabelPanel = new javax.swing.JPanel();
        FromjLabel = new javax.swing.JLabel();
        from = new javax.swing.JTextField();
        TojLabel = new javax.swing.JLabel();
        to = new javax.swing.JTextField();
        SubjectjLabel = new javax.swing.JLabel();
        subject = new javax.swing.JTextField();
        SentDatejLabel = new javax.swing.JLabel();
        sdate = new javax.swing.JTextField();
        CCjLabel = new javax.swing.JLabel();
        cc = new javax.swing.JTextField();
        BCCjLabel = new javax.swing.JLabel();
        bcc = new javax.swing.JTextField();
        AttachjLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attachments = new javax.swing.JTextArea();
        pregressLabel = new javax.swing.JLabel();
        DownloadProgressBar = new javax.swing.JProgressBar();
        controllPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jBtn_Pause = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Email Downloading ");

        progresLabelPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Email Downloading"));
        progresLabelPanel.setForeground(new java.awt.Color(0, 51, 255));
        progresLabelPanel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        progresLabelPanel.setLayout(new javax.swing.BoxLayout(progresLabelPanel, javax.swing.BoxLayout.PAGE_AXIS));

        FromjLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        FromjLabel.setText("From:");
        progresLabelPanel.add(FromjLabel);

        from.setEditable(false);
        from.setPreferredSize(new java.awt.Dimension(20, 20));
        from.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromActionPerformed(evt);
            }
        });
        progresLabelPanel.add(from);

        TojLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TojLabel.setText("To:");
        progresLabelPanel.add(TojLabel);

        to.setEditable(false);
        progresLabelPanel.add(to);

        SubjectjLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SubjectjLabel.setText("Subject:");
        progresLabelPanel.add(SubjectjLabel);

        subject.setEditable(false);
        progresLabelPanel.add(subject);

        SentDatejLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SentDatejLabel.setText("Sent Date:");
        progresLabelPanel.add(SentDatejLabel);

        sdate.setEditable(false);
        progresLabelPanel.add(sdate);

        CCjLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CCjLabel.setText("CC:");
        progresLabelPanel.add(CCjLabel);

        cc.setEditable(false);
        progresLabelPanel.add(cc);

        BCCjLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        BCCjLabel.setText("BCC:");
        progresLabelPanel.add(BCCjLabel);

        bcc.setEditable(false);
        progresLabelPanel.add(bcc);

        AttachjLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        AttachjLabel.setText("Attachment Files:");
        progresLabelPanel.add(AttachjLabel);

        attachments.setColumns(20);
        attachments.setEditable(false);
        attachments.setRows(5);
        jScrollPane1.setViewportView(attachments);

        progresLabelPanel.add(jScrollPane1);

        pregressLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pregressLabel.setText("Downloading Progress:");
        progresLabelPanel.add(pregressLabel);
        progresLabelPanel.add(DownloadProgressBar);

        getContentPane().add(progresLabelPanel, java.awt.BorderLayout.PAGE_START);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/cancel.png"))); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        controllPanel.add(jButton1);

        jBtn_Pause.setFont(new java.awt.Font("Tahoma", 1, 11));
        jBtn_Pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/mail.png"))); // NOI18N
        jBtn_Pause.setText("Pause");
        jBtn_Pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_PauseActionPerformed(evt);
            }
        });
        controllPanel.add(jBtn_Pause);
        jBtn_Pause.getAccessibleContext().setAccessibleName("Resume");

        getContentPane().add(controllPanel, java.awt.BorderLayout.SOUTH);

        getAccessibleContext().setAccessibleName("Email Indexing");

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void fromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_fromActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    if (m_ObjDownloader!= null) {
        m_ObjDownloader.cancel(true);
        this.setVisible(false);
    }
   

}//GEN-LAST:event_jButton1ActionPerformed

private void jBtn_PauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_PauseActionPerformed
// TODO add your handling code here:
    
    if (m_ObjDownloader != null) {
        m_ObjDownloader.pauseDownloading();
       
    }
}//GEN-LAST:event_jBtn_PauseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AttachjLabel;
    private javax.swing.JLabel BCCjLabel;
    private javax.swing.JLabel CCjLabel;
    private javax.swing.JProgressBar DownloadProgressBar;
    private javax.swing.JLabel FromjLabel;
    private javax.swing.JLabel SentDatejLabel;
    private javax.swing.JLabel SubjectjLabel;
    private javax.swing.JLabel TojLabel;
    private javax.swing.JTextArea attachments;
    private javax.swing.JTextField bcc;
    private javax.swing.JTextField cc;
    private javax.swing.JPanel controllPanel;
    private javax.swing.JTextField from;
    private javax.swing.JButton jBtn_Pause;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pregressLabel;
    private javax.swing.JPanel progresLabelPanel;
    private javax.swing.JTextField sdate;
    private javax.swing.JTextField subject;
    private javax.swing.JTextField to;
    // End of variables declaration//GEN-END:variables
}
