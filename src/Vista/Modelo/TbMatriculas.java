/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.Tda.listas.Exepciones.ListaVacia;
import Modelo.Matricula;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author romer
 */
public class TbMatriculas extends AbstractTableModel{
    private ListaDinamica<Matricula> matriculas;

    @Override
    public int getRowCount() {
        return matriculas.getLongitud();
    }

    @Override
    public int getColumnCount() {
        return 4;
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
                     return (matricula != null)? matricula.getMatriculaPeriodoAcademico(): "";
                case 3:
                    return (matricula != null)? matricula.getMatriculaCursa(): "";
                default:
                    return null;
            }
        } catch (ListaVacia ex) {
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
                return "Periodo Academico";
            case 3:
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
