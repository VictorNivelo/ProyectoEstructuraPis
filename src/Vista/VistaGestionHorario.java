/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Dao.Modelo.horarioDao;
import Controlador.TDA.ListaDinamica.Exepciones.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.Utiles.UtilesControlador;
import Modelo.Horario;
import Vista.ModeloTabla.ModeloTablaHorario;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class VistaGestionHorario extends javax.swing.JFrame {
    horarioDao horarioControlDao = new horarioDao();
    ListaDinamica<Horario> listaHorarios = new ListaDinamica<>();
    ModeloTablaHorario mth = new ModeloTablaHorario();
    
    /**
     * Creates new form GestionDeHorario
     * @throws Controlador.TDA.ListaDinamica.Exepciones.ListaVacia
     */
    public VistaGestionHorario() throws ListaVacia {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Vista/RecursosGraficos/IconoPrograma.png")).getImage());
        CargarTabla();
    }
    
    private void CargarTabla() {
        mth.setHorarioTabla(horarioControlDao.getListaHorario());
        tblHorario.setModel(mth);
        tblHorario.updateUI();
        cbxTipoBusqueda.setSelectedIndex(-1);
    }
    
    private void Limpiar() throws ListaVacia {
        txtDiaHorario.setText("");
        txtHoraInicio.setText("");
        txtHoraFin.setText("");
        txtTematica.setText("");
        horarioControlDao.setHorarios(null);
        CargarTabla();
    }
    
    private void Seleccionar(){
        int fila = tblHorario.getSelectedRow();
        if(fila < 0){
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        }
        else{
            try {
                horarioControlDao.setHorarios(mth.getHorarioTabla().getInfo(fila));
                
                txtDiaHorario.setText(horarioControlDao.getHorarios().getDias());
                txtHoraInicio.setText(horarioControlDao.getHorarios().getHoraIncio());
                txtHoraFin.setText(horarioControlDao.getHorarios().getHoraFin());
                txtTematica.setText(horarioControlDao.getHorarios().getTematicaHorario());
                
            } 
            catch (Exception e) {
                
            }
        }
    }
    
    private void Guardar() throws ListaVacia {

        if (txtDiaHorario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar dia", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (txtHoraInicio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar hora inicio", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (txtHoraFin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar hora fin", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else {
            Integer IdHorario = listaHorarios.getLongitud() + 1;
            String Dia = txtDiaHorario.getText();
            String Inicio = txtHoraInicio.getText();
            String Fin = txtHoraFin.getText();
            String tematica = txtTematica.getText();
                        
            horarioControlDao.getHorarios().setIdHorario(IdHorario);
            horarioControlDao.getHorarios().setDias(Dia);
            horarioControlDao.getHorarios().setHoraIncio(Inicio);
            horarioControlDao.getHorarios().setHoraFin(Fin);
            horarioControlDao.getHorarios().setTematicaHorario(tematica);
                                    
            if (horarioControlDao.Persist()) {
                JOptionPane.showMessageDialog(null, "HORARIO GUARDADA EXISTOSAMENTE", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                horarioControlDao.setHorarios(null);
            } 
            else {
                JOptionPane.showMessageDialog(null, "NO SE PUEDE REGISTRAR", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
            Limpiar();
        }
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDiaHorario = new javax.swing.JTextField();
        txtHoraInicio = new javax.swing.JTextField();
        txtHoraFin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHorario = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbxTipoBusqueda = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtTematica = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GESTION DE HORARIOS");

        jPanel1.setBackground(new java.awt.Color(190, 193, 197));

        jPanel2.setBackground(new java.awt.Color(61, 90, 134));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/LojoUNL.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Haettenschweiler", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CENTRO DE CONTROL DE HORARIOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jLabel2)
                .addContainerGap(339, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Dia");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Hora inicio");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Hora fin");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Tematica");
        jLabel6.setToolTipText("");

        txtDiaHorario.setToolTipText("");

        txtHoraInicio.setToolTipText("");

        txtHoraFin.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Candara Light", 1, 32)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("INFORMACION HORARIO");

        jLabel8.setFont(new java.awt.Font("Candara Light", 1, 32)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("LISTA DE HORARIOS");

        tblHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblHorario.setSelectionBackground(new java.awt.Color(200, 222, 180));
        tblHorario.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHorarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHorario);

        jButton2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton2.setText("MODIFICAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton4.setText("REGRESAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton5.setText("GUARDAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Buscar por");

        cbxTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "Hora de inicio", "Hora de fin", "Tematica" }));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Busqueda");

        txtBuscar.setToolTipText("");

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDiaHorario, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                            .addComponent(txtHoraInicio)
                            .addComponent(txtHoraFin)
                            .addComponent(txtTematica))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDiaHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTematica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 344, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            if (txtDiaHorario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar dia", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (txtHoraInicio.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar hora inicio", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (txtHoraFin.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar hora fin", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else {
                Guardar();
            }

        } 
        catch (Exception e) {

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        VistaPersonalAdministracion abrirLogin = new VistaPersonalAdministracion();
        abrirLogin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int fila = tblHorario.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        } 
        else {
            Integer IdHorario = horarioControlDao.getHorarios().getIdHorario();
            String Dia = txtDiaHorario.getText();
            String Inicio = txtHoraInicio.getText();
            String Fin = txtHoraFin.getText();
            String tematica = txtTematica.getText();
            
            Horario horarioModiPersona = new Horario(IdHorario, Dia, Inicio, Fin, tematica);
            
            horarioControlDao.Merge(horarioModiPersona, fila);
            
            CargarTabla();
            
            try {
                Limpiar();
            } 
            catch (ListaVacia ex) {

            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int fila = tblHorario.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        } 
        else {
            horarioControlDao.Eliminar(fila);
            CargarTabla();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHorarioMouseClicked
        // TODO add your handling code here:
        Seleccionar();
    }//GEN-LAST:event_tblHorarioMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            ListaDinamica<Horario> lista = horarioControlDao.all();
            
            String Campo = txtBuscar.getText();
            String TipoCampo = cbxTipoBusqueda.getSelectedItem().toString();
            
            switch (TipoCampo) {
                case "Dia":
                    TipoCampo = "Dias";
                    break;
                case "Hora de inicio":
                    TipoCampo = "horaIncio";
                    break;
                case "Hora de fin":
                    TipoCampo = "horaFin";
                    break;
                case "Tematica":
                    TipoCampo = "tematicaHorario";
                    break;
                default:
                    throw new AssertionError();
            }
            
            ListaDinamica<Horario> ResultadoBusqueda = UtilesControlador.BusquedaLineal(lista, Campo, TipoCampo);
                        
            mth.setHorarioTabla(ResultadoBusqueda);
            mth.fireTableDataChanged();
            
        } 
        catch (Exception e) {
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaGestionHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGestionHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGestionHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGestionHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VistaGestionHorario().setVisible(true);
                } 
                catch (ListaVacia ex) {

                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxTipoBusqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHorario;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDiaHorario;
    private javax.swing.JTextField txtHoraFin;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtTematica;
    // End of variables declaration//GEN-END:variables
}
