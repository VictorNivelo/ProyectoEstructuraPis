
package Modelo;

/**
 *
 * @author Victor
 */
public class CodigoCurso {
    private Integer IdCodigoCurso;
    private String NombreCodigoCurso;

    public CodigoCurso() {
        
    }

    public Integer getIdCodigoCurso() {
        return IdCodigoCurso;
    }

    public void setIdCodigoCurso(Integer IdCodigoCurso) {
        this.IdCodigoCurso = IdCodigoCurso;
    }

    public String getNombreCodigoCurso() {
        return NombreCodigoCurso;
    }

    public void setNombreCodigoCurso(String NombreCodigoCurso) {
        this.NombreCodigoCurso = NombreCodigoCurso;
    }

    @Override
    public String toString() {
        return NombreCodigoCurso + "\n";
    }
    
}
