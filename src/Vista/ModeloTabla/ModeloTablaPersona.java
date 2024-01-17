
package Vista.ModeloTabla;

import Controlador.TDA.ListaDinamica.Exepciones.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Persona;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaPersona extends AbstractTableModel {

    private ListaDinamica<Persona> personasTabla;

    public ListaDinamica<Persona> getPersonasTabla() {
        return personasTabla;
    }

    public void setPersonasTabla(ListaDinamica<Persona> personasTabla) {
        this.personasTabla = personasTabla;
    }
    
    @Override
    public int getRowCount() {
        return personasTabla.getLongitud();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }
    
    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            Persona p = personasTabla.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (p != null) ? p.getIdPersona() : "";
                case 1:
                    return (p != null) ? p.getRolPersona().getNombreRol() : "";
                case 2:
                    return (p != null) ? p.getNumeroCedula() : "";
                case 3:
                    return (p != null) ? p.getNombre() : "";
                case 4:
                    return (p != null) ? p.getApellido() : "";
                case 5:
                    return (p != null) ? p.getGenero(): "";
                case 6:
                    return (p != null) ? p.getFechaNacimineto(): "";
                case 7:
                    return (p != null) ? p.getDireccion(): "";
                case 8:
                    return (p != null) ? p.getTelefono(): "";
                case 9:
                    return (p != null) ? p.getCuentaPersona().getCorreo(): "";
                case 10:
                    return (p != null) ? p.getCuentaPersona().getEstadoCuenta(): "";
                default:
                    return null;
            }
        } 
        catch (ListaVacia | IndexOutOfBoundsException ex) {
        }
        return personasTabla;
    }


    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "#";
            case 1:
                return "Rol";
            case 2:
                return "Numero cedula";
            case 3:
                return "Nombre";
            case 4:
                return "Apellido";
            case 5:
                return "Genero";
            case 6:
                return "Fecha nacimiento";
            case 7:
                return "Direccion";
            case 8:
                return "Telefono";
            case 9:
                return "Correo";
            case 10:
                return "Estado cuenta";

            
            default:
                return null;
        }
    }
    
    public double sumarColumna(int columna) {
        double suma = 0.0;

        for (int fila = 0; fila < getRowCount(); fila++) {
            try {
                Object valor = getValueAt(fila, columna);

                if (valor instanceof Number) {
                    suma += ((Number) valor).doubleValue();
                }
            } 
            catch (Exception e) {
            }
        }

        return suma;
    }
}
