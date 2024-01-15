
package Modelo;

/**
 *
 * @author Victor
 */
public class Carrera {
    private Integer idCarrera;
    private String NombreCarrera;
    private Integer NumeroCiclos;
    private Integer duracion;
    private MallaCurricular CarreraMalla;

    public Carrera() {
        
    }

    public Carrera(Integer idCarrera, String NombreCarrera, Integer duracion) {
        this.idCarrera = idCarrera;
        this.NombreCarrera = NombreCarrera;
        this.duracion = duracion;
    }

    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return NombreCarrera;
    }

    public void setNombreCarrera(String NombreCarrera) {
        this.NombreCarrera = NombreCarrera;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getNumeroCiclos() {
        return NumeroCiclos;
    }

    public void setNumeroCiclos(Integer NumeroCiclos) {
        this.NumeroCiclos = NumeroCiclos;
    }

    public MallaCurricular getCarreraMalla() {
        return CarreraMalla;
    }

    public void setCarreraMalla(MallaCurricular CarreraMalla) {
        this.CarreraMalla = CarreraMalla;
    }

    @Override
    public String toString() {
        return NombreCarrera + "\n";
    }
    
}
