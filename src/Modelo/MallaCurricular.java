
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
    
    //Datos poco usados
    private Ciclo cicloMalla;
    private ListaDinamica<Ciclo> listaCicloMalla;
    
    public MallaCurricular() {
        
    }

//    public MallaCurricular(Integer IdMallaCurricular, String NombreMallaCurricular, Integer DuracionMallaCurricular, String EstadoMallaCurricular, Carrera carreraMallaCurricula) {
//        this.IdMallaCurricular = IdMallaCurricular;
//        this.NombreMallaCurricular = NombreMallaCurricular;
//        this.DuracionMallaCurricular = DuracionMallaCurricular;
//        this.EstadoMallaCurricular = EstadoMallaCurricular;
//        this.carreraMallaCurricula = carreraMallaCurricula;
//    }

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

    public Ciclo getCicloMalla() {
        return cicloMalla;
    }

    public void setCicloMalla(Ciclo cicloMalla) {
        this.cicloMalla = cicloMalla;
    }

    public ListaDinamica<Ciclo> getListaCicloMalla() {
        return listaCicloMalla;
    }

    public void setListaCicloMalla(ListaDinamica<Ciclo> listaCicloMalla) {
        this.listaCicloMalla = listaCicloMalla;
    }

    public Carrera getCarreraMallaCurricula() {
        return carreraMallaCurricula;
    }

    public void setCarreraMallaCurricula(Carrera carreraMallaCurricula) {
        this.carreraMallaCurricula = carreraMallaCurricula;
    }
    
    @Override
    public String toString() {
        return NombreMallaCurricular +  "\n";
    }
    
}
