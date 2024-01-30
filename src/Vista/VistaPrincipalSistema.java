
package Vista;

import Controlador.Dao.Modelo.presentacionDao;
import Controlador.TDA.ListaDinamica.Excepcion.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Presentacion;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Victor
 */
public class VistaPrincipalSistema extends javax.swing.JFrame {
    presentacionDao presentacionControlDao = new presentacionDao();
    private ListaDinamica<Presentacion> listaPresentacion = presentacionControlDao.all();
    private ListaDinamica<Presentacion> imagenesPersonalizadas = new ListaDinamica<>();
          
    private final String[] imagenes = {
        "/Vista/RecursosGraficos/Fondos/Fondo1.jpg",
        "/Vista/RecursosGraficos/Fondos/Fondo2.jpg",
        "/Vista/RecursosGraficos/Fondos/Fondo3.jpg",
        "/Vista/RecursosGraficos/Fondos/Fondo4.jpg"
    };
    
    private int indiceImagenActual = 0;
    private Timer timer;

    /**
     * Creates new form VistaPrincipalSistema
     * @throws Controlador.TDA.ListaDinamica.Excepcion.ListaVacia
     */
    public VistaPrincipalSistema() throws ListaVacia {
        initComponents();
        this.setLocationRelativeTo(null);
        
        panelPrincipal.setOpaque(false);
        txaContenido.setOpaque(false);
        txaContenido.setBorder(null);
        jScrollPane2.setOpaque(false); 
        jScrollPane2.getViewport().setOpaque(false); 
        jScrollPane2.setBorder(null);
        jScrollPane2.setBackground(new Color(0, 0, 0, 90)); 
        MenuPrincipal.setOpaque(false);
        MenuPrincipal.setBackground(new Color(61,90,134));

        setIconImage(new ImageIcon(getClass().getResource("/Vista/RecursosGraficos/IconoPrograma.png")).getImage());
        
//        for (String imagenPath : imagenes) {
//            Presentacion presentacion = new Presentacion();
//            presentacion.setImagen(imagenPath);
//            imagenesPersonalizadas.AgregarFinal(presentacion);
//            
//        }
//
//        listaPresentacion.concatenar(imagenesPersonalizadas);
//        
//        System.out.println(imagenesPersonalizadas);
                        
        timer = new Timer(3000, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarImagen();
                try {
                    CargarDatos();
                } 
                catch (ListaVacia ex) {

                }
            }
        });
        timer.start();
    }
    
    private void concatenarImagenesListaPresentacion() {
        ListaDinamica<Presentacion> imagenesPresentacion = new ListaDinamica<>();
        for (int i = 0; i < listaPresentacion.getLongitud(); i++) {
            try {
                Presentacion presentacion = listaPresentacion.getInfo(i);
                imagenesPresentacion.AgregarFinal(presentacion);
            } 
            catch (ListaVacia e) {
                e.printStackTrace();
            }
        }

        imagenesPersonalizadas.concatenar(imagenesPresentacion);
    }
    
    private void CargarDatos() throws ListaVacia {
        String auxTitulo = "";
        String aux = "";
        String auxEstado = "";
        try {
            auxEstado = listaPresentacion.getInfo(indiceImagenActual).getEstadoPresentacion();
            if ("Activa".equalsIgnoreCase(auxEstado)) {
                auxTitulo = listaPresentacion.getInfo(indiceImagenActual).getTitulo();
                aux = listaPresentacion.getInfo(indiceImagenActual).getContenido();
                txtTitulo.setText(auxTitulo);
                txaContenido.setText(aux);
                System.out.println();
            }
        } 
        catch (IndexOutOfBoundsException ex) {
            indiceImagenActual = 0;
            auxTitulo = listaPresentacion.getInfo(indiceImagenActual).getTitulo();
            aux = listaPresentacion.getInfo(indiceImagenActual).getContenido();
            txtTitulo.setText(auxTitulo);
            txaContenido.setText(aux);
            System.out.println();
        }
    }
    
    //nuevo falta probvar
