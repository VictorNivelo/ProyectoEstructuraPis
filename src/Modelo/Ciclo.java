
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;


/**
 *
 * @author Victor
 */
public class Ciclo {
    private Integer IdCiclo;
    private String NombreCiclo;
    private Integer NumeroCiclo;

    private UnidadCurricular unidadCurricularCiclo;
    
    //datos poco usados
    private MallaCurricular mallaCurricularCiclo;
    private Materia materiaCiclo;
    private ListaDinamica<Materia> listaMateriaCiclo;

    public Ciclo() {
        
    }

//    public Ciclo(Integer IdCiclo, String NombreCiclo, Integer NumeroCiclo, MallaCurricular mallaCurricularCiclo) {
//        this.IdCiclo = IdCiclo;
//        this.NombreCiclo = NombreCiclo;
//        this.NumeroCiclo = NumeroCiclo;
//        this.mallaCurricularCiclo = mallaCurricularCiclo;
//    }

    public MallaCurricular getMallaCurricularCiclo() {
        return mallaCurricularCiclo;
    }

    public void setMallaCurricularCiclo(MallaCurricular mallaCurricularCiclo) {
        this.mallaCurricularCiclo = mallaCurricularCiclo;
    }
    
    public Integer getIdCiclo() {
        return IdCiclo;
    }

    public void setIdCiclo(Integer IdCiclo) {
        this.IdCiclo = IdCiclo;
    }

    public String getNombreCiclo() {
        return NombreCiclo;
    }

    public void setNombreCiclo(String NombreCiclo) {
        this.NombreCiclo = NombreCiclo;
    }

    public Integer getNumeroCiclo() {
        return NumeroCiclo;
    }

    public void setNumeroCiclo(Integer NumeroCiclo) {
        this.NumeroCiclo = NumeroCiclo;
    }

    public Materia getMateriaCiclo() {
        return materiaCiclo;
    }

    public void setMateriaCiclo(Materia materiaCiclo) {
        this.materiaCiclo = materiaCiclo;
    }

    public ListaDinamica<Materia> getListaMateriaCiclo() {
        return listaMateriaCiclo;
    }

    public void setListaMateriaCiclo(ListaDinamica<Materia> listaMateriaCiclo) {
        this.listaMateriaCiclo = listaMateriaCiclo;
    }

    public UnidadCurricular getUnidadCurricularCiclo() {
        return unidadCurricularCiclo;
    }

    public void setUnidadCurricularCiclo(UnidadCurricular unidadCurricularCiclo) {
        this.unidadCurricularCiclo = unidadCurricularCiclo;
    }
    
    @Override
    public String toString() {
        return NombreCiclo+"\n";
    }
    
}
