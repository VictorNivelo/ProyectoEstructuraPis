
package Vista;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.Dao.Modelo.materiaDao;
import Controlador.TDA.ListaDinamica.Excepcion.ListaVacia;
import Controlador.Utiles.UtilesControlador;
import Modelo.Materia;
import Vista.Utiles.UtilVista;
import Vista.ModeloTabla.ModeloTablaMateria;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class VistaGestionMateria extends javax.swing.JFrame {
    materiaDao materiaControlDao = new materiaDao();
    ListaDinamica<Materia> listaMateria = new ListaDinamica<>();
    ModeloTablaMateria mtp = new ModeloTablaMateria();

    /**
     * Creates new form VistaRegistroMateria
     * @throws Controlador.TDA.ListaDinamica.Excepcion.ListaVacia
     */
    public VistaGestionMateria() throws ListaVacia {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Vista/RecursosGraficos/IconoPrograma.png")).getImage());
        UtilVista.cargarcomboHorario(cbxHorario);
        UtilVista.cargarComboCiclo(cbxCiclo);
        CargarTabla();
    }
    
    private void CargarTabla() {
        mtp.setMateriaTabla(materiaControlDao.getListaMateria());
        tblMaterias.setModel(mtp);
        tblMaterias.updateUI();
        cbxCiclo.setSelectedIndex(-1);
        cbxHorario.setSelectedIndex(-1);
        cbxTipoBusqueda.setSelectedIndex(-1);
    }
    
    private void Limpiar() throws ListaVacia {
        txtNombreMateria.setText("");
        txtNombreDescripcion.setText("");
        txtNumeroHoras.setText("");
        cbxTipoBusqueda.setSelectedIndex(-1);
        cbxHorario.setSelectedIndex(-1);
        cbxCiclo.setSelectedIndex(-1);
        materiaControlDao.setMateria(null);
        CargarTabla();
    }
    
    private void Seleccionar(){
        int fila = tblMaterias.getSelectedRow();
        if(fila < 0){
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        }
        else{
            try {
                materiaControlDao.setMateria(mtp.getMateriaTabla().getInfo(fila));
                
                txtNombreMateria.setText(materiaControlDao.getMateria().getNombreMateria());
                txtNombreDescripcion.setText(materiaControlDao.getMateria().getDescipcionMateria());
                txtNumeroHoras.setText(materiaControlDao.getMateria().getNumeroHoras());
                cbxHorario.setSelectedIndex(materiaControlDao.getMateria().getHorarioMateria().getIdHorario()-1);
                cbxCiclo.setSelectedIndex(materiaControlDao.getMateria().getCicloMateria().getIdCiclo() -1);
            } 
            catch (Exception e) {
                
            }
        }
    }
    
    private void Guardar() throws ListaVacia {

        if (txtNombreMateria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar numero dni", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtNombreDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar nombre", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(txtNumeroHoras.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Falta llenar numero de horas", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(cbxHorario.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Falta seleccionar el horario", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            //Datos de meteria
            Integer IdPersona = listaMateria.getLongitud() + 1;
            String NombreAsignatura = txtNombreMateria.getText();
            String Descripcion = txtNombreDescripcion.getText();
            String NumeroHoras = txtNumeroHoras.getText().toString();
            
            materiaControlDao.getMateria().setIdMateria(IdPersona);
            materiaControlDao.getMateria().setNombreMateria(NombreAsignatura);
            materiaControlDao.getMateria().setDescipcionMateria(Descripcion);
            materiaControlDao.getMateria().setNumeroHoras(NumeroHoras);
            materiaControlDao.getMateria().setHorarioMateria(UtilVista.obtenerHorarioControl(cbxHorario));
            materiaControlDao.getMateria().setCicloMateria(UtilVista.obtenerCicloControl(cbxCiclo));
            
            if (materiaControlDao.Persist()) {
                JOptionPane.showMessageDialog(null, "MATERIA GUARDADA EXISTOSAMENTE", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                materiaControlDao.setMateria(null);
            } 
            else {
                JOptionPane.showMessageDialog(null, "NO SE PUEDE GUARDAR", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
            Limpiar();
        }
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreMateria = new javax.swing.JTextField();
        txtNombreDescripcion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMaterias = new javax.swing.JTable();
        btnGuardarMateria = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbxTipoBusqueda = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxHorario = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtNumeroHoras = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbxCiclo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GESTION DE MATERIAS");

        jPanel1.setBackground(new java.awt.Color(190, 193, 197));

        jPanel2.setBackground(new java.awt.Color(61, 90, 134));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/LojoUNL.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Haettenschweiler", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SERVICIO DE ADMINISTRACION DE MATERIAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Descripcion");

        txtNombreMateria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreMateriaKeyTyped(evt);
            }
        });

        txtNombreDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreDescripcionKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Candara Light", 1, 32)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Informacion");

        jLabel7.setFont(new java.awt.Font("Candara Light", 1, 32)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Lista de materias");

        tblMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMaterias.setSelectionBackground(new java.awt.Color(200, 222, 180));
        tblMaterias.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMateriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMaterias);

        btnGuardarMateria.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnGuardarMateria.setText("GUARDAR");
        btnGuardarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarMateriaActionPerformed(evt);
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

        btnRegresar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Buscar por");

        cbxTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Descripcion", "Numero de horas", "Horario" }));
        cbxTipoBusqueda.setSelectedIndex(-1);

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Busqueda");

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Curso");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nro de horas");

        txtNumeroHoras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroHorasKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Ciclo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarMateria))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreDescripcion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNumeroHoras)
                            .addComponent(txtNombreMateria, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxHorario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxCiclo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 571, Short.MAX_VALUE)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar))))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(6, 6, 6))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombreMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar)
                            .addComponent(btnGuardarMateria)
                            .addComponent(btnRegresar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNombreDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNumeroHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbxCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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

    private void btnGuardarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMateriaActionPerformed
        
        if(txtNombreMateria.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nombre de materia vacio", "CAMPO VACIO", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(txtNombreDescripcion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Descripcion vacia", "CAMPO VACIO", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(txtNumeroHoras.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Falta llenar numero de horas", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (cbxHorario.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar horario", "Error", JOptionPane.INFORMATION_MESSAGE);
        } 
        else{
            try {
                Guardar();
            } 
            catch (ListaVacia ex) {

            }
        }
        
    }//GEN-LAST:event_btnGuardarMateriaActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        int fila = tblMaterias.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        } 
        else {

            if (txtNombreMateria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nombre de materia vacio", "CAMPO VACIO", JOptionPane.INFORMATION_MESSAGE);
            } 
            else if (txtNombreDescripcion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Descripcion vacia", "CAMPO VACIO", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (txtNumeroHoras.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar numero de horas", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (cbxHorario.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Falta seleccionar horario", "Error", JOptionPane.INFORMATION_MESSAGE);
            } 
            else {
                //Datos de materia
                Integer IdMateria = materiaControlDao.getMateria().getIdMateria();
                String NombreMateria = txtNombreMateria.getText();
                String DescipcionMateria = txtNombreDescripcion.getText();
                String NumeroHoras = txtNumeroHoras.getText().toString();

                Materia materiaModificada = new Materia();
                materiaModificada.setIdMateria(IdMateria);
                materiaModificada.setNombreMateria(NombreMateria);
                materiaModificada.setDescipcionMateria(DescipcionMateria);
                materiaModificada.setNumeroHoras(NumeroHoras);
                materiaModificada.setCicloMateria(UtilVista.obtenerCicloControl(cbxCiclo));

                materiaControlDao.Merge(materiaModificada, IdMateria - 1);

                CargarTabla();

                try {
                    Limpiar();
                } 
                catch (ListaVacia ex) {

                }
            }

        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        int fila = tblMaterias.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        }
        else {
            materiaControlDao.Eliminar(fila);
            CargarTabla();
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        
        VistaPersonalAdministracion abrirLogin = new VistaPersonalAdministracion();
        abrirLogin.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            ListaDinamica<Materia> lista = materiaControlDao.all();
            
            String Campo = txtBuscar.getText();
            String TipoCampo = cbxTipoBusqueda.getSelectedItem().toString();
            
            switch (TipoCampo) {
                case "Nombre":
                    TipoCampo = "NombreMateria";
                    break;
                case "Descripcion":
                    TipoCampo = "DescipcionMateria";
                    break;
                case "Numero de horas":
                    TipoCampo = "NumeroHoras";
                    break;
                case "Horario":
                    TipoCampo = "HorarioMateria.DiaSemana";
                    break;

                default:
                    throw new AssertionError();
            }
            
            ListaDinamica<Materia> ResultadoBusqueda = UtilesControlador.BusquedaLineal(lista, Campo, TipoCampo);
                        
            mtp.setMateriaTabla(ResultadoBusqueda);
            mtp.fireTableDataChanged();
            
        } 
        catch (Exception e) {
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblMateriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMateriasMouseClicked
        
        Seleccionar();
        
    }//GEN-LAST:event_tblMateriasMouseClicked

    private void txtNombreMateriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreMateriaKeyTyped
        
        char c = evt.getKeyChar();

        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingreso de letras", "CARACTER NO VALIDO", JOptionPane.WARNING_MESSAGE);
        }
        if (c != KeyEvent.VK_BACK_SPACE) {

        }
        
    }//GEN-LAST:event_txtNombreMateriaKeyTyped

    private void txtNombreDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreDescripcionKeyTyped
        
        char c = evt.getKeyChar();

        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingreso de letras", "CARACTER NO VALIDO", JOptionPane.WARNING_MESSAGE);
        }
        if (c != KeyEvent.VK_BACK_SPACE) {

        }
        
    }//GEN-LAST:event_txtNombreDescripcionKeyTyped

    private void txtNumeroHorasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroHorasKeyTyped
        
        Character c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingreso de numeros", "CARACTER NO VALIDO", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_txtNumeroHorasKeyTyped

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
            java.util.logging.Logger.getLogger(VistaGestionMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGestionMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGestionMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGestionMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new VistaGestionMateria().setVisible(true);
                } catch (ListaVacia ex) {

                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarMateria;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxCiclo;
    private javax.swing.JComboBox<String> cbxHorario;
    private javax.swing.JComboBox<String> cbxTipoBusqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTable tblMaterias;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNombreDescripcion;
    private javax.swing.JTextField txtNombreMateria;
    private javax.swing.JTextField txtNumeroHoras;
    // End of variables declaration//GEN-END:variables
}
