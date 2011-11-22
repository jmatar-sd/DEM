/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IndexingDialog.java
 *
 * Created on Sep 10, 2011, 9:01:08 AM
 */
package edu.coeia.indexing;

import edu.coeia.cases.Case;

import edu.coeia.onlinemail.OnlineEmailDownloader;
import java.io.IOException;
import java.sql.SQLException;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author wajdyessam
 */
public class EmailDownDialogue extends javax.swing.JDialog {

    public OnlineEmailDownloader downloader;
   

    public EmailDownDialogue() throws NoSuchProviderException, MessagingException, IOException, SQLException {
    }

    public EmailDownDialogue(java.awt.Frame parent, boolean modal, Case aCase) throws SQLException, NoSuchProviderException, MessagingException, IOException, Exception {
        super(parent, modal);
        initComponents();

        DownloadProgressBar.setIndeterminate(true);

    }

    public JTextField getFrom() {
        return this.from;
    }

    public JTextField getBCC() {
        return this.bcc;
    }

    public JTextField getCC() {
        return this.cc;
    }

    public JTextField getSentDate() {
        return this.sdate;
    }

    public JTextField getCreationDate() {
        return this.cdate;
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

        progressEmail = new javax.swing.JPanel();
        progresLabelPanel = new javax.swing.JPanel();
        FromjLabel = new javax.swing.JLabel();
        SentDatejLabel = new javax.swing.JLabel();
        CreateDatejLabel = new javax.swing.JLabel();
        CCjLabel = new javax.swing.JLabel();
        BCCjLabel = new javax.swing.JLabel();
        AttachjLabel = new javax.swing.JLabel();
        TojLabel = new javax.swing.JLabel();
        SubjectjLabel = new javax.swing.JLabel();
        from = new javax.swing.JTextField();
        to = new javax.swing.JTextField();
        cc = new javax.swing.JTextField();
        bcc = new javax.swing.JTextField();
        subject = new javax.swing.JTextField();
        sdate = new javax.swing.JTextField();
        cdate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        attachments = new javax.swing.JTextArea();
        DownloadProgressBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Email Downloading ");
        setResizable(false);

        progressEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email Downloading", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        progressEmail.setLayout(new java.awt.BorderLayout());

        FromjLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        FromjLabel.setText("From:");

        SentDatejLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        SentDatejLabel.setText("Sent Date:");

        CreateDatejLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        CreateDatejLabel.setText("Received Date:");

        CCjLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        CCjLabel.setText("CC:");

        BCCjLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        BCCjLabel.setText("BCC:");

        AttachjLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        AttachjLabel.setText("Attachment Files:");

        TojLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        TojLabel.setText("To:");

        SubjectjLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        SubjectjLabel.setText("Subject:");

        from.setEditable(false);
        from.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromActionPerformed(evt);
            }
        });

        to.setEditable(false);

        cc.setEditable(false);

        bcc.setEditable(false);

        subject.setEditable(false);

        sdate.setEditable(false);

        cdate.setEditable(false);

        attachments.setColumns(20);
        attachments.setEditable(false);
        attachments.setRows(5);
        jScrollPane1.setViewportView(attachments);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Downloading Progress:");

        javax.swing.GroupLayout progresLabelPanelLayout = new javax.swing.GroupLayout(progresLabelPanel);
        progresLabelPanel.setLayout(progresLabelPanelLayout);
        progresLabelPanelLayout.setHorizontalGroup(
            progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, progresLabelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AttachjLabel)
                    .addComponent(CreateDatejLabel)
                    .addComponent(SentDatejLabel)
                    .addComponent(SubjectjLabel)
                    .addComponent(BCCjLabel)
                    .addComponent(CCjLabel)
                    .addComponent(TojLabel)
                    .addComponent(FromjLabel)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DownloadProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(cdate)
                    .addComponent(sdate)
                    .addComponent(subject)
                    .addComponent(bcc)
                    .addComponent(cc)
                    .addComponent(to)
                    .addComponent(from, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        progresLabelPanelLayout.setVerticalGroup(
            progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, progresLabelPanelLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FromjLabel)
                    .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TojLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CCjLabel)
                    .addComponent(cc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCCjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubjectjLabel)
                    .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SentDatejLabel)
                    .addComponent(sdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateDatejLabel)
                    .addComponent(cdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AttachjLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(DownloadProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        progressEmail.add(progresLabelPanel, java.awt.BorderLayout.PAGE_START);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/cancel.png"))); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(progressEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        getAccessibleContext().setAccessibleName("Email Indexing");

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void fromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_fromActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    if (downloader!= null) {
        downloader.cancel(true);
       
    }
   

}//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AttachjLabel;
    private javax.swing.JLabel BCCjLabel;
    private javax.swing.JLabel CCjLabel;
    private javax.swing.JLabel CreateDatejLabel;
    private javax.swing.JProgressBar DownloadProgressBar;
    private javax.swing.JLabel FromjLabel;
    private javax.swing.JLabel SentDatejLabel;
    private javax.swing.JLabel SubjectjLabel;
    private javax.swing.JLabel TojLabel;
    private javax.swing.JTextArea attachments;
    private javax.swing.JTextField bcc;
    private javax.swing.JTextField cc;
    private javax.swing.JTextField cdate;
    private javax.swing.JTextField from;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel progresLabelPanel;
    private javax.swing.JPanel progressEmail;
    private javax.swing.JTextField sdate;
    private javax.swing.JTextField subject;
    private javax.swing.JTextField to;
    // End of variables declaration//GEN-END:variables
}
