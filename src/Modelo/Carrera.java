
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class Carrera {
    private Integer IdCarrera;
    private String NombreCarrera;
    private Integer NumeroCiclos;
    private Integer Duracion;
    
    private Facultad facutadCarrera;
    
    //datos poco usados
    private MallaCurricular CarreraMalla;
    private ListaDinamica<MallaCurricular> listaMallaCarrera;

    public Carrera() {
        
    }

//    public Carrera(Integer IdCarrera, String NombreCarrera, Integer NumeroCiclos, Integer Duracion, Facultad facutadCarrera) {
//        this.IdCarrera = IdCarrera;
//        this.NombreCarrera = NombreCarrera;
//        this.NumeroCiclos = NumeroCiclos;
//        this.Duracion = Duracion;
//        this.facutadCarrera = facutadCarrera;
//    }

    public Integer getIdCarrera() {
        return IdCarrera;
    }

    public void setIdCarrera(Integer IdCarrera) {
        this.IdCarrera = IdCarrera;
    }

    public String getNombreCarrera() {
        return NombreCarrera;
    }

    public void setNombreCarrera(String NombreCarrera) {
        this.NombreCarrera = NombreCarrera;
    }

    public Integer getNumeroCiclos() {
        return NumeroCiclos;
    }

    public void setNumeroCiclos(Integer NumeroCiclos) {
        this.NumeroCiclos = NumeroCiclos;
    }

    public Integer getDuracion() {
        return Duracion;
    }

    public void setDuracion(Integer Duracion) {
        this.Duracion = Duracion;
    }

    public MallaCurricular getCarreraMalla() {
        return CarreraMalla;
    }

    public void setCarreraMalla(MallaCurricular CarreraMalla) {
        this.CarreraMalla = CarreraMalla;
    }

    public ListaDinamica<MallaCurricular> getListaMallaCarrera() {
        return listaMallaCarrera;
    }

    public void setListaMallaCarrera(ListaDinamica<MallaCurricular> listaMallaCarrera) {
        this.listaMallaCarrera = listaMallaCarrera;
    }

    public Facultad getFacutadCarrera() {
        return facutadCarrera;
    }

    public void setFacutadCarrera(Facultad facutadCarrera) {
        this.facutadCarrera = facutadCarrera;
    }

    @Override
    public String toString() {
        return NombreCarrera + "\n";
    }
    
}
