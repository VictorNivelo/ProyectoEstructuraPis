
package Vista.Utiles;

import Controlador.Dao.Modelo.asistenciaDao;
import Controlador.Dao.Modelo.carreraDao;
import Modelo.Ciclo;
import Controlador.Dao.Modelo.cicloDao;
import Controlador.Dao.Modelo.cursoDao;
import Controlador.Dao.Modelo.horarioDao;
import Controlador.Dao.Modelo.mallaCurricularDao;
import Controlador.Dao.Modelo.materiaDao;
import Controlador.Dao.Modelo.matriculaDao;
import Controlador.Dao.Modelo.periodoAcademicoDao;
import Controlador.Dao.Modelo.personaDao;
import Controlador.Dao.Modelo.rolDao;
import Controlador.TDA.ListaDinamica.Exepciones.ListaVacia;
import Modelo.Asistencia;
import Modelo.Carrera;
import Modelo.Cursa;
import Modelo.Horario;
import Modelo.MallaCurricular;
import Modelo.Materia;
import Modelo.Matricula;
import Modelo.PeriodoAcademico;
import Modelo.Persona;
import Modelo.Rol;
import javax.swing.JComboBox;

/**
 *
 * @author Victor
 */
public class UtilVista {
    
    public static void cargarcomboRoles(JComboBox cbx) throws ListaVacia{
        rolDao rc = new rolDao();
        cbx.removeAllItems();
        
        if(rc.getListaRol().EstaVacio()){
            throw new ListaVacia("No hay roles que mostrar");
        }
        else{
           for (int i = 0; i < rc.getListaRol().getLongitud(); i++) {
            cbx.addItem(rc.getListaRol().getInfo(i));
           }
        }
    }
    
    public static Rol obtenerRolControl(JComboBox cbx){
        return (Rol) cbx.getSelectedItem();
    }
    
    public static void CargarComboMateria(JComboBox cbx) throws ListaVacia{
        materiaDao mc = new materiaDao();
        cbx.removeAllItems();
        
        if(mc.getListaMateria().EstaVacio()){
            throw new ListaVacia("No hay materias que mostrar");
        }
        else{
           for (int i = 0; i < mc.getListaMateria().getLongitud(); i++) {
            cbx.addItem(mc.getListaMateria().getInfo(i));
           }
        }
    }
    
    public static Materia obtenerComboMateria(JComboBox cbx){
        return (Materia) cbx.getSelectedItem();
    }
    
    public static void cargarComboCiclo(JComboBox cbxC) throws ListaVacia{
        cicloDao rc = new cicloDao();
        cbxC.removeAllItems();

        
        if(rc.getListaCiclos().EstaVacio()){
            throw new ListaVacia("No hay ciclos que mostrar");
        }
        else{
           for (int i = 0; i < rc.getListaCiclos().getLongitud(); i++) {
            cbxC.addItem(rc.getListaCiclos().getInfo(i));
            
           }
        }
    }
    
    public static Ciclo obtenerCicloControl(JComboBox cbx){
        return (Ciclo) cbx.getSelectedItem();
    }
    
    public static void cargarcomboCarrera(JComboBox cbx) throws ListaVacia{
        carreraDao rc = new carreraDao();
        cbx.removeAllItems();
        
        if(rc.getListaCarreras().EstaVacio()){
            throw new ListaVacia("No hay carreras que mostrar");
        }
        else{
           for (int i = 0; i < rc.getListaCarreras().getLongitud(); i++) {
            cbx.addItem(rc.getListaCarreras().getInfo(i));
           }
        }
    }
    
    public static Carrera obtenerCarreraControl(JComboBox cbx){
        return (Carrera) cbx.getSelectedItem();
    }
    
    public static void cargarcomboMalla(JComboBox cbx) throws ListaVacia{
        mallaCurricularDao rc = new mallaCurricularDao();
        cbx.removeAllItems();
        
        if(rc.getListaMalla().EstaVacio()){
            throw new ListaVacia("No hay malla que mostrar");
        }
        else{
           for (int i = 0; i < rc.getListaMalla().getLongitud(); i++) {
            cbx.addItem(rc.getListaMalla().getInfo(i));
           }
        }
    }
    
    public static MallaCurricular obtenerMallaControl(JComboBox cbx){
        return (MallaCurricular) cbx.getSelectedItem();
    }
    
    public static void cargarcomboHorario(JComboBox cbx) throws ListaVacia{
        horarioDao rc = new horarioDao();
        cbx.removeAllItems();
        
        if(rc.getListaHorario().EstaVacio()){
            throw new ListaVacia("No hay horarios que mostrar");
        }
        else{
           for (int i = 0; i < rc.getListaHorario().getLongitud(); i++) {
            cbx.addItem(rc.getListaHorario().getInfo(i));
           }
        }
    }
    
