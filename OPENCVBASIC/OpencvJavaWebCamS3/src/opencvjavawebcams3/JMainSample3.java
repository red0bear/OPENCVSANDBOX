/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencvjavawebcams3;

import javax.swing.DefaultComboBoxModel;
import org.opencv.core.Core;

/**
 *
 * @author felipe
 */
public class JMainSample3 extends javax.swing.JFrame {

    VideoSample3 Sample;
    
    DefaultComboBoxModel Resolution     = new DefaultComboBoxModel(); 
    
    /**
     * Creates new form JMain
     */
    public JMainSample3() {
        initComponents();
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SAMPLE 3 RESOLUTION");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblVideoTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblResolutionInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBoxChangeResolution, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 726, Short.MAX_VALUE))
                    .addComponent(jBtnStartVideo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblVideoTest, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblResolutionInfo)
                    .addComponent(jCBoxChangeResolution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBtnStartVideo)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnStartVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnStartVideoActionPerformed
        // TODO add your handling code here:
        if(Sample == null)
        {
            jBtnStartVideo.setText("STOP");
            Sample = new VideoSample3(jLblVideoTest);
            Sample.SetResolution(jCBoxChangeResolution.getItemAt(0));
            Sample.StartWebCamSample3();
        }
        else
        {
            jBtnStartVideo.setText("START");
            Sample.StopWebCamSample3();
            Sample = null;
        }
    }//GEN-LAST:event_jBtnStartVideoActionPerformed

    private void jCBoxChangeResolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxChangeResolutionActionPerformed
        // TODO add your handling code here:
        if(Sample != null)
            Sample.SetResolution(jCBoxChangeResolution.getItemAt(jCBoxChangeResolution.getSelectedIndex()));
    }//GEN-LAST:event_jCBoxChangeResolutionActionPerformed

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
            java.util.logging.Logger.getLogger(JMainSample3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JMainSample3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JMainSample3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JMainSample3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
                new JMainSample3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnStartVideo;
    private javax.swing.JComboBox<String> jCBoxChangeResolution;
    private javax.swing.JLabel jLblResolutionInfo;
    private javax.swing.JLabel jLblVideoTest;
    // End of variables declaration//GEN-END:variables
}
