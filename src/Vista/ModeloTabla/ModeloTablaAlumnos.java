
package Vista.ModeloTabla;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Alumno;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author romer
 */
public class ModeloTablaAlumnos extends AbstractTableModel {
    ListaDinamica<Alumno> alumnosTabla;

    public ListaDinamica<Alumno> getAlumnosTabla() {
        return alumnosTabla;
    }

    public void setAlumnosTabla(ListaDinamica<Alumno> alumnosTabla) {
        this.alumnosTabla = alumnosTabla;
    }

    @Override
    public int getRowCount() {
        return alumnosTabla.getLongitud();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Alumno alumno = alumnosTabla.getInfo(rowIndex);
            switch (columnIndex) {
                case 0:
                    return (alumno != null)? alumno.getDatosAlumno().getNombre() + " " + alumno.getDatosAlumno().getApellido() : " ";
                 case 1:
                     return (alumno != null)? alumno.getDatosAlumno().getNumeroCedula() : "";
                 case 2:
                     return (alumno != null)? alumno.getDatosAlumno().getGenero(): "";
                 case 3:
                     return (alumno != null)? alumno.getDatosAlumno().getDireccion() : "";
                 case 4:
                     return (alumno != null)? alumno.getDatosAlumno().getTelefono() : "";
                default:
                    return null;
            }
        } 
        catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ALUMNO";
            case 1:
                return "DNI";
            case 2:
                return "GENERO";
            case 3:
                return "DIRECCION";
            case 4:
                return "TELEFONO";
            default:
                return null;
        }
    }
    
}
