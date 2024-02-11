
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class UnidadCurricular {
    private Integer IdUnidadCurricular;
    private String CodigoUnidadCurricular;
    private String NombreUnidadCurricular;
    private String DescripcionUnidadCurricular;
    
    private MallaCurricular mallaCurricularUnidadCurricular;
    private ListaDinamica<MallaCurricular> listaMallaCurricularUnidadCurricula;


    public Integer getIdUnidadCurricular() {
        return IdUnidadCurricular;
    }

    public void setIdUnidadCurricular(Integer IdUnidadCurricular) {
        this.IdUnidadCurricular = IdUnidadCurricular;
    }

    public String getCodigoUnidadCurricular() {
        return CodigoUnidadCurricular;
    }

    public void setCodigoUnidadCurricular(String CodigoUnidadCurricular) {
        this.CodigoUnidadCurricular = CodigoUnidadCurricular;
    }

    public String getNombreUnidadCurricular() {
        return NombreUnidadCurricular;
    }

    public void setNombreUnidadCurricular(String NombreUnidadCurricular) {
        this.NombreUnidadCurricular = NombreUnidadCurricular;
    }

    public String getDescripcionUnidadCurricular() {
        return DescripcionUnidadCurricular;
    }

    public void setDescripcionUnidadCurricular(String DescripcionUnidadCurricular) {
        this.DescripcionUnidadCurricular = DescripcionUnidadCurricular;
    }

    public MallaCurricular getMallaCurricularUnidadCurricular() {
        return mallaCurricularUnidadCurricular;
    }

    public void setMallaCurricularUnidadCurricular(MallaCurricular mallaCurricularUnidadCurricular) {
        this.mallaCurricularUnidadCurricular = mallaCurricularUnidadCurricular;
    }

    public ListaDinamica<MallaCurricular> getListaMallaCurricularUnidadCurricula() {
        return listaMallaCurricularUnidadCurricula;
    }

    public void setListaMallaCurricularUnidadCurricula(ListaDinamica<MallaCurricular> listaMallaCurricularUnidadCurricula) {
        this.listaMallaCurricularUnidadCurricula = listaMallaCurricularUnidadCurricula;
    }

    @Override
    public String toString() {
        return CodigoUnidadCurricular + " " +NombreUnidadCurricular + "\n";
    }
    
}
