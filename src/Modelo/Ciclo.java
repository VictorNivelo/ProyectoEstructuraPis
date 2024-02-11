
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
    private ListaDinamica<UnidadCurricular> listaUnidadCurriculaCiclo;

    public Ciclo() {
        
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

    public UnidadCurricular getUnidadCurricularCiclo() {
        return unidadCurricularCiclo;
    }

    public void setUnidadCurricularCiclo(UnidadCurricular unidadCurricularCiclo) {
        this.unidadCurricularCiclo = unidadCurricularCiclo;
    }

    public ListaDinamica<UnidadCurricular> getListaUnidadCurriculaCiclo() {
        return listaUnidadCurriculaCiclo;
    }

    public void setListaUnidadCurriculaCiclo(ListaDinamica<UnidadCurricular> listaUnidadCurriculaCiclo) {
        this.listaUnidadCurriculaCiclo = listaUnidadCurriculaCiclo;
    }
    
    @Override
    public String toString() {
        return NombreCiclo+"\n";
    }
    
}
