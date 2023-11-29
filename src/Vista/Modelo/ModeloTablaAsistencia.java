/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Modelo;


import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.Tda.listas.Exepciones.ListaVacia;
import Modelo.Alumno;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaAsistencia extends AbstractTableModel {

    private ListaDinamica<Alumno> asistenciaTabla;

    public ListaDinamica<Alumno> getAsistenciaTabla() {
        return asistenciaTabla;
    }

    public void setAsistenciaTabla(ListaDinamica<Alumno> asistenciaTabla) {
        this.asistenciaTabla = asistenciaTabla;
    }

    @Override
    public int getRowCount() {
        return asistenciaTabla.getLongitud();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    public void setValueAt(Object valor, int fila, int columna) {
        if (columna == 3 && valor instanceof Boolean) {
            try {
                Alumno p = asistenciaTabla.getInfo(fila);
                if (p != null) {
                    p.getAsistenciaAlumno().setEstadoAsistencia((Boolean) valor);
                    fireTableCellUpdated(fila, columna); // Notifica a la tabla que los datos han cambiado
                }
            } catch (ListaVacia | IndexOutOfBoundsException ex) {
                // Manejar la excepción adecuadamente
            }
        }
    }

    public boolean isCellEditable(int fila, int columna) {
        // Solo permitir la edición en la columna de asistencia
        return columna == 3;
    }
    
    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            Alumno p = asistenciaTabla.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (p != null) ? p.getIdAlumno(): "";
                case 1:
                    return (p != null) ? p.getDatosAlumno().getNombre(): "";
                case 2:
                    return (p != null) ? p.getDatosAlumno().getApellido(): "";
                case 3:
                    return (p != null) ? p.getAsistenciaAlumno().getEstadoAsistencia(): true;
                default:
                    return null;
            }
        } 
        catch (ListaVacia | IndexOutOfBoundsException ex) {
        }
        return asistenciaTabla;
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
