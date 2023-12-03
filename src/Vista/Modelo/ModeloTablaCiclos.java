/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.Tda.listas.Exepciones.ListaVacia;
import Modelo.Ciclo;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaCiclos extends AbstractTableModel {

    private ListaDinamica<Ciclo> cicloTabla;

    public ListaDinamica<Ciclo> getCicloTabla() {
        return cicloTabla;
    }

    public void setCicloTabla(ListaDinamica<Ciclo> cicloTabla) {
        this.cicloTabla = cicloTabla;
    }
    
    @Override
    public int getRowCount() {
        return cicloTabla.getLongitud();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            Ciclo p = cicloTabla.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (p != null) ? p.getIdCiclo(): "";
                case 1:
                    return (p != null) ? p.getNombreCiclo(): "";
                case 2:
                    return (p != null) ? p.getNumeroCiclo(): "";
                case 3:
                    return (p != null) ? p.getParaleloCiclo().getNombreParalelo(): "";
                default:
                    return null;
            }
        } 
        catch (ListaVacia | IndexOutOfBoundsException ex) {
        }
        return cicloTabla;
    }


    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id ciclo";
            case 1:
                return "Nombre ciclo";
            case 2:
                return "Numero ciclo";
            case 3:
                return "Paralelo asignado";
            default:
                return null;
        }
    }
}
