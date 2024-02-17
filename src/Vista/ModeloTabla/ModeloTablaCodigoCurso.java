
package Vista.ModeloTabla;

import Controlador.TDA.ListaDinamica.Excepcion.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.CodigoCurso;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaCodigoCurso extends AbstractTableModel {

    private ListaDinamica<CodigoCurso> codigoCursoTabla;

    public ListaDinamica<CodigoCurso> getCodigoCursoTabla() {
        return codigoCursoTabla;
    }

    public void setCodigoCursoTabla(ListaDinamica<CodigoCurso> codigoCursoTabla) {
        this.codigoCursoTabla = codigoCursoTabla;
    }
    
    @Override
    public int getRowCount() {
        return codigoCursoTabla.getLongitud();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            CodigoCurso p = codigoCursoTabla.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (p != null) ? p.getIdCodigoCurso(): "";
                case 1:
                    return (p != null) ? p.getNombreCodigoCurso(): "";
                default:
                    return null;
            }
        } 
        catch (ListaVacia | IndexOutOfBoundsException ex) {
            
        }
        return codigoCursoTabla;
    }


    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "#";
            case 1:
                return "Nombre";

            default:
                return null;
        }
    }

}
