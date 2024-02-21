
package Modelo;

/**
 *
 * @author Victor
 */
public class Facultad {
    private Integer IdF;
    private String NombreF;
    private String FechaCF;
    
    private Universidad universidadFacultad;
    private Integer UniversidadID;

    public Facultad() {

    }

    public Integer getIdFacultad() {
        return IdF;
    }

    public void setIdFacultad(Integer IdFacultad) {
        this.IdF = IdFacultad;
    }

    public String getNombreFacultad() {
        return NombreF;
    }

    public void setNombreFacultad(String NombreFacultad) {
        this.NombreF = NombreFacultad;
    }

    public String getFechaCreacion() {
        return FechaCF;
    }

    public void setFechaCreacion(String FechaCreacion) {
        this.FechaCF = FechaCreacion;
    }

    public Universidad getUniversidadFacultad() {
        return universidadFacultad;
    }

    public void setUniversidadFacultad(Universidad universidadFacultad) {
        this.universidadFacultad = universidadFacultad;
    }

    public Integer getUniversidadID() {
        return UniversidadID;
    }

    public void setUniversidadID(Integer UniversidadID) {
        this.UniversidadID = UniversidadID;
    }
        
    @Override
    public String toString() {
        return NombreF +  "\n";
    }
    
}
