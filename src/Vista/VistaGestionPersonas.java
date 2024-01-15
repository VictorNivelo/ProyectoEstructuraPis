/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.TDA.ListaDinamica.Exepciones.ListaVacia;
import Controlador.Dao.Modelo.personaDao;
import Controlador.Utiles.UtilesControlador;
import Modelo.Cuenta;
import Modelo.Persona;
import Vista.Utiles.UtilVista;
import Vista.ModeloTabla.ModeloTablaPersona;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class VistaGestionPersonas extends javax.swing.JFrame {
    personaDao personaControlDao = new personaDao();
    ListaDinamica<Persona> listaPersonas = new ListaDinamica<>();
    ModeloTablaPersona mtp = new ModeloTablaPersona();
    SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form VistaRegistroAlumnos
     * @throws Controlador.TDA.ListaDinamica.Exepciones.ListaVacia
     */
    public VistaGestionPersonas() throws ListaVacia {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Vista/RecursosGraficos/IconoPrograma.png")).getImage());
        UtilVista.cargarcomboRoles(cbxRol);
        DateFechaNacimiento.setDateFormatString("dd/MM/yyyy");
        CargarTabla();
    }
    
    private void CargarTabla() {
        mtp.setPersonasTabla(personaControlDao.getListaPersonas());
        tblPersonas.setModel(mtp);
        tblPersonas.updateUI();
        cbxGenero.setSelectedIndex(-1);
        cbxRol.setSelectedIndex(-1);
        cbxTipoBusqueda.setSelectedIndex(-1);
        cbxEstadoCuenta.setSelectedIndex(0);
    }
    
    private void Limpiar() throws ListaVacia {
        txtNumeroCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        cbxGenero.setSelectedIndex(-1);
        DateFechaNacimiento.setDate(null);
        txtDireccion.setText("");
        txtTelefono.setText("");
        cbxRol.setSelectedIndex(-1);
        cbxEstadoCuenta.setSelectedIndex(0);
        txtUsuario.setText("");
        txtContrasena.setText("");
        personaControlDao.setPersona(null);
        CargarTabla();
    }
    
    private void Seleccionar(){
        int fila = tblPersonas.getSelectedRow();
        if(fila < 0){
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        }
        else{
            try {
                personaControlDao.setPersona(mtp.getPersonasTabla().getInfo(fila));
                
                txtNumeroCedula.setText(personaControlDao.getPersona().getNumeroCedula());
                txtNombre.setText(personaControlDao.getPersona().getNombre());
                txtApellido.setText(personaControlDao.getPersona().getApellido());
                cbxGenero.setSelectedItem(personaControlDao.getPersona().getGenero());
                Date FechaNacimiento = Formato.parse(personaControlDao.getPersona().getFechaNacimineto());
                DateFechaNacimiento.setDate(FechaNacimiento);
                txtDireccion.setText(personaControlDao.getPersona().getDireccion());
                txtTelefono.setText(personaControlDao.getPersona().getTelefono());
                cbxRol.setSelectedIndex(personaControlDao.getPersona().getRolPersona().getIdRol()-1);
                txtUsuario.setText(personaControlDao.getPersona().getCuentaPersona().getCorreo());
                txtContrasena.setText(personaControlDao.getPersona().getCuentaPersona().getContrasena());
                cbxEstadoCuenta.setSelectedItem(personaControlDao.getPersona().getCuentaPersona().getEstadoCuenta());
                
                cbxEstadoCuenta.setEnabled(true);
            } 
            catch (Exception e) {
                
            }
        }
    }
    
    private void Guardar() throws ListaVacia {

        if (txtNumeroCedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar numero dni", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar nombre", "Error", JOptionPane.INFORMATION_MESSAGE);
        } 
        else if (txtApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar apellido", "Error", JOptionPane.INFORMATION_MESSAGE);
        } 
        else if (cbxGenero.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar genero", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (DateFechaNacimiento.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Falta llenar fecha nacimiento", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (txtDireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar direccion", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar numero celular", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (cbxRol.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar rol", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (txtUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar usuario", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (txtContrasena.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar contraseña", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (cbxEstadoCuenta.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar estado de cuenta", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            //Datos de persona a registrar
            Integer IdPersona = listaPersonas.getLongitud() + 1;
            String NumeroCedula = txtNumeroCedula.getText();
            String Nombre = txtNombre.getText();
            String Apellido = txtApellido.getText();
            String Genero = cbxGenero.getSelectedItem().toString();
            Date obtenerFecha = DateFechaNacimiento.getDate();
            String FechaNacimiento = Formato.format(obtenerFecha);
            String Direccion = txtDireccion.getText();
            String Telefono = txtTelefono.getText();
            //Datos de cuenta
            String Usuario = txtUsuario.getText();
            String Contrasena = txtContrasena.getText();
            String EstadoCuenta = cbxEstadoCuenta.getSelectedItem().toString();
            
//            Rol rolPersona = new Rol(IdPersona, rolPe, rolPe);
            
            Cuenta cuenta = new Cuenta(IdPersona, Usuario, Contrasena, EstadoCuenta);
            
//            Persona datosPersona = new Persona(IdPersona, NumeroCedula, Nombre, Apellido, Genero, FechaNacimiento, Direccion, Telefono, rolPersona, cuenta);
            
            personaControlDao.getPersona().setIdPersona(IdPersona);
            personaControlDao.getPersona().setNumeroCedula(NumeroCedula);
            personaControlDao.getPersona().setNombre(Nombre);
            personaControlDao.getPersona().setApellido(Apellido);
            personaControlDao.getPersona().setGenero(Genero);
            personaControlDao.getPersona().setFechaNacimineto(FechaNacimiento);
            personaControlDao.getPersona().setDireccion(Direccion);
            personaControlDao.getPersona().setTelefono(Telefono);
            
            personaControlDao.getPersona().setRolPersona(UtilVista.obtenerRolControl(cbxRol));
            
            personaControlDao.getPersona().setCuentaPersona(cuenta);
            
            if (personaControlDao.Persist()) {
                JOptionPane.showMessageDialog(null, "PERSONA GUARDADA EXISTOSAMENTE", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
//                System.out.println(""+personaControlDao.Persist().toString());
                personaControlDao.setPersona(null);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnGuardarPersona = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbxTipoBusqueda = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtNumeroCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        cbxGenero = new javax.swing.JComboBox<>();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        cbxRol = new javax.swing.JComboBox<>();
        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        cbxEstadoCuenta = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        DateFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GESTION DE PERSONAS");

        jPanel1.setBackground(new java.awt.Color(190, 193, 197));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Numero");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Apellido");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Genero");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Fecha nacimiento");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Direccion");
        jLabel8.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Telefono");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Rol asignado");

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Usuario");

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Contraseña");

        jLabel14.setFont(new java.awt.Font("Candara Light", 1, 32)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Rol");

        jLabel15.setFont(new java.awt.Font("Candara Light", 1, 32)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Credenciales");

        jPanel2.setBackground(new java.awt.Color(61, 90, 134));

        jLabel2.setFont(new java.awt.Font("Haettenschweiler", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SERVICIO DE REGISTRO DE PERSONAS");
        jLabel2.setToolTipText("");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/LojoUNL.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tblPersonas.setForeground(new java.awt.Color(0, 0, 0));
        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPersonas.setOpaque(false);
        tblPersonas.setSelectionBackground(new java.awt.Color(200, 222, 180));
        tblPersonas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPersonasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPersonas);

        jLabel17.setFont(new java.awt.Font("Candara Light", 1, 32)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Datos de personas");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnModificar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnEliminar.setText("ELIMNAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnRegistrar.setText("REGRESAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnGuardarPersona.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnGuardarPersona.setText("GUARDAR");
        btnGuardarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPersonaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar por");

        cbxTipoBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        cbxTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rol", "Numero cedula", "Nombre", "Apellido", "Genero", "Direccion", "Telefono", "Correo", "Estado de cuenta" }));
        cbxTipoBusqueda.setSelectedIndex(-1);

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Busqueda");

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Estado de cuenta");

        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "No definido" }));
        cbxGenero.setSelectedIndex(-1);

        cbxEstadoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activa", "No funcional", "Suspendida" }));
        cbxEstadoCuenta.setSelectedIndex(-1);
        cbxEstadoCuenta.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Candara Light", 1, 32)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Lista de personas");

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Tipo iDNI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRegistrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                                .addComponent(btnGuardarPersona))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxEstadoCuenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtContrasena))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUsuario))
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxRol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DateFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtApellido)
                                    .addComponent(cbxGenero, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNumeroCedula)
                                    .addComponent(txtNombre)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDireccion)
                                    .addComponent(txtTelefono))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBuscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18)
                                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel20)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(txtNumeroCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel6)
                                                    .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel7))
                                            .addComponent(DateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10)
                                            .addComponent(cbxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel11)
                                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel19)
                                            .addComponent(cbxEstadoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnRegistrar)
                                    .addComponent(btnGuardarPersona)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar)
                            .addComponent(btnModificar))))
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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int fila = tblPersonas.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        } 
        else {
            personaControlDao.Eliminar(fila);
            CargarTabla();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int fila = tblPersonas.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        } 
        else {
            if (txtNumeroCedula.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar numero dni", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar nombre", "Error", JOptionPane.INFORMATION_MESSAGE);
            } 
            else if (txtApellido.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar apellido", "Error", JOptionPane.INFORMATION_MESSAGE);
            } 
            else if (cbxGenero.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Falta seleccionar genero", "Error", JOptionPane.INFORMATION_MESSAGE);
            } 
            else if (DateFechaNacimiento.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Falta llenar fecha nacimiento", "Error", JOptionPane.INFORMATION_MESSAGE);
            } 
            else if (txtDireccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar direccion", "Error", JOptionPane.INFORMATION_MESSAGE);
            } 
            else if (txtTelefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar numero celular", "Error", JOptionPane.INFORMATION_MESSAGE);
            } 
            else if (cbxRol.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Falta seleccionar rol", "Error", JOptionPane.INFORMATION_MESSAGE);
            } 
            else if (txtUsuario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar usuario", "Error", JOptionPane.INFORMATION_MESSAGE);
            } 
            else if (txtContrasena.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar contraseña", "Error", JOptionPane.INFORMATION_MESSAGE);
            } 
            else if (cbxEstadoCuenta.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Falta seleccionar estado de cuenta", "Error", JOptionPane.INFORMATION_MESSAGE);
            } 
            else {

                Integer IdPersona = personaControlDao.getPersona().getIdPersona();
                String NumeroCedula = txtNumeroCedula.getText();
                String Nombre = txtNombre.getText();
                String Apellido = txtApellido.getText();
                String Genero = cbxGenero.getSelectedItem().toString();
                Date formattedDate = DateFechaNacimiento.getDate();
                String FechaNacimiento = Formato.format(formattedDate);
                String Direccion = txtDireccion.getText();
                String Telefono = txtTelefono.getText();
                //Datos de cuenta
                Integer idCuenta = personaControlDao.getPersona().getCuentaPersona().getIdCuenta();
                String Usuario = txtUsuario.getText();
                String Contrasena = txtContrasena.getText();

                String EstadoCuenta = cbxEstadoCuenta.getSelectedItem().toString();

                Cuenta cuenta = new Cuenta(idCuenta, Usuario, Contrasena, EstadoCuenta);

                Persona personaModiPersona = new Persona(IdPersona, NumeroCedula, Nombre, Apellido, Genero, FechaNacimiento, Direccion, Telefono, UtilVista.obtenerRolControl(cbxRol), cuenta);
                
                personaControlDao.Merge(personaModiPersona, IdPersona-1);

                CargarTabla();

                try {
                    Limpiar();
                } 
                catch (Exception e) {

                }
            }
        }
        
