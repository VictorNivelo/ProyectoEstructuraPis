
package Modelo;


/**
 *
 * @author Victor
 */
public class Materia {
    private Integer IdMateria;
    private String NombreM;
    private String DescripcionM;
    private String NumeroHM;
    
    private Ciclo cicloMateria;
    private Integer CicloID;
    
    public Materia() {
        
    }

    public Integer getIdMateria() {
        return IdMateria;
    }

    public void setIdMateria(Integer IdMateria) {
        this.IdMateria = IdMateria;
    }

    public String getNombreMateria() {
        return NombreM;
    }

    public void setNombreMateria(String NombreMateria) {
        this.NombreM = NombreMateria;
    }

    public String getDescipcionMateria() {
        return DescripcionM;
    }

    public void setDescipcionMateria(String DescipcionMateria) {
        this.DescripcionM = DescipcionMateria;
    }

    public String getNumeroHoras() {
        return NumeroHM;
    }

    public void setNumeroHoras(String NumeroHoras) {
        this.NumeroHM = NumeroHoras;
    }

    public Ciclo getCicloMateria() {
        return cicloMateria;
    }

    public void setCicloMateria(Ciclo cicloMateria) {
        this.cicloMateria = cicloMateria;
    }

    public Integer getCicloID() {
        return CicloID;
    }

    public void setCicloID(Integer CicloID) {
        this.CicloID = CicloID;
    }
    
    @Override
    public String toString() {
        return NombreM+"\n";
    }
    
}
