
package Modelo;

/**
 *
 * @author Victor
 */
public class Carrera {
    private Integer IdCarrera;
    private String NombreC;
    private Integer DuracionC;
    private Integer NroCicloC;
    
    private Facultad facutadCarrera;
    private Integer FacultadID;
    
    public Carrera() {
        
    }

    public Integer getIdCarrera() {
        return IdCarrera;
    }

    public void setIdCarrera(Integer IdCarrera) {
        this.IdCarrera = IdCarrera;
    }

    public String getNombreCarrera() {
        return NombreC;
    }

    public void setNombreCarrera(String NombreCarrera) {
        this.NombreC = NombreCarrera;
    }

    public Integer getNumeroCiclos() {
        return NroCicloC;
    }

    public void setNumeroCiclos(Integer NumeroCiclos) {
        this.NroCicloC = NumeroCiclos;
    }

    public Integer getDuracion() {
        return DuracionC;
    }

    public void setDuracion(Integer Duracion) {
        this.DuracionC = Duracion;
    }

    public Facultad getFacutadCarrera() {
        return facutadCarrera;
    }

    public void setFacutadCarrera(Facultad facutadCarrera) {
        this.facutadCarrera = facutadCarrera;
    }

    public Integer getFacultadID() {
        return FacultadID;
    }

    public void setFacultadID(Integer FacultadID) {
        this.FacultadID = FacultadID;
    }

    @Override
    public String toString() {
        return NombreC + "\n";
    }
    
}
