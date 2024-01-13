/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.ModeloTabla;

import Controlador.TDA.ListaDinamica.Exepciones.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Matricula;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author romer
 */
public class ModeloTablaMatriculas extends AbstractTableModel{
    private ListaDinamica<Matricula> matriculas;

    @Override
    public int getRowCount() {
        return matriculas.getLongitud();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Matricula matricula = matriculas.getInfo(rowIndex);
            switch (columnIndex) {
                case 0:
                    return (matricula != null)? matricula.getFechaMatricula() : "";
                case 1:
                     return (matricula != null)? matricula.getEstadoMatricula(): "";
                case 2:
                     return (matricula != null)? matricula.getMatriculaPeriodoAcademico().getFechaInicio(): "";
                case 3:
                     return (matricula != null)? matricula.getMatriculaPeriodoAcademico().getFechaFin(): "";
                case 4:
                    return (matricula != null)? matricula.getMatriculaCursa().getCodigoCurso(): "";
                default:
                    return null;
            }
        } 
        catch (ListaVacia ex) {
            return null;
        }   
    }
    
    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0:
                return "Fecha Matricula";
            case 1:
                return "Estado";
            case 2:
                return "Periodo inicio";
            case 3:
                return "Periodo fin";
            case 4:
                return "Cursa";
            default:
                return null;
        }
    }

    public ListaDinamica<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(ListaDinamica<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
    
    
}
