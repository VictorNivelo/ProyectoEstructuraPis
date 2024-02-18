
package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import Controlador.TDA.ListaDinamica.Excepcion.ListaVacia;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class VistaPersonalAdministracion extends javax.swing.JFrame {
    
    private final String[] imagenes = {
        "/Vista/RecursosGraficos/Fondos/Fondo1.jpg",
        "/Vista/RecursosGraficos/Fondos/Fondo2.jpg",
        "/Vista/RecursosGraficos/Fondos/Fondo3.jpg",
        "/Vista/RecursosGraficos/Fondos/Fondo4.jpg"
    };

    private int indiceImagenActual = 0;
    private Timer timer;
    Color ColorFondo = new Color(61, 90, 124);

    /**
     * Creates new form VistaPersonalAdministracion
     */
    public VistaPersonalAdministracion() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Vista/RecursosGraficos/IconoPrograma.png")).getImage());
        MenuHerramientas.setBackground(ColorFondo);
        
        timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarImagen();
            }
        });
        timer.start();
    }
    
    private void cambiarImagen() {
        indiceImagenActual = (indiceImagenActual + 1) % imagenes.length;
        panelPrincipal.repaint();
    }
    
    //Crea fondos para jframe y jpanel, se tiene que customisar el panel y agregar FondoPanel().
    class FondoPanel extends JPanel {
        private Image imagen;

        @Override
        public void paint(Graphics g) {
            
            imagen = new ImageIcon(getClass().getResource("/Vista/RecursosGraficos/FondoPrincipal.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
    
    /* 
    //Cambia el color de los menus
    private void cambiarColorFondoMenu(JMenu menu) {
        menu.setOpaque(true);
        menu.setBackground(ColorFondo);
        menu.setForeground(Color.white);

        for (Component menuItem : menu.getMenuComponents()) {
            if (menuItem instanceof JMenuItem) {
                JMenuItem jMenuItem = (JMenuItem) menuItem;
                jMenuItem.setOpaque(true);
                jMenuItem.setBackground(ColorFondo);
                jMenuItem.setForeground(Color.white);
            }
        }
    }*/

    /*
        panelPrincipal = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon(getClass().getResource(imagenes[indiceImagenActual]));
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon(getClass().getResource(imagenes[indiceImagenActual]));
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        MenuHerramientas = new javax.swing.JMenuBar();
        MenuGestion = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        MenuPersona = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        MenuAsistencia = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        MenuInterfaz = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRACION GENERAL");

        panelPrincipal.setBackground(new java.awt.Color(190, 193, 197));
        panelPrincipal.setToolTipText("");

        jButton5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/Botones/CerraSesion.png"))); // NOI18N
        jButton5.setText("CERRAR SESION");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(61, 90, 134));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/LojoUNL.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Haettenschweiler", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SERVICIO DE ADMINISTRACION GENERAL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addComponent(jLabel2)
                .addContainerGap(283, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 498, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );

        MenuHerramientas.setBorder(null);
        MenuHerramientas.setBorderPainted(false);
        MenuHerramientas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        MenuGestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/MenuBar/Personas.png"))); // NOI18N
        MenuGestion.setText("Gestion administrativa");
        MenuGestion.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jMenuItem4.setText("Gestion universidad");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        MenuGestion.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jMenuItem5.setText("Gestion facultad");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        MenuGestion.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jMenuItem6.setText("Gestion carrera");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        MenuGestion.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jMenuItem7.setText("Gestion malla curricular");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        MenuGestion.add(jMenuItem7);

        jMenuItem8.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jMenuItem8.setText("Gestion unidad curricular");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        MenuGestion.add(jMenuItem8);

        jMenuItem9.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jMenuItem9.setText("Gestion ciclo");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        MenuGestion.add(jMenuItem9);

        jMenuItem10.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jMenuItem10.setText("Gestion materia");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        MenuGestion.add(jMenuItem10);

        jMenuItem11.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jMenuItem11.setText("Gestion matricula");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        MenuGestion.add(jMenuItem11);

        jMenuItem12.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jMenuItem12.setText("Gestion curso");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        MenuGestion.add(jMenuItem12);

        jMenuItem13.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jMenuItem13.setText("Gestion periodo");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        MenuGestion.add(jMenuItem13);

        MenuHerramientas.add(MenuGestion);

        MenuPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/MenuBar/Gestion.png"))); // NOI18N
        MenuPersona.setText("Gestion personas");
        MenuPersona.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jMenuItem1.setText("Gestion de personas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuPersona.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jMenuItem2.setText("Gestion de alumnos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MenuPersona.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jMenuItem3.setText("Gestion de docentes");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        MenuPersona.add(jMenuItem3);

        MenuHerramientas.add(MenuPersona);

        MenuAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/MenuBar/Calendario.png"))); // NOI18N
        MenuAsistencia.setText("Gestion asistencia");
        MenuAsistencia.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jMenuItem14.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jMenuItem14.setText("Gestion horario");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        MenuAsistencia.add(jMenuItem14);

        MenuHerramientas.add(MenuAsistencia);

        MenuInterfaz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/MenuBar/Interfaz.png"))); // NOI18N
        MenuInterfaz.setText("Interfaz principal");
        MenuInterfaz.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jMenuItem16.setText("Gestionar informacion");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        MenuInterfaz.add(jMenuItem16);

        MenuHerramientas.add(MenuInterfaz);

        setJMenuBar(MenuHerramientas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        try {
            int result = JOptionPane.showConfirmDialog(null, "Estas seguro que quieres cerrar sesion?", "CONFIRMAR CIERRE DE SESION", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (result == JOptionPane.YES_OPTION) {
                VistaPrincipalSistema abrirLogin = new VistaPrincipalSistema();
                abrirLogin.setVisible(true);
                this.setVisible(false);
            }
        } 
        catch (Exception e) {
            
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        VistaGestionUniversidad abrirAsistencia = new VistaGestionUniversidad();
        abrirAsistencia.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        try {
            VistaGestionFacultad abrirAsistencia = new VistaGestionFacultad();
            abrirAsistencia.setVisible(true);
            this.setVisible(false);
        }
        catch (Exception e) {

        }

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        try {
            VistaGestionCarrera abrirLogin = new VistaGestionCarrera();
            abrirLogin.setVisible(true);
            this.setVisible(false);
        }
        catch (Exception e) {

        }

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

        try {
            VistaGestionMallaCurricular abrirLogin = new VistaGestionMallaCurricular();
            abrirLogin.setVisible(true);
            this.setVisible(false);
        }
        catch (Exception e) {

        }

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed

        try {
            VistaGestionUnidadCurricular abrirLogin = new VistaGestionUnidadCurricular();
            abrirLogin.setVisible(true);
            this.setVisible(false);
        }
        catch (Exception e) {
        }

    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

        try {
            VistaGestionCiclo abrirLogin;
            abrirLogin = new VistaGestionCiclo();
            abrirLogin.setVisible(true);
            this.setVisible(false);
        }
        catch (ListaVacia ex) {

        }

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed

        try {
            VistaGestionMateria abrirAsistencia = new VistaGestionMateria();
            abrirAsistencia.setVisible(true);
            this.setVisible(false);
        }
        catch (Exception e) {

        }

    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed

        try {
            VistaGestionMatricula abrirAsistencia = new VistaGestionMatricula();
            abrirAsistencia.setVisible(true);
            this.setVisible(false);
        }
        catch (Exception e) {

        }

    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed

        try {
            VistaGestionCurso abrirAsistencia = new VistaGestionCurso();
            abrirAsistencia.setVisible(true);
            this.setVisible(false);
        }
        catch (ListaVacia ex) {

        }

    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed

        try {
            VistaGestionPeriodoAcademico abrirLogin = new VistaGestionPeriodoAcademico();
            abrirLogin.setVisible(true);
            this.setVisible(false);
        }
        catch (Exception e) {

        }

    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        try {
            VistaGestionPersonas abrirAsistencia = new VistaGestionPersonas();
            abrirAsistencia.setVisible(true);
            this.setVisible(false);
        }
        catch (ListaVacia ex) {

        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        try {
            VistaGestionAlumnos abrirLogin = new VistaGestionAlumnos();
            abrirLogin.setVisible(true);
            this.setVisible(false);
        }
        catch (Exception e) {

        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        try {
            VistaGestionDocentes abrirLogin = new VistaGestionDocentes();
            abrirLogin.setVisible(true);
            this.setVisible(false);
        }
        catch (Exception e) {

        }

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed

        try {
            VistaGestionHorario abrirLogin = new VistaGestionHorario();
            abrirLogin.setVisible(true);
            this.setVisible(false);
        }
        catch (Exception e) {

        }

    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed

        VistaGestionInterfazPrincipal vip = new VistaGestionInterfazPrincipal();
        vip.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jMenuItem16ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaPersonalAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPersonalAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPersonalAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPersonalAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPersonalAdministracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAsistencia;
    private javax.swing.JMenu MenuGestion;
    private javax.swing.JMenuBar MenuHerramientas;
    private javax.swing.JMenu MenuInterfaz;
    private javax.swing.JMenu MenuPersona;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
