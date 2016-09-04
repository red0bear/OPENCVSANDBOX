/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencvjavawebcams4;

import javax.swing.DefaultComboBoxModel;
import org.opencv.core.Core;

/**
 *
 * @author felipe
 */
public class JMainSample4 extends javax.swing.JFrame {

    VideoSample4 Sample;
    
    DefaultComboBoxModel Resolution = new DefaultComboBoxModel(); 
    DefaultComboBoxModel ModelListQualityImage = new DefaultComboBoxModel();
    
    /**
     * Creates new form JMain
     */
    public JMainSample4() {
        initComponents();
        
        /**
         * You can add values here but dont forget to change in class too
         */
        ModelListQualityImage.addElement("75");        
        ModelListQualityImage.addElement("10");
        ModelListQualityImage.addElement("20");
        ModelListQualityImage.addElement("30");
        ModelListQualityImage.addElement("40");
        ModelListQualityImage.addElement("50");
        ModelListQualityImage.addElement("60");
        ModelListQualityImage.addElement("70");
        ModelListQualityImage.addElement("80");
        ModelListQualityImage.addElement("90");
        ModelListQualityImage.addElement("100");
        jCBoxQualityImage.setModel(ModelListQualityImage);
        
        /**
         * On linux use # v4l2-ctl --list-formats-ext # to enumerate correctly your real resolution 
         */
        Resolution.addElement("320:180");
        Resolution.addElement("320:240");
        Resolution.addElement("424:240");
        Resolution.addElement("640:360");
        Resolution.addElement("640:480");
        Resolution.addElement("848:480");
        Resolution.addElement("960:540");
        Resolution.addElement("1280:720");
        jCBoxChangeResolution.setModel(Resolution);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblVideoTest = new javax.swing.JLabel();
        jLblResolutionInfo = new javax.swing.JLabel();
        jCBoxChangeResolution = new javax.swing.JComboBox<>();
        jBtnStartVideo = new javax.swing.JButton();
        jLblQualityInfo = new javax.swing.JLabel();
        jCBoxQualityImage = new javax.swing.JComboBox<>();
        jLblBase64SizeInfo = new javax.swing.JLabel();
        jLblBase64Size = new javax.swing.JLabel();
        jLblNormalSizeInfo = new javax.swing.JLabel();
        jLblNormalSize = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SAMPLE 4 QUALITY/SIZE");
        setResizable(false);

        jLblVideoTest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblVideoTest.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "WebCam", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        jLblVideoTest.setMinimumSize(new java.awt.Dimension(2, 2));

        jLblResolutionInfo.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLblResolutionInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblResolutionInfo.setText("Resolution");

        jCBoxChangeResolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxChangeResolutionActionPerformed(evt);
            }
        });

        jBtnStartVideo.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jBtnStartVideo.setText("START");
        jBtnStartVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStartVideoActionPerformed(evt);
            }
        });

        jLblQualityInfo.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLblQualityInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblQualityInfo.setText("Quality ");

        jCBoxQualityImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxQualityImageActionPerformed(evt);
            }
        });

        jLblBase64SizeInfo.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLblBase64SizeInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblBase64SizeInfo.setText("Size Base64");

        jLblBase64Size.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblBase64Size.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLblNormalSizeInfo.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLblNormalSizeInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblNormalSizeInfo.setText("Normal Size");
        jLblNormalSizeInfo.setBorder(null);

        jLblNormalSize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblNormalSize.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblVideoTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnStartVideo, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLblResolutionInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBoxChangeResolution, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblQualityInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBoxQualityImage, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLblBase64SizeInfo)
                        .addGap(18, 18, 18)
                        .addComponent(jLblBase64Size, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLblNormalSizeInfo)
                        .addGap(18, 18, 18)
                        .addComponent(jLblNormalSize)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLblBase64Size, jLblNormalSize});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblVideoTest, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLblBase64SizeInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(jLblBase64Size, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(jLblResolutionInfo)
                        .addComponent(jCBoxChangeResolution)
                        .addComponent(jLblQualityInfo)
                        .addComponent(jCBoxQualityImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLblNormalSizeInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblNormalSize, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(21, 21, 21)
                .addComponent(jBtnStartVideo)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLblBase64Size, jLblNormalSize});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCBoxChangeResolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxChangeResolutionActionPerformed
        // TODO add your handling code here:
        if(Sample != null)
            Sample.SetResolution(jCBoxChangeResolution.getItemAt(jCBoxChangeResolution.getSelectedIndex()));
    }//GEN-LAST:event_jCBoxChangeResolutionActionPerformed

    private void jBtnStartVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnStartVideoActionPerformed
        // TODO add your handling code here:
        if(Sample == null)
        {
            jBtnStartVideo.setText("STOP");
            Sample = new VideoSample4(jLblVideoTest);
            Sample.SetEnvLabels(jLblBase64Size, jLblNormalSize);
            Sample.SetResolution(jCBoxChangeResolution.getItemAt(0));
            Sample.StartWebCamSample4();
        }
        else
        {
            jBtnStartVideo.setText("START");
            Sample.StopWebCamSample4();
            Sample = null;
        }
    }//GEN-LAST:event_jBtnStartVideoActionPerformed

    private void jCBoxQualityImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxQualityImageActionPerformed
        // TODO add your handling code here:
        if(Sample != null)
            Sample.ChangeQuality(jCBoxQualityImage.getItemAt(jCBoxQualityImage.getSelectedIndex()));
    }//GEN-LAST:event_jCBoxQualityImageActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JMainSample4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JMainSample4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JMainSample4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JMainSample4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
                new JMainSample4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnStartVideo;
    private javax.swing.JComboBox<String> jCBoxChangeResolution;
    private javax.swing.JComboBox<String> jCBoxQualityImage;
    private javax.swing.JLabel jLblBase64Size;
    private javax.swing.JLabel jLblBase64SizeInfo;
    private javax.swing.JLabel jLblNormalSize;
    private javax.swing.JLabel jLblNormalSizeInfo;
    private javax.swing.JLabel jLblQualityInfo;
    private javax.swing.JLabel jLblResolutionInfo;
    private javax.swing.JLabel jLblVideoTest;
    // End of variables declaration//GEN-END:variables
}
