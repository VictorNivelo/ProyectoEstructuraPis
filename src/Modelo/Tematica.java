
package Modelo;

/**
 *
 * @author Victor
 */
public class Tematica {
    private Integer IdT;
    private String NombreT;
    private String FechaT;
    
    public Tematica() {
        
    }

    public Integer getIdTematica() {
        return IdT;
    }

    public void setIdTematica(Integer IdTematica) {
        this.IdT = IdTematica;
    }

    public String getNombreTematica() {
        return NombreT;
    }

    public void setNombreTematica(String NombreTematica) {
        this.NombreT = NombreTematica;
    }

    public String getFechaTematica() {
        return FechaT;
    }

    public void setFechaTematica(String FechaTematica) {
        this.FechaT = FechaTematica;
    }
    
    @Override
    public String toString() {
        return "idTematica=" + IdT + ", DiaTematica=" + FechaT + ", NombreTematica=" + NombreT + "\n";
    }
     
}
