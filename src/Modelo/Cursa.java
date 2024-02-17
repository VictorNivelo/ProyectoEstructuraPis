
package Modelo;

import Controlador.TDA.ListaDinamica.Excepcion.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;


/**
 *
 * @author Victor
 */
public class Cursa {
    private Integer IdCurso;
    private CodigoCurso codigoCursoCursa;
    private Paralelo ParaleloCursa;
    
    private Matricula matriculaCursa;
    private Docente docenteCursa;
    private ListaDinamica<Matricula> listaMatriculaCursa;
    
    public Cursa() {
        
    }

    public Integer getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(Integer IdCurso) {
        this.IdCurso = IdCurso;
    }

    public Paralelo getParaleloCursa() {
        return ParaleloCursa;
    }

    public void setParaleloCursa(Paralelo ParaleloCursa) {
        this.ParaleloCursa = ParaleloCursa;
    }

    public Matricula getMatriculaCursa() {
        return matriculaCursa;
    }

    public void setMatriculaCursa(Matricula matriculaCursa) {
        this.matriculaCursa = matriculaCursa;
    }

    public ListaDinamica<Matricula> getListaMatriculaCursa() {
        return listaMatriculaCursa;
    }

    public void setListaMatriculaCursa(ListaDinamica<Matricula> listaMatriculaCursa) {
        this.listaMatriculaCursa = listaMatriculaCursa;
    }

    public CodigoCurso getCodigoCursoCursa() {
        return codigoCursoCursa;
    }

    public void setCodigoCursoCursa(CodigoCurso codigoCursoCursa) {
        this.codigoCursoCursa = codigoCursoCursa;
    }
    
    public void agregarMatricula(Matricula matricula) {
        listaMatriculaCursa.Agregar(matricula);
    }

    public Docente getDocenteCursa() {
        return docenteCursa;
    }

    public void setDocenteCursa(Docente docenteCursa) {
        this.docenteCursa = docenteCursa;
    }

    public void quitarMatricula(Matricula matricula) {
        boolean encontrado = false;
        for (int i = 0; i < listaMatriculaCursa.getLongitud(); i++) {
            try {
                Matricula matriculaActual = listaMatriculaCursa.getInfo(i);
                if (matriculaActual.equals(matricula)) {
                    listaMatriculaCursa.eliminar(i);
                    encontrado = true;
                    break;
                }
            } 
            catch (ListaVacia e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        if (!encontrado) {
            System.out.println("Matrícula no encontrada en la lista");
        }
    }

    public void mostrarMatriculas() {
        System.out.println("Matrículas en el curso:");
        for (Matricula m : listaMatriculaCursa.toArray()) {
            System.out.println("- " + m.getAlumnoMatricula().getDatosAlumno().getNumeroCedula()); // Suponiendo que Alumno tiene un atributo nombre
        }
    }
    
    @Override
    public String toString() {
        return ParaleloCursa + "\n";
    }
    
}
