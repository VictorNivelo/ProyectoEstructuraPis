
package Vista;

import Controlador.Dao.Modelo.matriculaDao;
import Controlador.TDA.ListaDinamica.Excepcion.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.Utiles.UtilesControlador;
import Modelo.Matricula;
import Vista.ModeloTabla.ModeloTablaMatriculas;
import Vista.Utiles.UtilVista;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author romer
 */
public class VistaGestionMatricula extends javax.swing.JFrame {
    ListaDinamica<Matricula> listaMatricula = new ListaDinamica<>();
    matriculaDao MatriculaControlDao = new matriculaDao();
    ModeloTablaMatriculas mtm = new ModeloTablaMatriculas(); 
    SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
    
    /**
     * Creates new form Matricula
     * @throws Controlador.TDA.ListaDinamica.Excepcion.ListaVacia
     */
    public VistaGestionMatricula() throws ListaVacia {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Vista/RecursosGraficos/IconoPrograma.png")).getImage());
        DateFecha.setDateFormatString("dd/MM/yyyy");
        UtilVista.cargarcomboPeriodo(cbxPeriodo);
        UtilVista.cargarcomboCurso(cbxCursa);
        cbxEstadoMatricula.setEnabled(false);
        CargarTabla();
    }
    
    private void CargarTabla() {
        mtm.setMatriculas(MatriculaControlDao.all());
        tbMatriculas.setModel(mtm);
        tbMatriculas.updateUI();
        cbxCursa.setSelectedIndex(-1);
        cbxPeriodo.setSelectedIndex(-1);
        cbxEstadoMatricula.setSelectedIndex(0);
        DateFecha.setDate(null);
    }
    
    private void Limpiar() throws ListaVacia {
        txtCodigoMatricula.setText("");
        cbxCursa.setSelectedIndex(-1);
        cbxPeriodo.setSelectedIndex(-1);
        cbxEstadoMatricula.setSelectedIndex(-1);
        DateFecha.setDate(null);
        MatriculaControlDao.setMatricula(null);
        CargarTabla();
    }
    
    public Boolean verificar() {
        if (cbxCursa.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Cursa.");
            return false;
        }
        if (cbxPeriodo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un periodo académico.");
            return false;
        }
        return true;
    }
    
    private void Seleccionar(){
        int fila = tbMatriculas.getSelectedRow();
        if(fila < 0){
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        }
        else{
            try {
                MatriculaControlDao.setMatricula(mtm.getMatriculas().getInfo(fila));
                
                txtCodigoMatricula.setText(MatriculaControlDao.getMatricula().getCodigoMatricula());
                Date Fecha = Formato.parse(MatriculaControlDao.getMatricula().getFechaMatricula());
                DateFecha.setDate(Fecha);
                cbxEstadoMatricula.setSelectedItem(MatriculaControlDao.getMatricula().getEstadoMatricula());
                cbxPeriodo.setSelectedIndex(MatriculaControlDao.getMatricula().getPeriodoAcademicoMatricula().getIdPeriodoAcademino() -1);
                cbxCursa.setSelectedIndex(MatriculaControlDao.getMatricula().getCursoMatricula().getIdCurso() -1);
                
            } 
            catch (Exception e) {
                
            }
        }
    }
            
