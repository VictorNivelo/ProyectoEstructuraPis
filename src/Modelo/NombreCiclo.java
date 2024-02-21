
package Modelo;

/**
 *
 * @author Victor
 */
public class NombreCiclo {
    private Integer IdNombreC;
    private String NombreCiclo;

    public NombreCiclo() {
        
    }

    public Integer getIdNombreCiclo() {
        return IdNombreC;
    }

    public void setIdNombreCiclo(Integer IdNombreCiclo) {
        this.IdNombreC = IdNombreCiclo;
    }

    public String getNombreCiclo() {
        return NombreCiclo;
    }

    public void setNombreCiclo(String NombreCiclo) {
        this.NombreCiclo = NombreCiclo;
    }
    
    @Override
    public String toString() {
        return NombreCiclo;
    }
    
}