//    private void cambiarImagen() {
//    if (listaPresentacion.getLongitud() > 0) {
//        try {
//            Presentacion presentacion = listaPresentacion.getInfo(indiceImagenActual);
//            String rutaImagen = presentacion.getImagen();
//
//            if (rutaImagen != null) {
//                System.out.println("Intentando cargar la imagen desde la ruta: " + rutaImagen);
//
//                URL imageUrl = getClass().getResource(rutaImagen);
//                if (imageUrl != null) {
//                    ImageIcon icon = new ImageIcon(imageUrl);
//                    if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
//                        panelPrincipal.getGraphics().drawImage(icon.getImage(), 0, 0, panelPrincipal.getWidth(), panelPrincipal.getHeight(), panelPrincipal);
//                        CargarDatos();
//                    } else {
//                        System.err.println("Error al cargar la imagen: la carga no se ha completado.");
//                    }
//                } else {
//                    System.err.println("Error al cargar la imagen: la URL es nula.");
//                }
//            } else {
//                System.err.println("La ruta de la imagen es nula.");
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();  // Imprimir la traza completa de la excepción
//        }
//    }
//}
    
//    private void cambiarImagen() {
//        if (listaPresentacion.getLongitud() > 0) {
//            try {
//                Presentacion presentacion = listaPresentacion.getInfo(indiceImagenActual);
//                ImageIcon icon = new ImageIcon(getClass().getResource(presentacion.getImagen()));
//                panelPrincipal.getGraphics().drawImage(icon.getImage(), 0, 0, panelPrincipal.getWidth(), panelPrincipal.getHeight(), panelPrincipal);
//                CargarDatos();
//            }
//            catch (ListaVacia ex) {
//                ex.printStackTrace();
//            } 
//            catch (IndexOutOfBoundsException ex) {
//                indiceImagenActual = 0;
//                cambiarImagen();  // Llamada recursiva para manejar el índice fuera de límites
//            }
//        }
//    }

    private void cambiarImagen() {
        indiceImagenActual = (indiceImagenActual + 1) % imagenes.length;
        panelPrincipal.repaint();
    }

    /*private void CargarDatos() throws ListaVacia {
        String auxTitulo = "";
        String aux = "";
        String auxEstado = "";
        try {
            auxEstado = listaPresentacion.getInfo(indiceImagenActual).getEstadoPresentacion();
            if ("Activa".equalsIgnoreCase(auxEstado)) {
                auxTitulo = listaPresentacion.getInfo(indiceImagenActual).getTitulo();
                aux = listaPresentacion.getInfo(indiceImagenActual).getContenido();
                txtTitulo.setText(auxTitulo);
                txaContenido.setText(aux);
                System.out.println();
            }
        } 
        catch (IndexOutOfBoundsException ex) {
            indiceImagenActual = 0;
            auxTitulo = listaPresentacion.getInfo(indiceImagenActual).getTitulo();
            aux = listaPresentacion.getInfo(indiceImagenActual).getContenido();
            txtTitulo.setText(auxTitulo);
            txaContenido.setText(aux);
            System.out.println();
        }
    }*/
