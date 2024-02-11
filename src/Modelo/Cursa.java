
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
    
    public Cursa() {
        
    }

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
    
    @Override
    public String toString() {
        return Paralelo + "\n";
    }
    
}
