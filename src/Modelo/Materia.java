
package Modelo;

/**
 *
 * @author Victor
 */
public class Materia {
    private Integer idMateria;
    private String NombreMateria;
    private String DescipcionMateria;

    public Materia() {
        
    }

    public Materia(Integer idMateria, String NombreMateria, String DescipcionMateria) {
        this.idMateria = idMateria;
        this.NombreMateria = NombreMateria;
        this.DescipcionMateria = DescipcionMateria;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return NombreMateria;
    }

    public void setNombreMateria(String NombreMateria) {
        this.NombreMateria = NombreMateria;
    }

    public String getDescipcionMateria() {
        return DescipcionMateria;
    }

    public void setDescipcionMateria(String DescipcionMateria) {
        this.DescipcionMateria = DescipcionMateria;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", NombreMateria=" + NombreMateria + ", DescipcionMateria=" + DescipcionMateria + '}';
    }
    
}
