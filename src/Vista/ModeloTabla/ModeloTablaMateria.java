
package Vista.ModeloTabla;

import Controlador.TDA.ListaDinamica.Excepcion.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Materia;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaMateria extends AbstractTableModel {

    private ListaDinamica<Materia> materiaTabla;

    public ListaDinamica<Materia> getMateriaTabla() {
        return materiaTabla;
    }

    public void setMateriaTabla(ListaDinamica<Materia> materiaTabla) {
        this.materiaTabla = materiaTabla;
    }
    
    @Override
    public int getRowCount() {
        return materiaTabla.getLongitud();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }
    
    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            Materia c = materiaTabla.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (c != null) ? c.getIdMateria(): "";
                case 1:
                    return (c != null) ? c.getNombreMateria() : "";
                case 2:
                    return (c != null) ? c.getDescipcionMateria() : "";
                case 3:
                    return (c != null) ? c.getNumeroHoras(): "";    
                case 4:
                    return (c != null) ? c.getCicloMateria().getNombreCiclo(): "";
                case 5:
                    return (c != null) ? c.getCursoMateria().getParalelo(): "";
                case 6:
                    return (c != null) ? c.getDocenteMateria().getDatosDocente().getNombre() + " " + c.getDocenteMateria().getDatosDocente().getApellido(): "";
                case 7:
                    return (c != null) ? c.getDocenteMateria().getDatosDocente().getNumeroCedula() : "";
                case 8:
                    return (c != null) ? c.getCursoMateria().getMatriculaCursa().getAlumnoMatricula().getDatosAlumno().getNumeroCedula() : "";
                case 9:
                    return (c != null) ? c.getCursoMateria().getMatriculaCursa().getCodigoMatricula(): "";
                default:
                    return null;
            }
        } 
        catch (ListaVacia | IndexOutOfBoundsException ex) {
            
        }
        return materiaTabla;
    }


    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "#";
            case 1:
                return "Nombre materia";
            case 2:
                return "Descripcion materia";
            case 3:
                return "Nro de horas";
            case 4:
                return "Ciclo";
            case 5:
                return "Paralelo";
            case 6:
                return "Nombre docente";
            case 7:
                return "DNI docente";
            case 8:
                return "Alumno";
            case 9:
                return "Codigo Matricula";
            default:
                return null;
        }
    }
    
}
