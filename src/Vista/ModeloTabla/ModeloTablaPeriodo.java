/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.ModeloTabla;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.PeriodoAcademico;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author romer
 */
public class ModeloTablaPeriodo extends AbstractTableModel {
    ListaDinamica<PeriodoAcademico> periodos;

    @Override
    public int getRowCount() {
        return periodos.getLongitud();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            PeriodoAcademico periodo = periodos.getInfo(rowIndex);
            switch (columnIndex) {
                case 0:
                    return (periodo != null) ? periodo.getIdPeriodoAcademino() : "";
                case 1:
                    return (periodo != null) ? periodo.getFechaInicio() : "";
                case 2:
                    return (periodo != null) ? periodo.getFechaFin() : "";
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
        
    }
    
    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0:
                return "#";
            case 1:
                return "Fecha inicio";
            case 2:
                return "Fecha fin";
            default:
                return null;
        }
    }

    public ListaDinamica<PeriodoAcademico> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(ListaDinamica<PeriodoAcademico> periodos) {
        this.periodos = periodos;
    }
    
    
}
