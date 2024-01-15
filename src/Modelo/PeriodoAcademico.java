
package Modelo;

import java.util.Date;

/**
 *
 * @author Victor
 */
public class PeriodoAcademico {
    private Integer idPeriodoAcademino;
    private Date FechaInicioP;
    private Date FechaFinP;
    
    private String fechaInicio;
    private String FechaFin;

    public PeriodoAcademico() {
        
    }

    public PeriodoAcademico(Integer idPeriodoAcademino, String fechaInicio, String FechaFin) {
        this.idPeriodoAcademino = idPeriodoAcademino;
        this.fechaInicio = fechaInicio;
        this.FechaFin = FechaFin;
    }

    public Integer getIdPeriodoAcademino() {
        return idPeriodoAcademino;
    }

    public void setIdPeriodoAcademino(Integer idPeriodoAcademino) {
        this.idPeriodoAcademino = idPeriodoAcademino;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String FechaFin) {
        this.FechaFin = FechaFin;
    }

    public Date getFechaInicioP() {
        return FechaInicioP;
    }

    public void setFechaInicioP(Date FechaInicioP) {
        this.FechaInicioP = FechaInicioP;
    }

    public Date getFechaFinP() {
        return FechaFinP;
    }

    public void setFechaFinP(Date FechaFinP) {
        this.FechaFinP = FechaFinP;
    }

    @Override
    public String toString() {
        return  fechaInicio + " - " + FechaFin + "\n";
    }
    
}
