
package Modelo;

/**
 *
 * @author Victor
 */
public class Rol {
    private Integer IdRol;
    private String NombreR;
    private String DescripcionR;

    public Rol() {
        
    }

    public Integer getIdRol() {
        return IdRol;
    }

    public void setIdRol(Integer IdRol) {
        this.IdRol = IdRol;
    }

    public String getNombreRol() {
        return NombreR;
    }

    public void setNombreRol(String NombreRol) {
        this.NombreR = NombreRol;
    }

    public String getDescripcionRol() {
        return DescripcionR;
    }

    public void setDescripcionRol(String DescripcionRol) {
        this.DescripcionR = DescripcionRol;
    }

    @Override
    public String toString() {
        return NombreR;
    }
    
}
