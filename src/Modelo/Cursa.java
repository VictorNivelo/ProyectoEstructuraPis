
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;


/**
 *
 * @author Victor
 */
public class Cursa {
    private Integer IdCurso;
    private String Paralelo;
    
    private Matricula matriculaCursa;
    private ListaDinamica<Matricula> listaMatriculaCursa;
    
    private Docente docenteCursa;
    private ListaDinamica<Docente> listaDocentesCursa;
    
    private Materia MateriaCurso;
    private ListaDinamica<Materia> listaMateriaCurso;
    
    public Cursa() {
        
    }

//    public Cursa(Integer IdCurso, String CodigoCurso, String Paralelo, Materia MateriaCurso) {
//        this.IdCurso = IdCurso;
//        this.CodigoCurso = CodigoCurso;
//        this.Paralelo = Paralelo;
//        this.MateriaCurso = MateriaCurso;
//    }

    public Integer getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(Integer IdCurso) {
        this.IdCurso = IdCurso;
    }

    public String getParalelo() {
        return Paralelo;
    }

    public void setParalelo(String Paralelo) {
        this.Paralelo = Paralelo;
    }

    public Materia getMateriaCurso() {
        return MateriaCurso;
    }

    public void setMateriaCurso(Materia MateriaCurso) {
        this.MateriaCurso = MateriaCurso;
    }

    public ListaDinamica<Materia> getListaMateriaCurso() {
        return listaMateriaCurso;
    }

    public void setListaMateriaCurso(ListaDinamica<Materia> listaMateriaCurso) {
        this.listaMateriaCurso = listaMateriaCurso;
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

    public Docente getDocenteCursa() {
        return docenteCursa;
    }

    public void setDocenteCursa(Docente docenteCursa) {
        this.docenteCursa = docenteCursa;
    }

    public ListaDinamica<Docente> getListaDocentesCursa() {
        return listaDocentesCursa;
    }

    public void setListaDocentesCursa(ListaDinamica<Docente> listaDocentesCursa) {
        this.listaDocentesCursa = listaDocentesCursa;
    }
    
    @Override
    public String toString() {
        return "Paralelo:" + Paralelo + "\n";
    }
    
}
