/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Modelo;


import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.Tda.listas.Exepciones.ListaVacia;
import Modelo.Alumno;
import Vista.VistaAsistencia;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Victor
 */
public class ModeloTablaAsistencia extends AbstractTableModel {

    private ListaDinamica<Alumno> pasajerosTabla;

    public ListaDinamica<Alumno> getPasajerosTabla() {
        return pasajerosTabla;
    }

    public void setPasajerosTabla(ListaDinamica<Alumno> pasajerosTabla) {
        this.pasajerosTabla = pasajerosTabla;
    }
    
    @Override
    public int getRowCount() {
        return pasajerosTabla.getLongitud();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            Alumno p = pasajerosTabla.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (p != null) ? p.getIdAlumno(): "";
                case 1:
                    return (p != null) ? p.getDatosAlumno().getNombre(): "";
                case 2:
                    return (p != null) ? p.getDatosAlumno().getApellido(): "";
                case 3:
                    return "";
                default:
                    return null;
            }
        } 
        catch (ListaVacia | IndexOutOfBoundsException ex) {
        }
        return pasajerosTabla;
    }


    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id alumno";
            case 1:
                return "Nombre";
            case 2:
                return "Apellido";
            case 3:
                return "Asistencia";
            
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
