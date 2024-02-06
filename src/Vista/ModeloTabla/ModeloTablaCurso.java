
package Vista.ModeloTabla;

import Controlador.TDA.ListaDinamica.Excepcion.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Cursa;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaCurso extends AbstractTableModel {

    private ListaDinamica<Cursa> cursoTabla;

    public ListaDinamica<Cursa> getCursoTabla() {
        return cursoTabla;
    }

    public void setCursoTabla(ListaDinamica<Cursa> cursoTabla) {
        this.cursoTabla = cursoTabla;
    }
       
    @Override
    public int getRowCount() {
        return cursoTabla.getLongitud();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
//    private String EstadoCuenta(int i) throws ListaVacia {
//        
//        Cursa p = personasTabla.getInfo(i);
//        
//        if (p.get().getEstadoCuenta()) {
//            return "Activa";
//        } 
//        else {
//            return "Inactiva";
//        }
//    }
//    
    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            Cursa p = cursoTabla.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (p != null) ? p.getIdCurso() : "";
                case 1:
                    return (p != null) ? p.getDocenteCursa().getDatosDocente().getNumeroCedula(): "";
                case 2:
                    return (p != null) ? p.getDocenteCursa().getDatosDocente().getNombre(): "";
                case 3:
                    return (p != null) ? p.getParalelo() : "";
                default:
                    return null;
            }
        } 
        catch (ListaVacia | IndexOutOfBoundsException ex) {
        }
        return cursoTabla;
    }


    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "#";
            case 1:
                return "DNI";
            case 2:
                return "Nombre";
            case 3:
                return "Paralelo";

            default:
                return null;
        }
    }
    
}