//            JOptionPane.showMessageDialog(null, "No se puede modificar");

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        VistaPersonalAdministracion abrirLogin = new VistaPersonalAdministracion();
        abrirLogin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnGuardarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPersonaActionPerformed
        // TODO add your handling code here:
        if (txtNumeroCedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar numero dni", "Error", JOptionPane.INFORMATION_MESSAGE);
        } 
        else if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar nombre", "Error", JOptionPane.INFORMATION_MESSAGE);
        } 
        else if (txtApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar apellido", "Error", JOptionPane.INFORMATION_MESSAGE);
        } 
        else if (cbxGenero.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar genero", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (DateFechaNacimiento.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Falta llenar fecha nacimiento", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (txtDireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar direccion", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar numero celular", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (cbxRol.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar rol", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (txtUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar usuario", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (txtContrasena.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar contraseña", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (cbxEstadoCuenta.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar estado de cuenta", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            try {
                Guardar();
            } 
            catch (ListaVacia ex) {

            }
        }
    }//GEN-LAST:event_btnGuardarPersonaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            ListaDinamica<Persona> lista = personaControlDao.all();
            
            String Campo = txtBuscar.getText();
            String TipoCampo = cbxTipoBusqueda.getSelectedItem().toString();
            
            switch (TipoCampo) {
                case "Numero cedula":
                    TipoCampo = "NumeroCedula";
                    break;
                case "Nombre":
                    TipoCampo = "Nombre";
                    break;
                case "Apellido":
                    TipoCampo = "Apellido";
                    break;
                case "Genero":
                    TipoCampo = "Genero";
                    break;
                case "Telefono":
                    TipoCampo = "Telefono";
                    break;
                case "Direccion":
                    TipoCampo = "direccion";
                    break;
                case "Rol":
                    TipoCampo = "rolPersona.nombreRol";
                    break;
                case "Estado de cuenta":
                    TipoCampo = "cuentaPersona.EstadoCuenta";
                    break;
                case "Correo":
                    TipoCampo = "cuentaPersona.Correo";
                    break;
                default:
                    throw new AssertionError();
            }
            
            ListaDinamica<Persona> ResultadoBusqueda = UtilesControlador.BusquedaLineal(lista, Campo, TipoCampo);
                        
            mtp.setPersonasTabla(ResultadoBusqueda);
            mtp.fireTableDataChanged();
            
        } 
        catch (Exception e) {
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonasMouseClicked
        // TODO add your handling code here:
        Seleccionar();
    }//GEN-LAST:event_tblPersonasMouseClicked

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
            java.util.logging.Logger.getLogger(VistaGestionPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGestionPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGestionPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGestionPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
            @Override
            public void run() {
                try {
                    new VistaGestionPersonas().setVisible(true);
                } 
                catch (ListaVacia ex) {

                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateFechaNacimiento;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarPersona;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbxEstadoCuenta;
    private javax.swing.JComboBox<String> cbxGenero;
    private javax.swing.JComboBox<String> cbxRol;
    private javax.swing.JComboBox<String> cbxTipoBusqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JTable tblPersonas;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroCedula;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