//
//    private void cambiarImagen() {
//        indiceImagenActual = (indiceImagenActual + 1) % imagenes.length;
//        panelPrincipal.repaint();
//    }

    /* utiles para presentar por netbeans
    panelPrincipal = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon(getClass().getResource(imagenes[indiceImagenActual]));
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
    
    MenuPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER));

        MenuSga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/MenuBar/Alumno.png"))); // NOI18N
        MenuSga.setText("SGA");
        MenuSga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuSga.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MenuSga.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        MenuSga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuSgaMouseClicked(evt);
            }
        });
        MenuPrincipal.add(MenuSga);
    */

    //Presentar actual
    /*panelPrincipal = new javax.swing.JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            try {
                String rutaImagen = listaPresentacion.getInfo(indiceImagenActual).getRutaImagen();
                ImageIcon icon = new ImageIcon(getClass().getResource(rutaImagen));
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            } catch (IndexOutOfBoundsException ex) {
                // Manejar la excepción si es necesario
            }
        }
    };*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        /*panelPrincipal = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    Presentacion presentacion = listaPresentacion.getInfo(indiceImagenActual);
                    String rutaImagen = presentacion.getImagen();
                    
                    if (rutaImagen != null) {
                        ImageIcon icon = new ImageIcon(getClass().getResource(rutaImagen));
                        g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
                    } else {
                        System.err.println("La ruta de la imagen es nula.");
                    }
                } catch (IndexOutOfBoundsException ex) {
                    // Manejar la excepción si es necesario
                } catch (ListaVacia e) {
                    e.printStackTrace();
                }
            }
        };*/

        panelPrincipal = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon(getClass().getResource(imagenes[indiceImagenActual]));
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        bordesRedondos1 = new Vista.Utiles.BordesRedondos();
        txtTitulo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaContenido = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        MenuPrincipal = new javax.swing.JMenuBar();
        MenuSga = new javax.swing.JMenu();
        MenuPersonal = new javax.swing.JMenu();
        MenuAcerca = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UNIVERSIDAD NACIONAL DE LOJA");

        bordesRedondos1.setBackground(new java.awt.Color(0, 0, 0, 90));
        bordesRedondos1.setRoundBottomLeft(30);
        bordesRedondos1.setRoundBottomRight(30);
        bordesRedondos1.setRoundTopLeft(30);
        bordesRedondos1.setRoundTopRight(30);

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo.setText("La Transformación Continúa ");
        txtTitulo.setFocusable(false);

        jSeparator2.setBackground(new java.awt.Color(226, 6, 19));
        jSeparator2.setForeground(new java.awt.Color(226, 6, 19));
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jSeparator2.setOpaque(true);
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 5));

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0,90));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setEnabled(false);
        jScrollPane2.setFocusable(false);
        jScrollPane2.setRequestFocusEnabled(false);

        txaContenido.setEditable(false);
        txaContenido.setBackground(new java.awt.Color(0, 0, 0,0));
        txaContenido.setColumns(20);
        txaContenido.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txaContenido.setForeground(new java.awt.Color(255, 255, 255));
        txaContenido.setText("Desde hace 163 años, somos la Institución  de Educación \nSuperior líder en el desarrollo de la cultura,  \nciencia y conocimiento de la Región Sur del Ecuador  ");
        txaContenido.setAutoscrolls(false);
        txaContenido.setBorder(null);
        txaContenido.setCaretColor(new java.awt.Color(0, 0, 0));
        txaContenido.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txaContenido.setFocusable(false);
        txaContenido.setOpaque(false);
        txaContenido.setRequestFocusEnabled(false);
        txaContenido.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txaContenido.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(txaContenido);

        javax.swing.GroupLayout bordesRedondos1Layout = new javax.swing.GroupLayout(bordesRedondos1);
        bordesRedondos1.setLayout(bordesRedondos1Layout);
        bordesRedondos1Layout.setHorizontalGroup(
            bordesRedondos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bordesRedondos1Layout.createSequentialGroup()
                .addGroup(bordesRedondos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bordesRedondos1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(bordesRedondos1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(bordesRedondos1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bordesRedondos1Layout.setVerticalGroup(
            bordesRedondos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bordesRedondos1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/LogoMediano.png"))); // NOI18N

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bordesRedondos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(642, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(76, 76, 76)
                .addComponent(bordesRedondos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );

        MenuPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER));

        MenuSga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/MenuBar/Alumno.png"))); // NOI18N
        MenuSga.setText("SGA");
        MenuSga.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        MenuSga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuSgaMouseClicked(evt);
            }
        });
        MenuPrincipal.add(MenuSga);

        MenuPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/MenuBar/Personal.png"))); // NOI18N
        MenuPersonal.setText("PERSONAL ADMINISTRATIVO");
        MenuPersonal.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        MenuPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuPersonalMouseClicked(evt);
            }
        });
        MenuPrincipal.add(MenuPersonal);

        MenuAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/MenuBar/Acerca.png"))); // NOI18N
        MenuAcerca.setText("ACERCA DE LA UNVERSIDAD");
        MenuAcerca.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        MenuAcerca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAcercaMouseClicked(evt);
            }
        });
        MenuPrincipal.add(MenuAcerca);

        setJMenuBar(MenuPrincipal);

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

    private void MenuSgaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSgaMouseClicked
        
        VistaInicioSesion vi = new VistaInicioSesion();
        vi.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_MenuSgaMouseClicked

    private void MenuPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPersonalMouseClicked
        
        VistaInicioSesionPersonal vi = new VistaInicioSesionPersonal();
        vi.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_MenuPersonalMouseClicked

    private void MenuAcercaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAcercaMouseClicked
        
        VistaInicioSesion vi = new VistaInicioSesion();
        vi.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_MenuAcercaMouseClicked

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VistaPrincipalSistema().setVisible(true);
                } catch (ListaVacia ex) {

                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAcerca;
    private javax.swing.JMenu MenuPersonal;
    private javax.swing.JMenuBar MenuPrincipal;
    private javax.swing.JMenu MenuSga;
    private Vista.Utiles.BordesRedondos bordesRedondos1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextArea txaContenido;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
