/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.Tda.listas.Exepciones.ListaVacia;
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
        return 3;
    }
    
    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            Materia p = materiaTabla.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (p != null) ? p.getIdMateria(): "";
                case 1:
                    return (p != null) ? p.getNombreMateria() : "";
                case 2:
                    return (p != null) ? p.getDescipcionMateria(): "";
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
                return "Id materia";
            case 1:
                return "Nombre materia";
            case 2:
                return "Descripcion materia";
            default:
                return null;
        }
    }
}
