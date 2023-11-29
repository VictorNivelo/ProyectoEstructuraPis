/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.Tda.listas.Exepciones.ListaVacia;
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
        return 10;
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
                    return (p != null) ? p.getIdCurso(): "";
                case 1:
                    return (p != null) ? p.getMateriaCurso().getNombreMateria() : "";
                case 2:
                    return (p != null) ? p.getMateriaCurso().getDescipcionMateria() : "";
                case 3:
                    return (p != null) ? p.getCicloCurso().getNombreCiclo(): "";
                case 4:
                    return (p != null) ? p.getCicloCurso().getNumeroCiclo(): "";
                case 5:
                    return (p != null) ? p.getNombreCurso(): "";
                case 6:
                    return (p != null) ? p.getNombreCurso(): "";
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
                return "Id persona";
            case 1:
                return "Numero cedula";
            case 2:
                return "Nombre";
            case 3:
                return "Apellido";
            case 4:
                return "Genero";
            case 5:
                return "Fecha nacimiento";
            case 6:
                return "Direccion";
            case 7:
                return "Telefono";
            case 8:
                return "Correo";
            case 9:
                return "Estado cuenta";

            
            default:
                return null;
        }
    }
}
