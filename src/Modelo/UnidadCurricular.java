
package Modelo;

/**
 *
 * @author Victor
 */
public class UnidadCurricular {
    private Integer IdUC;
    private String CodigoUC;
    private String NombreUC;
    private String DescripcionUC;
    
    private MallaC mallaCurricularUnidadCurricular;
    private Integer MallaCurricularID;
    

    public Integer getIdUnidadCurricular() {
        return IdUC;
    }

    public void setIdUnidadCurricular(Integer IdUnidadCurricular) {
        this.IdUC = IdUnidadCurricular;
    }

    public String getCodigoUnidadCurricular() {
        return CodigoUC;
    }

    public void setCodigoUnidadCurricular(String CodigoUnidadCurricular) {
        this.CodigoUC = CodigoUnidadCurricular;
    }

    public String getNombreUnidadCurricular() {
        return NombreUC;
    }

    public void setNombreUnidadCurricular(String NombreUnidadCurricular) {
        this.NombreUC = NombreUnidadCurricular;
    }

    public String getDescripcionUnidadCurricular() {
        return DescripcionUC;
    }

    public void setDescripcionUnidadCurricular(String DescripcionUnidadCurricular) {
        this.DescripcionUC = DescripcionUnidadCurricular;
    }

    public MallaC getMallaCurricularUnidadCurricular() {
        return mallaCurricularUnidadCurricular;
    }

    public void setMallaCurricularUnidadCurricular(MallaC mallaCurricularUnidadCurricular) {
        this.mallaCurricularUnidadCurricular = mallaCurricularUnidadCurricular;
    }

    public Integer getMallaCurricularID() {
        return MallaCurricularID;
    }

    public void setMallaCurricularID(Integer MallaCurricularID) {
        this.MallaCurricularID = MallaCurricularID;
    }

    @Override
    public String toString() {
        return CodigoUC + " " +NombreUC + "\n";
    }
    
}
