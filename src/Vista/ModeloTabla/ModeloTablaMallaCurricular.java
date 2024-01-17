
package Vista.ModeloTabla;

import Controlador.TDA.ListaDinamica.Exepciones.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.MallaCurricular;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaMallaCurricular extends AbstractTableModel {

    private ListaDinamica<MallaCurricular> mallaTabla;

    public ListaDinamica<MallaCurricular> getMallaTabla() {
        return mallaTabla;
    }

    public void setMallaTabla(ListaDinamica<MallaCurricular> mallaTabla) {
        this.mallaTabla = mallaTabla;
    }
    
    @Override
    public int getRowCount() {
        return mallaTabla.getLongitud();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            MallaCurricular p = mallaTabla.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (p != null) ? p.getIdMallaCurricular(): "";
                case 1:
                    return (p != null) ? p.getNombreMallaCurricular(): "";
                case 2:
                    return (p != null) ? p.getDuracionMallaCurricular()+" años" : "";
                case 3:
                    return (p != null) ? p.getCarreraMalla().getNombreCarrera() : "";
                default:
                    return null;
            }
        } 
        catch (ListaVacia | IndexOutOfBoundsException ex) {
            
        }
        return mallaTabla;
    }


    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "#";
            case 1:
                return "Nombre malla";
            case 2:
                return "Duracion";
            case 3:
                return "Carrera";
            default:
                return null;
        }
    }
}
