/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Dao.Modelo.asistenciaDao;
import Controlador.TDA.ListaDinamica.Exepciones.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.Utiles.UtilesControlador;
import Modelo.Asistencia;
import Modelo.EstadoAsistencia;
import Vista.ModeloTabla.ModeloTablaAsistencia;
import Vista.Utiles.UtilVista;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class VistaGestionAsistencia extends javax.swing.JFrame {
    ModeloTablaAsistencia mta = new ModeloTablaAsistencia();
    asistenciaDao AsistenciaControl = new asistenciaDao();
    ListaDinamica<Asistencia> listaAsistencia = new ListaDinamica<>();

    /**
     * Creates new form VistaPrincipal
     * @throws Controlador.TDA.ListaDinamica.Exepciones.ListaVacia
     */
    public VistaGestionAsistencia() throws ListaVacia {
        initComponents();
        this.setLocationRelativeTo(null);
        UtilVista.cargarcomboHorario(cbxHorario);
        setIconImage(new ImageIcon(getClass().getResource("/Vista/RecursosGraficos/IconoPrograma.png")).getImage());
        LlenarComboConEnum();
        CargarTabla();
    }
        
    private void CargarTabla() {
        mta.setAsistenciaTabla(AsistenciaControl.getListaAsistencia());
        tblAsistencia.setModel(mta);
        tblAsistencia.updateUI();
        cbxAsistencia.setSelectedIndex(-1);
        cbxHorario.setSelectedIndex(-1);
        cbxTipoBusqueda.setSelectedIndex(-1);
    }
    
    public void LlenarComboConEnum() {
        for (EstadoAsistencia tipo : EstadoAsistencia.values()) {
            cbxAsistencia.addItem(tipo.getDescripcion());
        }
    }
    
    private void Limpiar() throws ListaVacia {
        txtObservacion.setText("");
        txtDia.setText("");
        txtHora.setText("");
        cbxAsistencia.setSelectedIndex(-1);
        cbxHorario.setSelectedIndex(-1);
        cbxTipoBusqueda.setSelectedIndex(-1);
        AsistenciaControl.setAsistencias(null);
        CargarTabla();
    }
    
    private void Seleccionar(){
        int fila = tblAsistencia.getSelectedRow();
        if(fila < 0){
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        }
        else{
            try {
                AsistenciaControl.setAsistencias(mta.getAsistenciaTabla().getInfo(fila));
                
                txtDia.setText(AsistenciaControl.getAsistencias().getDiaAsistencia());
                txtHora.setText(AsistenciaControl.getAsistencias().getHoraAsistencia());
                txtObservacion.setText(AsistenciaControl.getAsistencias().getObservacion());
                cbxAsistencia.setSelectedItem(AsistenciaControl.getAsistencias().getEstadoAsistencia().toString());
                txtObservacion.setText(AsistenciaControl.getAsistencias().getObservacion());
                cbxHorario.setSelectedIndex(AsistenciaControl.getAsistencias().getHorarioAsistencia().getIdHorario()-1);

            } 
            catch (Exception e) {
                
            }
        }
    }
    
    private void Guardar() throws ListaVacia {

        if (txtDia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar nombre de la carrera", "Error", JOptionPane.INFORMATION_MESSAGE);
        } 
        else if (txtHora.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar nombre de la carrera", "Error", JOptionPane.INFORMATION_MESSAGE);
        } 
        else if (cbxAsistencia.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar la asistencia", "Error", JOptionPane.INFORMATION_MESSAGE);
        } 
        else if (txtObservacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar duracion", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(cbxHorario.getSelectedIndex() ==-1){
            JOptionPane.showMessageDialog(null, "Falta seleccionar la horario", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            Integer IdAsistencia = listaAsistencia.getLongitud() + 1;
            String Dia = txtDia.getText();
            String Hora = txtHora.getText();
            
            int indiceSeleccionado = cbxAsistencia.getSelectedIndex();
            EstadoAsistencia[] valores = EstadoAsistencia.values();
            EstadoAsistencia estadoSeleccionado = valores[indiceSeleccionado];
                        
            String Observacion = txtObservacion.getText();
                                    
            AsistenciaControl.getAsistencias().setIdAsistencia(IdAsistencia);
            AsistenciaControl.getAsistencias().setDiaAsistencia(Dia);
            AsistenciaControl.getAsistencias().setHoraAsistencia(Hora);
            AsistenciaControl.getAsistencias().setEstadoAsistencia(estadoSeleccionado);
            AsistenciaControl.getAsistencias().setObservacion(Observacion);
            AsistenciaControl.getAsistencias().setHorarioAsistencia(UtilVista.obtenerHorarioControl(cbxHorario));
                        
            if (AsistenciaControl.Persist()) {
                JOptionPane.showMessageDialog(null, "ASISTENCIA GUARDADA EXISTOSAMENTE", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                AsistenciaControl.setAsistencias(null);
            } 
            else {
                JOptionPane.showMessageDialog(null, "NO SE PUEDE REGISTRAR", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
            Limpiar();
        }
    }
    
//    public static <T> ListaDinamica<T> buscarEnLista(ListaDinamica<T> lista, String campo, Field field) {
//        ListaDinamica<T> resultados = new ListaDinamica<>();
//
//        for (T elemento : lista.toArray()) {
//            try {
//                Field campoElemento = UtilesControlador.getField(elemento.getClass(), field);
//                campoElemento.setAccessible(true);
//
//                Object valorElemento = campoElemento.get(elemento);
//
//                if (valorElemento != null && valorElemento.toString().contains(campo)) {
//                    resultados.Agregar(elemento);
//                }
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return resultados;
//    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAsistencia = new javax.swing.JTable();
        btnRegistrarAsistencias = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbxAsistencia = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtObservacion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbxTipoBusqueda = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbxHorario = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GESTION DE ASISTENCIAS");

        jPanel2.setBackground(new java.awt.Color(191, 192, 197));

        jPanel1.setBackground(new java.awt.Color(61, 90, 134));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/LojoUNL.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Haettenschweiler", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CENTRO DE CONTROL DE ASISTENCIAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Candara Light", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SELECCIONAR CURSO");

        jLabel7.setFont(new java.awt.Font("Candara Light", 1, 32)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("LISTA DE ASISTENCIA");

        btnRegresar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        tblAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAsistencia.setSelectionBackground(new java.awt.Color(200, 222, 180));
        tblAsistencia.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAsistenciaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAsistencia);

        btnRegistrarAsistencias.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnRegistrarAsistencias.setText("GUARDAR");
        btnRegistrarAsistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAsistenciasActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Asistencia");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Observacion");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Dia");
        jLabel10.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Hora");

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Buscar por");

        cbxTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "Hora", "Estado de asistencia", "Observacion" }));
        cbxTipoBusqueda.setSelectedIndex(-1);

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Buscar");

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Horario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrarAsistencias))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtObservacion)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxAsistencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHora)
                            .addComponent(txtDia)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxHorario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(651, 651, 651)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbxAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnRegistrarAsistencias)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            ListaDinamica<Asistencia> lista = AsistenciaControl.all();

            String Campo = txtBuscar.getText();
            String TipoCampo = cbxTipoBusqueda.getSelectedItem().toString();

            switch (TipoCampo) {
                case "Dia":
                    TipoCampo = "DiaAsistencia";
                    break;
                case "Hora":
                    TipoCampo = "HoraAsistencia";
                    break;
                case "Estado de asistencia":
                    TipoCampo = "estadoAsistencia";
                    break;
                case "Observacion":
                    TipoCampo = "Observacion";
                    break;
                default:
                    throw new AssertionError();
            }

            ListaDinamica<Asistencia> ResultadoBusqueda = UtilesControlador.BusquedaLineal(lista, Campo, TipoCampo);

            mta.setAsistenciaTabla(ResultadoBusqueda);
            mta.fireTableDataChanged();

        }
        catch (Exception e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int fila = tblAsistencia.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        }
        else {
            AsistenciaControl.Eliminar(fila);
            CargarTabla();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int fila = tblAsistencia.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        }
        else {
            Integer IdAsistencia = AsistenciaControl.getAsistencias().getIdAsistencia();
            String Dia = txtDia.getText();
            String Hora = txtHora.getText();

            int indiceSeleccionado = cbxAsistencia.getSelectedIndex();
            EstadoAsistencia[] valores = EstadoAsistencia.values();
            EstadoAsistencia estadoSeleccionado = valores[indiceSeleccionado];

            String Observacion = txtObservacion.getText();

            Asistencia personaModiPersona = new Asistencia(IdAsistencia, Dia, Hora, estadoSeleccionado, Observacion, UtilVista.obtenerHorarioControl(cbxHorario));

            AsistenciaControl.Merge(personaModiPersona, fila);

            CargarTabla();

            try {
                Limpiar();
            }
            catch (ListaVacia ex) {

            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRegistrarAsistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAsistenciasActionPerformed
        // TODO add your handling code here:
        try {
            Guardar();
        }
        catch (Exception e) {

        }
    }//GEN-LAST:event_btnRegistrarAsistenciasActionPerformed

    private void tblAsistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAsistenciaMouseClicked
        // TODO add your handling code here:
        Seleccionar();
    }//GEN-LAST:event_tblAsistenciaMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        VistaPersonalAdministracion abrirLogin = new VistaPersonalAdministracion();
        abrirLogin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(VistaGestionAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGestionAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGestionAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGestionAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                try {
                    new VistaGestionAsistencia().setVisible(true);
                } 
                catch (ListaVacia ex) {
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrarAsistencias;
    private javax.swing.JToggleButton btnRegresar;
    private javax.swing.JComboBox<String> cbxAsistencia;
    private javax.swing.JComboBox<String> cbxHorario;
    private javax.swing.JComboBox<String> cbxTipoBusqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAsistencia;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtObservacion;
    // End of variables declaration//GEN-END:variables
}
