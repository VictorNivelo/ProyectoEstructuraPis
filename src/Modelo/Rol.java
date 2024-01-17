
package Modelo;

/**
 *
 * @author Victor
 */
public class Rol {
    private Integer idRol;
    private String nombreRol;
    private String DescripcionRol;

    public Rol() {
        
    }

    public Rol(Integer idRol, String nombreRol, String DescripcionRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.DescripcionRol = DescripcionRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcionRol() {
        return DescripcionRol;
    }

    public void setDescripcionRol(String DescripcionRol) {
        this.DescripcionRol = DescripcionRol;
    }
    
//    public Boolean comparar(Rol r, String campo, Integer tipo) {
//        switch (tipo) {
//            case 0:
//                return compararCampo(r, campo) < 0;
//            case 1:
//                return compararCampo(r, campo) > 0;
//            default:
//                throw new IllegalArgumentException("Tipo de comparación no válido");
//        }
//    }
//
//    private int compararCampo(Rol r, String campo) {
//        switch (campo.toLowerCase()) {
//            case "nombre":
//                return nombreRol.compareTo(r.getNombreRol());
//            case "descripcion":
//                return DescripcionRol.compareTo(r.getDescripcionRol());
//
//            default:
//                throw new IllegalArgumentException("Campo no válido para la comparación");
//        }
//    }

    @Override
    public String toString() {
        return nombreRol;
    }
    
}
