
package Modelo;

/**
 *
 * @author Victor
 */
public class Rol {
    private Integer IdRol;
    private String NombreRol;
    private String DescripcionRol;

    public Rol() {
        
    }

//    public Rol(Integer IdRol, String NombreRol, String DescripcionRol) {
//        this.IdRol = IdRol;
//        this.NombreRol = NombreRol;
//        this.DescripcionRol = DescripcionRol;
//    }

    public Integer getIdRol() {
        return IdRol;
    }

    public void setIdRol(Integer IdRol) {
        this.IdRol = IdRol;
    }

    public String getNombreRol() {
        return NombreRol;
    }

    public void setNombreRol(String NombreRol) {
        this.NombreRol = NombreRol;
    }

    public String getDescripcionRol() {
        return DescripcionRol;
    }

    public void setDescripcionRol(String DescripcionRol) {
        this.DescripcionRol = DescripcionRol;
    }

    @Override
    public String toString() {
        return NombreRol;
    }
    
}
