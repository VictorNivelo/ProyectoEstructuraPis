
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class MallaCurricular {
    private Integer IdMallaCurricular;
    private String NombreMallaCurricular;
    private Integer DuracionMallaCurricular;
    private String EstadoMallaCurricular;
    
    private Carrera carreraMallaCurricula;
    private ListaDinamica<Carrera> listaCarreraMallaCurricula;
    
    public MallaCurricular() {
        
    }

    public Integer getIdMallaCurricular() {
        return IdMallaCurricular;
    }

    public void setIdMallaCurricular(Integer IdMallaCurricular) {
        this.IdMallaCurricular = IdMallaCurricular;
    }

    public String getNombreMallaCurricular() {
        return NombreMallaCurricular;
    }

    public void setNombreMallaCurricular(String NombreMallaCurricular) {
        this.NombreMallaCurricular = NombreMallaCurricular;
    }

    public Integer getDuracionMallaCurricular() {
        return DuracionMallaCurricular;
    }

    public void setDuracionMallaCurricular(Integer DuracionMallaCurricular) {
        this.DuracionMallaCurricular = DuracionMallaCurricular;
    }

    public String getEstadoMallaCurricular() {
        return EstadoMallaCurricular;
    }

    public void setEstadoMallaCurricular(String EstadoMallaCurricular) {
        this.EstadoMallaCurricular = EstadoMallaCurricular;
    }

    public Carrera getCarreraMallaCurricula() {
        return carreraMallaCurricula;
    }

    public void setCarreraMallaCurricula(Carrera carreraMallaCurricula) {
        this.carreraMallaCurricula = carreraMallaCurricula;
    }

    public ListaDinamica<Carrera> getListaCarreraMallaCurricula() {
        return listaCarreraMallaCurricula;
    }

    public void setListaCarreraMallaCurricula(ListaDinamica<Carrera> listaCarreraMallaCurricula) {
        this.listaCarreraMallaCurricula = listaCarreraMallaCurricula;
    }
    
    @Override
    public String toString() {
        return NombreMallaCurricular +  "\n";
    }
    
}
