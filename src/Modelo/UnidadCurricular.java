/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

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

//    public UnidadCurricular(Integer IdUnidadCurricular, String CodigoUnidadCurricular, String NombreUnidadCurricular, String DescripcionUnidadCurricular, MallaCurricular mallaCurricularUnidadCurricular) {
//        this.IdUnidadCurricular = IdUnidadCurricular;
//        this.CodigoUnidadCurricular = CodigoUnidadCurricular;
//        this.NombreUnidadCurricular = NombreUnidadCurricular;
//        this.DescripcionUnidadCurricular = DescripcionUnidadCurricular;
//        this.mallaCurricularUnidadCurricular = mallaCurricularUnidadCurricular;
//    }

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

    @Override
    public String toString() {
        return "Codigo:" + CodigoUnidadCurricular + ", Nombre:" + NombreUnidadCurricular + "\n";
    }
    
}
