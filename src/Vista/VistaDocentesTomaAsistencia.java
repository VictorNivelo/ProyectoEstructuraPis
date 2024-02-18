package Vista;

import Controlador.Dao.Modelo.alumnoDao;
import Controlador.Dao.Modelo.asistenciaDao;
import Controlador.Dao.Modelo.materiaDao;
import Controlador.TDA.ListaDinamica.Excepcion.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.Utiles.UtilesControlador;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import Modelo.Matricula;
import Modelo.Alumno;
import Modelo.Asistencia;
import Modelo.ControlAccesoDocente;
import Modelo.Cursa;
import Modelo.Materia;
import Modelo.Persona;
import Vista.Utiles.UtilVista;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class VistaDocentesTomaAsistencia extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    alumnoDao alumnoControlDao = new alumnoDao();
    materiaDao materiaControlDao = new materiaDao();
    asistenciaDao asistenciaControlDao = new asistenciaDao();
    ListaDinamica<Asistencia> listaAsistencia = new ListaDinamica<>();

    /**
     * Creates new form VistaTomaAsistencia
     *
     * @throws Controlador.TDA.ListaDinamica.Excepcion.ListaVacia
     */
    public VistaDocentesTomaAsistencia() throws ListaVacia {
        initComponents();
        this.setLocationRelativeTo(null);
        UtilVista.cargarcomboHorario(cbxHorario);
        setIconImage(new ImageIcon(getClass().getResource("/Vista/RecursosGraficos/IconoPrograma.png")).getImage());
        DateFechaActual.setDateFormatString("dd/MMMM/yyyy");
        dtm.setColumnIdentifiers(new String[]{"#", "Nombre", "Apellido", "Asistencia"});
        CargarTabla();
        tblt.setModel(dtm);
        AgregarCheckbox(3, tblt);
        cbxHorario.setSelectedIndex(-1);
        cargarMateriasDocente();
        cbxMateria.setSelectedIndex(-1);
    }

    private void cargarMateriasDocente() {
        int idDocenteLogeado = ControlAccesoDocente.getIdDocenteLogeado();
        cbxMateria.removeAllItems();
        ListaDinamica<Materia> listaMaterias = materiaControlDao.all();
        for (Materia materia : listaMaterias.toArray()) {
            int idDocenteMateria = materia.getCursoMateria().getDocenteCursa().getIdDocente();

            if (idDocenteLogeado == idDocenteMateria) {
                cbxMateria.addItem(materia.getNombreMateria());
            }
        }
    }

    private void CargarTabla() {
        try {
            Object[] datosLista = alumnoControlDao.getListaAlumnos().toArray();
            for (Object dato : datosLista) {
                if (dato instanceof Persona) {
                    Persona persona = (Persona) dato;
                    dtm.addRow(new Object[]{persona.getIdPersona(), persona.getNombre(), persona.getApellido(), false});
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void CargarTablas() {
        try {
            ListaDinamica<Materia> listaMaterias = materiaControlDao.all();
            dtm.setRowCount(0);
            
            for (Materia materia : listaMaterias.toArray()) {
                Cursa cursoMateria = materia.getCursoMateria();
                Matricula matricula = cursoMateria.getMatriculaCursa();
                
                if (matricula.getEstadoMatricula().equals("Activa")) {
                    Alumno alumno = matricula.getAlumnoMatricula();

                    Persona datosAlumno = alumno.getDatosAlumno();
                    dtm.addRow(new Object[]{
                        alumno.getIdAlumno(),
                        datosAlumno.getNombre(),
                        datosAlumno.getApellido()
                    });
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }    
    
    public void AgregarCheckbox(int columna, JTable tabla) {
        TableColumn columnaTabla = tabla.getColumnModel().getColumn(columna);
        columnaTabla.setCellEditor(tabla.getDefaultEditor(Boolean.class));
        columnaTabla.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
    }

    public boolean estaSeleccionada(int fila, int columna, JTable tabla) {
        return tabla.getValueAt(fila, columna) != null;
    }
    
    private void Limpiar() throws ListaVacia {
        DateFechaActual.setDate(null);
        cbxMateria.setSelectedIndex(-1);
        cbxHorario.setSelectedIndex(-1);
        txtTematica.setText("");
        txtObservacion.setText("");
        asistenciaControlDao.setAsistencias(null);
        CargarTabla();
    }
    
    private void Guardar() throws ListaVacia {

        if (DateFechaActual.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar la fecha", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else if (cbxMateria.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar la materia", "Error", JOptionPane.WARNING_MESSAGE);
        }
//        else if (cbxHorario.getSelectedIndex() == -1) {
//            JOptionPane.showMessageDialog(null, "Falta seleccionar el horario", "Error", JOptionPane.WARNING_MESSAGE);
//        } 
        else if (txtTematica.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar duracion", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else if (txtObservacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar duracion", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else {
            
            for (int i = 0; i < tblt.getRowCount(); i++) {
            boolean estaPresente = (boolean) tblt.getValueAt(i, 3);
            String estadoAsistencia = estaPresente ? "Presente" : "Ausente";

            Integer idAsistencia = listaAsistencia.getLongitud() + 1;

            Asistencia nuevaAsistencia = new Asistencia();
            nuevaAsistencia.setIdAsistencia(idAsistencia);
            nuevaAsistencia.setEstadoAsistencia(estadoAsistencia);
            nuevaAsistencia.setObservacion(txtObservacion.getText());
            nuevaAsistencia.setHorarioAsistencia(UtilVista.obtenerHorarioControl(cbxHorario));

            asistenciaControlDao.setAsistencias(nuevaAsistencia);
            try {
                if (asistenciaControlDao.Persist()) {
                    JOptionPane.showMessageDialog(null, "Asistencia guardada exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                    asistenciaControlDao.setAsistencias(null);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar la asistencia", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblt = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cbxTipoBusqueda = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTematica = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        DateFechaActual = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        cbxHorario = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtObservacion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbxMateria = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        btnOrdenar = new javax.swing.JButton();
        cbxOrden = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbxTipoOrden = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REGISTRO DE ASISTENCIA");

        jPanel1.setBackground(new java.awt.Color(190, 193, 197));

        jPanel2.setBackground(new java.awt.Color(61, 90, 134));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/LojoUNL.png"))); // NOI18N

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Haettenschweiler", 0, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SERVICIO DE TOMA DE ASISTENCIA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Candara Light", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Curso");

        jLabel4.setFont(new java.awt.Font("Candara Light", 1, 32)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Lista de alumnos");

        tblt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblt.setSelectionBackground(new java.awt.Color(200, 222, 180));
        tblt.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tblt);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Buscar por");

        cbxTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Apellido" }));
        cbxTipoBusqueda.setSelectedIndex(-1);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Busqueda");

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/Botones/Buscar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/Botones/Modificar.png"))); // NOI18N
        jButton2.setText("MODIFICAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/Botones/Eliminar.png"))); // NOI18N
        jButton3.setText("ELIMINAR");

        jButton4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/Botones/Regresar.png"))); // NOI18N
        jButton4.setText("REGRESAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/Botones/Seleccionar.png"))); // NOI18N
        jButton5.setText("SELECCIONAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tematica");

        txtTematica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTematicaKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Fecha");

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Horario");

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Observacion");

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Materia");

        jButton6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/Botones/Guardar.png"))); // NOI18N
        jButton6.setText("GUARDAR ASISTENCIA");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnOrdenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/RecursosGraficos/Botones/Ordenar.png"))); // NOI18N
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });

        cbxOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Asendente", "Desendente" }));
        cbxOrden.setSelectedIndex(-1);

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Ordenar");

        cbxTipoOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Apellido" }));
        cbxTipoOrden.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addComponent(txtTematica)
                    .addComponent(txtObservacion)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxHorario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxMateria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DateFechaActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxTipoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOrdenar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxTipoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addComponent(btnOrdenar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DateFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cbxMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTematica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            ListaDinamica<Alumno> lista = alumnoControlDao.all();

            String Campo = txtBuscar.getText();
            String TipoCampo = cbxTipoBusqueda.getSelectedItem().toString();

            switch (TipoCampo) {
                case "Nombre":
                    TipoCampo = "Nombre";
                    break;
                case "Apellido":
                    TipoCampo = "Apellido";
                    break;
                default:
                    throw new AssertionError();
            }

            ListaDinamica<Alumno> ResultadoBusqueda = UtilesControlador.BusquedaLineal(lista, Campo, TipoCampo);
            
            Object[][] datos = new Object[ResultadoBusqueda.getLongitud()][3];
            
            for (int i = 0; i < ResultadoBusqueda.getLongitud(); i++) {
                Alumno p = ResultadoBusqueda.getInfo(i);
                datos[i] = new Object[]{
                    p.getIdAlumno(),
                    p.getDatosAlumno().getNombre(),
                    p.getDatosAlumno().getApellido(),

                };
            }

            Object[] columnas = {"#", "Nombre", "Apellido", "Asistencia"};

            DefaultTableModel modeloTabla = new DefaultTableModel(datos, columnas);
            
            tblt.setModel(modeloTabla);
            AgregarCheckbox(3, tblt);
//                        AgregarCheckbox(3, tblt);
//            dtm.setPersonasTabla(ResultadoBusqueda);
//            mtp.fireTableDataChanged();

        }
        catch (Exception e) {

        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        VistaDocentes abrirLogin = new VistaDocentes();
        abrirLogin.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        CargarTablas();
            
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtTematicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTematicaKeyTyped
        
        char c = evt.getKeyChar();

        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingreso de letras", "CARACTER NO VALIDO", JOptionPane.WARNING_MESSAGE);
        }
        if (c != KeyEvent.VK_BACK_SPACE) {

        }
        
    }//GEN-LAST:event_txtTematicaKeyTyped

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed

        try {
            if (cbxTipoOrden.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado el campo", "FALTA SELCCIONAR", JOptionPane.WARNING_MESSAGE);
            } 
            else if (cbxOrden.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado el orden", "FALTA SELCCIONAR", JOptionPane.WARNING_MESSAGE);
            } 
            else {

                ListaDinamica<Alumno> lista = alumnoControlDao.all();

                String Campo = txtBuscar.getText();
                String TipoCampo = cbxTipoBusqueda.getSelectedItem().toString();

                switch (TipoCampo) {
                    case "Nombre":
                        TipoCampo = "Nombre";
                        break;
                    case "Apellido":
                        TipoCampo = "Apellido";
                        break;
                    default:
                        throw new AssertionError();
                }

                ListaDinamica<Alumno> ResultadoBusqueda = UtilesControlador.BusquedaLineal(lista, Campo, TipoCampo);

                Object[][] datos = new Object[ResultadoBusqueda.getLongitud()][4];

                for (int i = 0; i < ResultadoBusqueda.getLongitud(); i++) {
                    Alumno p = ResultadoBusqueda.getInfo(i);
                    datos[i] = new Object[]{
                        p.getIdAlumno(),
                        p.getDatosAlumno().getNombre(),
                        p.getDatosAlumno().getApellido(),
                        false
                    };
                }

                Object[] columnas = {"#", "Nombre", "Apellido", "Asistencia"};

                DefaultTableModel modeloTabla = new DefaultTableModel(datos, columnas);

                tblt.setModel(modeloTabla);
                AgregarCheckbox(3, tblt);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        try {
            Guardar();
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaDocentesTomaAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaDocentesTomaAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaDocentesTomaAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaDocentesTomaAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VistaDocentesTomaAsistencia().setVisible(true);
                } 
                catch (ListaVacia ex) {
                    
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateFechaActual;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JComboBox<String> cbxHorario;
    private javax.swing.JComboBox<String> cbxMateria;
    private javax.swing.JComboBox<String> cbxOrden;
    private javax.swing.JComboBox<String> cbxTipoBusqueda;
    private javax.swing.JComboBox<String> cbxTipoOrden;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblt;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtObservacion;
    private javax.swing.JTextField txtTematica;
    // End of variables declaration//GEN-END:variables
}
