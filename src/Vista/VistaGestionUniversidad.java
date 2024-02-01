
package Vista;

import Controlador.Dao.Modelo.universidadDao;
import Controlador.TDA.ListaDinamica.Excepcion.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.Utiles.UtilesControlador;
import Modelo.Universidad;
import Vista.ModeloTabla.ModeloTablaUniversidad;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class VistaGestionUniversidad extends javax.swing.JFrame {
    universidadDao universidadControlDao = new universidadDao();
    ModeloTablaUniversidad mtp = new ModeloTablaUniversidad();
    ListaDinamica<Universidad> listaUniversidades = new ListaDinamica<>();
    SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form VistaGestionUniversidad
     */
    public VistaGestionUniversidad() {
        initComponents();
        this.setLocationRelativeTo(null);
        DateFundacion.setDateFormatString("dd/MM/yyyy");
        setIconImage(new ImageIcon(getClass().getResource("/Vista/RecursosGraficos/IconoPrograma.png")).getImage());
        CargarTabla();
    }
    
    private void CargarTabla(){
        mtp.setUniversidadTabla(universidadControlDao.all());
        tblUniversidades.setModel(mtp);
        tblUniversidades.updateUI();
        cbxTipoBusqueda.setSelectedIndex(-1);
    }
    
    public void Limpiar() {
        txtCorreo.setText("");
        txtDireccionU.setText("");
        txtNombreU.setText("");
        txtTelefono.setText("");
        DateFundacion.setDate(null);
        universidadControlDao.setUniversidades(null);
        CargarTabla();
    }
    
    private void Seleccionar(){
        int fila = tblUniversidades.getSelectedRow();
        if(fila < 0){
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        }
        else{
            try {
                universidadControlDao.setUniversidades(mtp.getUniversidadTabla().getInfo(fila));
                
                Date Inicio = Formato.parse(universidadControlDao.getUniversidades().getFechaFundacion());
                DateFundacion.setDate(Inicio);
                txtNombreU.setText(universidadControlDao.getUniversidades().getNombreUniversidad());
                txtDireccionU.setText(universidadControlDao.getUniversidades().getDireccionUniversidad());
                txtTelefono.setText(universidadControlDao.getUniversidades().getNumeroTelefono());
                txtCorreo.setText(universidadControlDao.getUniversidades().getCorreoUniversidad());
                
            } 
            catch (Exception e) {
                
            }
        }
    }
    
    private void Guardar() throws ListaVacia {

        if (txtNombreU.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar el nombre de la universidad", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtDireccionU.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar la direccion", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar el numero de telefono", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtCorreo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar el correo de la universidad", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (DateFundacion.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Falta llenar fecha de fundacion", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            Integer idUniversidad = listaUniversidades.getLongitud() + 1;
            
            Date InicioD = DateFundacion.getDate();
            String Fundacion = Formato.format(InicioD);
            String Nombre = txtNombreU.getText();
            String Direccion = txtDireccionU.getText();
            String Telefono = txtTelefono.getText();
            String Correo = txtCorreo.getText();
            
            universidadControlDao.getUniversidades().setIdUniversidad(idUniversidad);
            universidadControlDao.getUniversidades().setNombreUniversidad(Nombre);
            universidadControlDao.getUniversidades().setDireccionUniversidad(Direccion);
            universidadControlDao.getUniversidades().setNumeroTelefono(Telefono);
            universidadControlDao.getUniversidades().setCorreoUniversidad(Correo);
            universidadControlDao.getUniversidades().setFechaFundacion(Fundacion);

            
            if (universidadControlDao.Persist()) {
                JOptionPane.showMessageDialog(null, "PERIODO GUARDADO EXISTOSAMENTE", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                universidadControlDao.setUniversidades(null);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxTipoBusqueda = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtNombreU = new javax.swing.JTextField();
        txtDireccionU = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        DateFundacion = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUniversidades = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA DE GESTION DE UNIVERSIDADES");

        jPanel1.setBackground(new java.awt.Color(190, 193, 197));

        jPanel2.setBackground(new java.awt.Color(61, 90, 134));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/LojoUNL.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Haettenschweiler", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SERVICIO DE GESTION DE UNIVERSIDAD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addContainerGap(341, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Candara Light", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Informacion");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Direccion");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Telefono");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Correo");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Fundacion");

        jLabel9.setFont(new java.awt.Font("Candara Light", 1, 32)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Lista de universidades");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Buscar por");

        cbxTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Direccion", "Telefono", "Correo", "Fecha de fundacion" }));
        cbxTipoBusqueda.setSelectedIndex(-1);

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Busqueda");

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/Botones/Buscar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton2.setText("REGRESAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton3.setText("GUARDAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton4.setText("MODIFICAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton5.setText("ELIMINAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tblUniversidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblUniversidades.setSelectionBackground(new java.awt.Color(200, 222, 180));
        tblUniversidades.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblUniversidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUniversidadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUniversidades);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreU)
                            .addComponent(txtDireccionU)
                            .addComponent(txtTelefono)
                            .addComponent(txtCorreo)
                            .addComponent(DateFundacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jButton1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDireccionU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DateFundacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton2))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        VistaPersonalAdministracion abrirLogin = new VistaPersonalAdministracion();
        abrirLogin.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        try {
            if (txtNombreU.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar el nombre de la universidad", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (txtDireccionU.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar la direccion", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (txtTelefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar el numero de telefono", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (txtCorreo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar el correo de la universidad", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (DateFundacion.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Falta llenar fecha de fundacion", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else {
                Guardar();
            }
        } 
        catch (Exception e) {

        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        int fila = tblUniversidades.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        } else {

            if (txtNombreU.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar el nombre de la universidad", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (txtDireccionU.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar la direccion", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (txtTelefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar el numero de telefono", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (txtCorreo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar el correo de la universidad", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (DateFundacion.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Falta llenar fecha de fundacion", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else {
                Integer IdUniversidad = universidadControlDao.getUniversidades().getIdUniversidad();
                String Nombre = txtNombreU.getText();
                String Direccion = txtDireccionU.getText();
                String Telefono = txtTelefono.getText();
                String Correo = txtCorreo.getText();
                Date InicioD = DateFundacion.getDate();
                String Fundacion = Formato.format(InicioD);
                
                Universidad universidadModificada = new Universidad();
                universidadModificada.setIdUniversidad(IdUniversidad);
                universidadModificada.setNombreUniversidad(Nombre);
                universidadModificada.setDireccionUniversidad(Direccion);
                universidadModificada.setNumeroTelefono(Telefono);
                universidadModificada.setCorreoUniversidad(Correo);
                universidadModificada.setFechaFundacion(Fundacion);

                universidadControlDao.Merge(universidadModificada, IdUniversidad - 1);


//                Universidad universidadModificado = new Universidad(IdMateria, Nombre, Direccion, Telefono, Correo, Fundacion);

//                universidadControlDao.Merge(universidadModificado, IdUniversidad - 1);

                CargarTabla();

                Limpiar();
            }
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        int fila = tblUniversidades.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        }
        else {
            universidadControlDao.Eliminar(fila);
            CargarTabla();
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
         try {
            ListaDinamica<Universidad> lista = universidadControlDao.all();

            String Campo = txtBuscar.getText();
            String TipoCampo = cbxTipoBusqueda.getSelectedItem().toString();
            
            switch (TipoCampo) {
                case "Nombre":
                    TipoCampo = "NombreUniversidad";
                    break;
                case "Direccion":
                    TipoCampo = "DireccionUniversidad";
                    break;
                case "Telefono":
                    TipoCampo = "NumeroTelefono";
                    break;
                case "Correo":
                    TipoCampo = "CorreoUniversidad";
                    break;
                case "Fecha de fundacion":
                    TipoCampo = "FechaFundacion";
                    break;
                default:
                    throw new AssertionError();
            }

            ListaDinamica<Universidad> ResultadoBusqueda = UtilesControlador.BusquedaLineal(lista, Campo, TipoCampo);

            mtp.setUniversidadTabla(ResultadoBusqueda);
            mtp.fireTableDataChanged();

        }
        catch (Exception e) {

        }
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblUniversidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUniversidadesMouseClicked
        
        Seleccionar();
        
    }//GEN-LAST:event_tblUniversidadesMouseClicked

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
            java.util.logging.Logger.getLogger(VistaGestionUniversidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGestionUniversidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGestionUniversidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGestionUniversidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaGestionUniversidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateFundacion;
    private javax.swing.JComboBox<String> cbxTipoBusqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JTable tblUniversidades;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccionU;
    private javax.swing.JTextField txtNombreU;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
