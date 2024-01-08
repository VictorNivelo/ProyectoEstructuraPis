/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.ImageIcon;

/**
 *
 * @author Jhostin Roja
 */
public class VistaPrincipalSistema extends javax.swing.JFrame {

    /**
     * Creates new form Eva
     */
    public VistaPrincipalSistema() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Vista/RecursosGraficos/IconoPrograma.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnSGAEstudiantes = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnSGADocentes = new javax.swing.JButton();
        btnEVA = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pagina principal");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("ELSA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

        btnSGAEstudiantes.setText("SGA Estudiantes");
        btnSGAEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSGAEstudiantesActionPerformed(evt);
            }
        });
        jPanel1.add(btnSGAEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jButton7.setText("SIAAF");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        btnSGADocentes.setText("SGA Docentes");
        btnSGADocentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSGADocentesActionPerformed(evt);
            }
        });
        jPanel1.add(btnSGADocentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        btnEVA.setText("EVA");
        btnEVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEVAActionPerformed(evt);
            }
        });
        jPanel1.add(btnEVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 60, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/azul.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/jajaj.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       VistaPrincipalELSA newframe = new VistaPrincipalELSA();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSGAEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSGAEstudiantesActionPerformed
        VistaInicioSesion newframe = new VistaInicioSesion();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSGAEstudiantesActionPerformed

    private void btnEVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEVAActionPerformed
        VistaInicioSesion newframe = new VistaInicioSesion();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEVAActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        VistaInicioSesion newframe = new VistaInicioSesion();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnSGADocentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSGADocentesActionPerformed
        VistaInicioSesion newframe = new VistaInicioSesion();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSGADocentesActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipalSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEVA;
    private javax.swing.JButton btnSGADocentes;
    private javax.swing.JButton btnSGAEstudiantes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