    public static Horario obtenerHorarioControl(JComboBox cbx){
        return (Horario) cbx.getSelectedItem();
    }
    
    public static void cargarcomboPeriodo(JComboBox cbx) throws ListaVacia{
        periodoAcademicoDao rc = new periodoAcademicoDao();
        cbx.removeAllItems();
        
        if(rc.getListaPeriodos().EstaVacio()){
            throw new ListaVacia("No hay periodos que mostrar");
        }
        else{
           for (int i = 0; i < rc.getListaPeriodos().getLongitud(); i++) {
            cbx.addItem(rc.getListaPeriodos().getInfo(i));
           }
        }
    }
    
    public static PeriodoAcademico obtenerPeriodoControl(JComboBox cbx){
        return (PeriodoAcademico) cbx.getSelectedItem();
    }
        
    public static void cargarcomboCurso(JComboBox cbx) throws ListaVacia{
        cursoDao rc = new cursoDao();
        cbx.removeAllItems();
        
        if(rc.getListaCursa().EstaVacio()){
            throw new ListaVacia("No hay cursos que mostrar");
        }
        else{
           for (int i = 0; i < rc.getListaCursa().getLongitud(); i++) {
            cbx.addItem(rc.getListaCursa().getInfo(i));
           }
        }
    }
    
    public static Cursa obtenerCursoControl(JComboBox cbx){
        return (Cursa) cbx.getSelectedItem();
    }
    
    public static void cargarcomboPersona(JComboBox cbx) throws ListaVacia {
        personaDao rc = new personaDao();
        cbx.removeAllItems();

        if (rc.getListaPersonas().EstaVacio()) {
            throw new ListaVacia("No hay personas que mostrar");
        } 
        else {
            for (int i = 0; i < rc.getListaPersonas().getLongitud(); i++) {
                cbx.addItem(rc.getListaPersonas().getInfo(i));
            }
        }
    }
    
    public static Persona obtenerPersonaControl(JComboBox cbx){
        return (Persona) cbx.getSelectedItem();
    }
    
    public static void cargarcomboAsistencia(JComboBox cbx) throws ListaVacia{
        asistenciaDao rc = new asistenciaDao();
        cbx.removeAllItems();
        
        if(rc.getListaAsistencia().EstaVacio()){
            throw new ListaVacia("No hay asistencias que mostrar");
        }
        else{
           for (int i = 0; i < rc.getListaAsistencia().getLongitud(); i++) {
            cbx.addItem(rc.getListaAsistencia().getInfo(i));
           }
        }
    }
    
    public static Asistencia obtenerAsistenciaControl(JComboBox cbx){
        return (Asistencia) cbx.getSelectedItem();
    }
    
    public static void cargarcomboMatricula(JComboBox cbx) throws ListaVacia{
        matriculaDao rc = new matriculaDao();
        cbx.removeAllItems();
        
        if(rc.getListaMatriculas().EstaVacio()){
            throw new ListaVacia("No hay asistencias que mostrar");
        }
        else{
           for (int i = 0; i < rc.getListaMatriculas().getLongitud(); i++) {
            cbx.addItem(rc.getListaMatriculas().getInfo(i));
           }
        }
    }
    
    public static Matricula obtenerMatriculaControl(JComboBox cbx){
        return (Matricula) cbx.getSelectedItem();
    }
    
    //cargar combos especificos por rol
    public static void cargarcomboAlumnos(JComboBox cbx) throws ListaVacia {
        personaDao rc = new personaDao();
        cbx.removeAllItems();

        if (rc.getListaPersonas().EstaVacio()) {
            throw new ListaVacia("No hay alumnos que mostrar");
        } 
        else {
            for (int i = 0; i < rc.getListaPersonas().getLongitud(); i++) {
                Persona persona = rc.getListaPersonas().getInfo(i);

                if (persona.getRolPersona() != null && persona.getRolPersona().getNombreRol().equalsIgnoreCase("Estudiante")) {
                    cbx.addItem(persona);
                }
            }
        }
    }

    public static Persona obtenerAlumnosControl(JComboBox cbx) {
        return (Persona) cbx.getSelectedItem();
    }
    
    public static void cargarcomboDocentes(JComboBox cbx) throws ListaVacia {
        personaDao rc = new personaDao();
        cbx.removeAllItems();

        if (rc.getListaPersonas().EstaVacio()) {
            throw new ListaVacia("No hay docentes que mostrar");
        } 
        else {
            for (int i = 0; i < rc.getListaPersonas().getLongitud(); i++) {
                Persona persona = rc.getListaPersonas().getInfo(i);

                if (persona.getRolPersona() != null && persona.getRolPersona().getNombreRol().equalsIgnoreCase("Docente")) {
                    cbx.addItem(persona);
                }
            }
        }
    }

    public static Persona obtenerDocentesControl(JComboBox cbx) {
        return (Persona) cbx.getSelectedItem();
    }
}
