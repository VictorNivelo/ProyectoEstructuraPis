
package Vista.ModeloTabla;

import Controlador.TDA.ListaDinamica.Excepcion.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Cursa;
import Modelo.Matricula;
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
        return 6;
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
            Cursa curso = cursoTabla.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (curso != null) ? curso.getIdCurso() : "";
                case 1:
                    return (curso != null && curso.getParaleloCursa() != null) ? curso.getParaleloCursa().getNombre() : "";
//                    return (curso != null) ? curso.getParaleloCursa().getNombre() : "";
                case 2:
                    ListaDinamica<Matricula> listaMatriculas = curso.getListaMatriculaCursa();
                    if (listaMatriculas != null && !listaMatriculas.EstaVacio()) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < listaMatriculas.getLongitud(); i++) {
                            Matricula matricula = listaMatriculas.getInfo(i);
                            if (matricula != null) {
                                sb.append(matricula.getAlumnoMatricula().getDatosAlumno().getNumeroCedula());
                                if (i < listaMatriculas.getLongitud() - 1) {
                                    sb.append(", ");
                                }
                            }
                        }
                        return sb.toString();
                    } else {
                        return "";
                    }
                case 3:
                    StringBuilder estados = new StringBuilder();
                    ListaDinamica<Matricula> listaMatriculasEstado = curso.getListaMatriculaCursa();
                    if (listaMatriculasEstado != null && !listaMatriculasEstado.EstaVacio()) {
                        for (int i = 0; i < listaMatriculasEstado.getLongitud(); i++) {
                            Matricula matriculaEstado = listaMatriculasEstado.getInfo(i);
                            if (matriculaEstado != null) {
                                estados.append(matriculaEstado.getEstadoMatricula());
                                if (i < listaMatriculasEstado.getLongitud() - 1) {
                                    estados.append(", ");
                                }
                            }
                        }
                    }
                    return estados.toString();
                case 4:
                    // Aquí obtenemos el código del curso
                    return (curso != null && curso.getCodigoCursoCursa() != null) ? curso.getCodigoCursoCursa().getNombreCodigoCurso() : "";
//                    String codigoCurso = (curso != null) ? curso.getCodigoCursoCursa().getNombreCodigoCurso() : "";
//                    return codigoCurso;
                case 5:
                    StringBuilder codigos = new StringBuilder();
                    ListaDinamica<Matricula> listaMatriculasCodigo = curso.getListaMatriculaCursa();
                    if (listaMatriculasCodigo != null && !listaMatriculasCodigo.EstaVacio()) {
                        for (int i = 0; i < listaMatriculasCodigo.getLongitud(); i++) {
                            Matricula matriculaCodigo = listaMatriculasCodigo.getInfo(i);
                            if (matriculaCodigo != null) {
                                codigos.append(matriculaCodigo.getCodigoMatricula());
                                if (i < listaMatriculasCodigo.getLongitud() - 1) {
                                    codigos.append(", ");
                                }
                            }
                        }
                    }
                    return codigos.toString();
                default:
                    return null;
            }
        } catch (ListaVacia | IndexOutOfBoundsException ex) {
            ex.printStackTrace();
            return null;
        }


//        try {
//            Cursa p = cursoTabla.getInfo(Fila);
//
//            switch (Columna) {
//                case 0:
//                    return (p != null) ? p.getIdCurso() : "";
//                case 1:
//                    return (p != null) ? p.getParaleloCursa().getNombre(): "";
//                case 2:
//                    return (p != null) ? p.getListaMatriculaCursa().getInfo(Fila).getAlumnoMatricula().getDatosAlumno().getNumeroCedula(): "";
//                case 3:
//                    return (p != null) ? p.getListaMatriculaCursa().getInfo(Fila).getEstadoMatricula(): "";
//                case 4:
//                    return (p != null) ? p.getListaMatriculaCursa().getInfo(Fila).getCodigoMatricula(): "";
//                case 5:
//                    return (p != null) ? p.getCodigoCursoCursa().getNombreCodigoCurso(): "";
//                default:
//                    return null;
//            }
//        } 
//        catch (ListaVacia | IndexOutOfBoundsException ex) {
//        }
//        return cursoTabla;

/*Primero si sirve*/
//            Cursa p = cursoTabla.getInfo(Fila);
//
//            switch (Columna) {
//                case 0:
//                    return (p != null) ? p.getIdCurso() : "";
//                case 1:
//                    return (p != null) ? p.getParaleloCursa().getNombre(): "";
//                case 2:
//                    return (p != null) ? p.getMatriculaCursa().getAlumnoMatricula().getDatosAlumno().getNumeroCedula(): "";
//                case 3:
//                    return (p != null) ? p.getMatriculaCursa().getEstadoMatricula(): "";
//                case 4:
//                    return (p != null) ? p.getMatriculaCursa().getCodigoMatricula(): "";
//                case 5:
//                    return (p != null) ? p.getCodigoCursoCursa().getNombreCodigoCurso(): "";
//                default:
//                    return null;
//            }
//        } 
//        catch (ListaVacia | IndexOutOfBoundsException ex) {
//        }
//        return cursoTabla;
    }


    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "#";
            case 1:
                return "Paralelo";
            case 2:
                return "DNI alumno";
            case 3:
                return "Estado matricula";
            case 4:
                return "Codigo matricula";
            case 5:
                return "Codigo curso";

            default:
                return null;
        }
    }
    
}
