/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.ModeloTabla;

import Controlador.TDA.ListaDinamica.Exepciones.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Cursa;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaCurso extends AbstractTableModel {

    private ListaDinamica<Cursa> cursoTabla;

    public ListaDinamica<Cursa> getCursoTabla() {
        return cursoTabla;
    }

    public void setCursoTabla(ListaDinamica<Cursa> cursoTabla) {
        this.cursoTabla = cursoTabla;
    }
       
    @Override
    public int getRowCount() {
        return cursoTabla.getLongitud();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
//    private String EstadoCuenta(int i) throws ListaVacia {
//        
//        Cursa p = personasTabla.getInfo(i);
//        
//        if (p.get().getEstadoCuenta()) {
//            return "Activa";
//        } 
//        else {
//            return "Inactiva";
//        }
//    }
//    
    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            Cursa p = cursoTabla.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (p != null) ? p.getIdCurso() : "";
                case 1:
                    return (p != null) ? p.getMateriaCurso().getCicloMateria().getNombreCiclo() : "";
                case 2:
                    return (p != null) ? p.getParalelo() : "";
                case 3:
                    return (p != null) ? p.getCodigoCurso(): "";
                case 4:
                    return (p != null) ? p.getMateriaCurso().getNombreMateria() : "";
                case 5:
                    return (p != null) ? p.getPeriodoAcademicoCurso().getFechaInicio() : "";
                case 6:
                    return (p != null) ? p.getPeriodoAcademicoCurso().getFechaFin() : "";

                default:
                    return null;
            }
        } 
        catch (ListaVacia | IndexOutOfBoundsException ex) {
        }
        return cursoTabla;
    }


    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "#";
            case 1:
                return "Ciclo";
            case 2:
                return "Paralelo";
            case 3:
                return "Codigo";
            case 4:
                return "Materia";
            case 5:
                return "Inicio";
            case 6:
                return "Fin";

            default:
                return null;
        }
    }
}
