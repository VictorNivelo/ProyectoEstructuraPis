/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Modelo;


import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.Tda.listas.Exepciones.ListaVacia;
import Modelo.Asistencia;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaAsistencia extends AbstractTableModel {

    private ListaDinamica<Asistencia> asistenciaTabla;

    public ListaDinamica<Asistencia> getAsistenciaTabla() {
        return asistenciaTabla;
    }

    public void setAsistenciaTabla(ListaDinamica<Asistencia> asistenciaTabla) {
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
    
    private String EstadoCuenta(int i) throws ListaVacia {
        
        Asistencia p = asistenciaTabla.getInfo(i);
        
        if (p.getEstadoAsistencia()) {
            return "Matriculado";
        } 
        else {
            return "Retirado";
        }
    }
    
    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            Asistencia p = asistenciaTabla.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (p != null) ? p.getIdAsistencia(): "";
                case 1:
                    return (p != null) ? p.getDiaAsistencia(): "";
                case 2:
                    return (p != null) ? p.getAsistenciaCurso(): "";
                case 3:
                    return (p != null) ? EstadoCuenta(Fila): "";
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
