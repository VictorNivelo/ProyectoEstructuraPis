
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class MallaCurricular {
    private Integer idMallaCurricular;
    private String NombreMallaCurricular;
    private Integer duracionMallaCurricular;
    private Ciclo MallaCiclo;
    private ListaDinamica<Ciclo> ListaCiclos;
    
    private Carrera carreraMalla;
    
    public MallaCurricular() {
        
    }

    public MallaCurricular(Integer idMallaCurricular, String NombreMallaCurricular, Integer duracionMallaCurricular, Carrera carreraMalla) {
        this.idMallaCurricular = idMallaCurricular;
        this.NombreMallaCurricular = NombreMallaCurricular;
        this.duracionMallaCurricular = duracionMallaCurricular;
        this.carreraMalla = carreraMalla;
    }

    public Integer getIdMallaCurricular() {
        return idMallaCurricular;
    }

    public void setIdMallaCurricular(Integer idMallaCurricular) {
        this.idMallaCurricular = idMallaCurricular;
    }

    public String getNombreMallaCurricular() {
        return NombreMallaCurricular;
    }

    public void setNombreMallaCurricular(String NombreMallaCurricular) {
        this.NombreMallaCurricular = NombreMallaCurricular;
    }

    public Integer getDuracionMallaCurricular() {
        return duracionMallaCurricular;
    }

    public void setDuracionMallaCurricular(Integer duracionMallaCurricular) {
        this.duracionMallaCurricular = duracionMallaCurricular;
    }

    public Carrera getCarreraMalla() {
        return carreraMalla;
    }

    public void setCarreraMalla(Carrera carreraMalla) {
        this.carreraMalla = carreraMalla;
    }

    public Ciclo getMallaCiclo() {
        return MallaCiclo;
    }

    public void setMallaCiclo(Ciclo MallaCiclo) {
        this.MallaCiclo = MallaCiclo;
    }

    public ListaDinamica<Ciclo> getListaCiclos() {
        return ListaCiclos;
    }

    public void setListaCiclos(ListaDinamica<Ciclo> ListaCiclos) {
        this.ListaCiclos = ListaCiclos;
    }
    
    @Override
    public String toString() {
        return NombreMallaCurricular +  "\n";
    }
    
}
