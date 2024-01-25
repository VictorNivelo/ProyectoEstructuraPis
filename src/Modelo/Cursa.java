
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;


/**
 *
 * @author Victor
 */
public class Cursa {
    private Integer IdCurso;
    private String CodigoCurso;
    private String Paralelo;
    
    private Materia MateriaCurso;
    private ListaDinamica<Materia> listaMateriaCurso;
    
    public Cursa() {
        
    }

    public Cursa(Integer IdCurso, String CodigoCurso, String Paralelo, Materia MateriaCurso) {
        this.IdCurso = IdCurso;
        this.CodigoCurso = CodigoCurso;
        this.Paralelo = Paralelo;
        this.MateriaCurso = MateriaCurso;
    }

    public Integer getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(Integer IdCurso) {
        this.IdCurso = IdCurso;
    }

    public String getCodigoCurso() {
        return CodigoCurso;
    }

    public void setCodigoCurso(String CodigoCurso) {
        this.CodigoCurso = CodigoCurso;
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

    @Override
    public String toString() {
        return "Codigo:" + CodigoCurso + ", Paralelo:" + Paralelo + "\n";
    }
    
}
