
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class Ciclo {
    private Integer idCiclo;
    private String NombreCiclo;
    private Integer NumeroCiclo;
    private Materia CicloMateria;
    private ListaDinamica<Materia> ListaMaterias;
    
    private MallaCurricular mallaCiclo;

    public Ciclo() {
        
    }

    public Ciclo(Integer idCiclo, String NombreCiclo, MallaCurricular mallaCiclo) {
        this.idCiclo = idCiclo;
        this.NombreCiclo = NombreCiclo;
        this.mallaCiclo = mallaCiclo;
    }

    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getNombreCiclo() {
        return NombreCiclo;
    }

    public void setNombreCiclo(String NombreCiclo) {
        this.NombreCiclo = NombreCiclo;
    }

    public MallaCurricular getMallaCiclo() {
        return mallaCiclo;
    }

    public void setMallaCiclo(MallaCurricular mallaCiclo) {
        this.mallaCiclo = mallaCiclo;
    }

    public Integer getNumeroCiclo() {
        return NumeroCiclo;
    }

    public void setNumeroCiclo(Integer NumeroCiclo) {
        this.NumeroCiclo = NumeroCiclo;
    }

    public Materia getCicloMateria() {
        return CicloMateria;
    }

    public void setCicloMateria(Materia CicloMateria) {
        this.CicloMateria = CicloMateria;
    }

    public ListaDinamica<Materia> getListaMaterias() {
        return ListaMaterias;
    }

    public void setListaMaterias(ListaDinamica<Materia> ListaMaterias) {
        this.ListaMaterias = ListaMaterias;
    }
    
    @Override
    public String toString() {
        return NombreCiclo+"\n";
    }
    
}
