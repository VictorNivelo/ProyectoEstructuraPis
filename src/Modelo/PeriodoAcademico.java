
package Modelo;

/**
 *
 * @author Victor
 */
public class PeriodoAcademico {
    private Integer IdPA;
    private String FechaInicioPA;
    private String FechaFinPA;
    private String EstadoP;

    public PeriodoAcademico() {
        
    }

    public Integer getIdPeriodoAcademino() {
        return IdPA;
    }

    public void setIdPeriodoAcademino(Integer IdPeriodoAcademino) {
        this.IdPA = IdPeriodoAcademino;
    }

    public String getFechaInicio() {
        return FechaInicioPA;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicioPA = FechaInicio;
    }

    public String getFechaFin() {
        return FechaFinPA;
    }

    public void setFechaFin(String FechaFin) {
        this.FechaFinPA = FechaFin;
    }

    public String getEstadoPeriodoAcedemico() {
        return EstadoP;
    }

    public void setEstadoPeriodoAcedemico(String EstadoPeriodoAcedemico) {
        this.EstadoP = EstadoPeriodoAcedemico;
    }
    
    @Override
    public String toString() {
        return  FechaInicioPA + " - " + FechaFinPA + "\n";
    }
    
}
