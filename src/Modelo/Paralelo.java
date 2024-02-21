
package Modelo;

/**
 *
 * @author Victor
 */
public class Paralelo {
    private Integer IdParalelo;
    private String CodigoP;
    private String NombreP;

    public Paralelo() {
        
    }

    public Integer getIdParalelo() {
        return IdParalelo;
    }

    public void setIdParalelo(Integer IdParalelo) {
        this.IdParalelo = IdParalelo;
    }

    public String getNombre() {
        return NombreP;
    }

    public void setNombre(String Nombre) {
        this.NombreP = Nombre;
    }

    public String getCodigoParalelo() {
        return CodigoP;
    }

    public void setCodigoParalelo(String CodigoParalelo) {
        this.CodigoP = CodigoParalelo;
    }

    @Override
    public String toString() {
        return NombreP + "\n";
    }
    
}