    private void Guardar() throws ListaVacia {

        if (txtCodigoMatricula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar numero dni", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (DateFecha.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Falta llenar nombre", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (cbxEstadoMatricula.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar el estado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (cbxPeriodo.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar el periodo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (cbxCursa.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar el curso", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            //Datos de matricula
            Integer IdMatricula = listaMatricula.getLongitud() + 1;
            String Codigo = txtCodigoMatricula.getText();
            Date f = DateFecha.getDate();
            String FechaMatricula = Formato.format(f);
            String Estado = cbxEstadoMatricula.getSelectedItem().toString();
            
            MatriculaControlDao.getMatricula().setIdMatricula(IdMatricula);
            MatriculaControlDao.getMatricula().setCodigoMatricula(Codigo);
            MatriculaControlDao.getMatricula().setFechaMatricula(FechaMatricula);
            MatriculaControlDao.getMatricula().setEstadoMatricula(Estado);
            MatriculaControlDao.getMatricula().setPeriodoAcademicoMatricula(UtilVista.obtenerPeriodoControl(cbxPeriodo));
            MatriculaControlDao.getMatricula().setCursoMatricula(UtilVista.obtenerCursoControl(cbxCursa));
            
            if (MatriculaControlDao.persist()) {
                JOptionPane.showMessageDialog(null, "MATRICULA GUARDADA EXISTOSAMENTE", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                MatriculaControlDao.setMatricula(null);
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

        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxPeriodo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbxCursa = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMatriculas = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbxTipoBusqueda = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        DateFecha = new com.toedter.calendar.JDateChooser();
        cbxEstadoMatricula = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtCodigoMatricula = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GESTION MATRICULA");

        jPanel4.setBackground(new java.awt.Color(190, 193, 197));

        jLabel8.setFont(new java.awt.Font("Candara Light", 1, 32)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Informacion");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Periodo:");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Curso:");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Estado");

        tbMatriculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbMatriculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMatriculasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMatriculas);

        btnGuardar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
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

        jButton3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton3.setText("REGRESAR");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar por:");

        cbxTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Fecha", "Estado", "Periodo", "Curso" }));
        cbxTipoBusqueda.setSelectedIndex(-1);

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Busqueda:");

        btnBuscar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(61, 90, 134));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 140));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/LojoUNL.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Haettenschweiler", 0, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SERVICIO DE REGISTRO DE MATRICULAS");
        jLabel7.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(279, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Fecha");

        jLabel10.setFont(new java.awt.Font("Candara Light", 1, 32)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Lista de matriculas");

        cbxEstadoMatricula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activa", "Inactiva", "Suspendida" }));
        cbxEstadoMatricula.setSelectedIndex(-1);

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Codigo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnGuardar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCursa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(11, 11, 11)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxPeriodo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxEstadoMatricula, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DateFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCodigoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(DateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxEstadoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbxPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbxCursa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar)
                    .addComponent(btnGuardar)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        try {
            if (txtCodigoMatricula.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar numero dni", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (DateFecha.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Falta llenar nombre", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (cbxEstadoMatricula.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Falta seleccionar el estado", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (cbxPeriodo.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Falta seleccionar el periodo", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (cbxCursa.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Falta seleccionar el curso", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                Guardar();
                cbxEstadoMatricula.setEnabled(false);
            }
        } 
        catch (Exception e) {
            
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        VistaPersonalAdministracion abrirLogin = new VistaPersonalAdministracion();
        abrirLogin.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        try {
            ListaDinamica<Matricula> lista = MatriculaControlDao.all();
            
            String Campo = txtBuscar.getText();
            String TipoCampo = cbxTipoBusqueda.getSelectedItem().toString();
            
            switch (TipoCampo) {
                case "Codigo":
                    TipoCampo = "CodigoMatricula";
                    break;
                case "Fecha":
                    TipoCampo = "FechaMatricula";
                    break;
                case "Estado":
                    TipoCampo = "EstadoMatricula";
                    break;
                case "Periodo":
                    TipoCampo = "matriculaPeriodoAcademico.FechaInicioP";
                    break;
                case "Curso":
                    TipoCampo = "matriculaCursa.Paralelo";
                    break;
                default:
                    throw new AssertionError();
            }

            ListaDinamica<Matricula> ResultadoBusqueda = UtilesControlador.BusquedaLineal(lista, Campo, TipoCampo);
                        
            mtm.setMatriculas(ResultadoBusqueda);
            mtm.fireTableDataChanged();
            
        } 
        catch (Exception e) {
            
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tbMatriculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMatriculasMouseClicked
        
        Seleccionar();
        
    }//GEN-LAST:event_tbMatriculasMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        int fila = tbMatriculas.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        } 
        else {
            if (txtCodigoMatricula.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta llenar numero dni", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (DateFecha.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Falta llenar nombre", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (cbxEstadoMatricula.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Falta seleccionar el estado", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (cbxPeriodo.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Falta seleccionar el periodo", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (cbxCursa.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Falta seleccionar el curso", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else {

                Integer IdMatricula = MatriculaControlDao.getMatricula().getIdMatricula();
                String Codigo = txtCodigoMatricula.getText();
                Date f = DateFecha.getDate();
                String FechaMatricula = Formato.format(f);
                String Estado = cbxEstadoMatricula.getSelectedItem().toString();

                Matricula matriculaModicada = new Matricula();
                matriculaModicada.setIdMatricula(IdMatricula);
                matriculaModicada.setCodigoMatricula(Codigo);
                matriculaModicada.setFechaMatricula(FechaMatricula);
                matriculaModicada.setEstadoMatricula(Estado);
                matriculaModicada.setCursoMatricula(UtilVista.obtenerCursoControl(cbxCursa));
                matriculaModicada.setPeriodoAcademicoMatricula(UtilVista.obtenerPeriodoControl(cbxPeriodo));

                MatriculaControlDao.Merge(matriculaModicada, IdMatricula - 1);

                CargarTabla();
                cbxEstadoMatricula.setEnabled(false);

                try {
                    Limpiar();
                } 
                catch (Exception e) {

                }
            }
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        int fila = tbMatriculas.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        } 
        else {
            MatriculaControlDao.Eliminar(fila);
            CargarTabla();
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(VistaGestionMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGestionMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGestionMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGestionMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new VistaGestionMatricula().setVisible(true);
                } 
                catch (ListaVacia ex) {
                    
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateFecha;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbxCursa;
    private javax.swing.JComboBox<String> cbxEstadoMatricula;
    private javax.swing.JComboBox<String> cbxPeriodo;
    private javax.swing.JComboBox<String> cbxTipoBusqueda;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMatriculas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigoMatricula;
    // End of variables declaration//GEN-END:variables
}
