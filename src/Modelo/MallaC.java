
package Modelo;

/**
 *
 * @author Victor
 */
public class MallaC {
    private Integer IdMallaC;
    private String NombreMC;
    private Integer DMC;
    private String EstadoMallaC;
    
    private Carrera carreraMallaCurricula;
    private Integer CarreraID;
    
    public MallaC() {
        
    }

    public Integer getIdMallaCurricular() {
        return IdMallaC;
    }

    public void setIdMallaCurricular(Integer IdMallaCurricular) {
        this.IdMallaC = IdMallaCurricular;
    }

    public String getNombreMallaCurricular() {
        return NombreMC;
    }

    public void setNombreMallaCurricular(String NombreMallaCurricular) {
        this.NombreMC = NombreMallaCurricular;
    }

    public Integer getDuracionMallaCurricular() {
        return DMC;
    }

    public void setDuracionMallaCurricular(Integer DuracionMallaCurricular) {
        this.DMC = DuracionMallaCurricular;
    }

    public String getEstadoMallaCurricular() {
        return EstadoMallaC;
    }

    public void setEstadoMallaCurricular(String EstadoMallaCurricular) {
        this.EstadoMallaC = EstadoMallaCurricular;
    }

    public Carrera getCarreraMallaCurricula() {
        return carreraMallaCurricula;
    }

    public void setCarreraMallaCurricula(Carrera carreraMallaCurricula) {
        this.carreraMallaCurricula = carreraMallaCurricula;
    }

    public Integer getCarreraID() {
        return CarreraID;
    }

    public void setCarreraID(Integer CarreraID) {
        this.CarreraID = CarreraID;
    }
    
    @Override
    public String toString() {
        return NombreMC +  "\n";
    }
    
}
