
package Modelo;

/**
 *
 * @author Victor
 */
public class Asistencia {
    private Integer IdAsistencia;
    private EstadoAsistencia EstadoAsistencia;
    private String Observacion;
    
    private Tematica AsistenciaTematica;
    
    public Asistencia() {
        
    }

    public Asistencia(Integer IdAsistencia, EstadoAsistencia EstadoAsistencia, String Observacion, Tematica AsistenciaTematica) {
        this.IdAsistencia = IdAsistencia;
        this.EstadoAsistencia = EstadoAsistencia;
        this.Observacion = Observacion;
        this.AsistenciaTematica = AsistenciaTematica;
    }
    
    public Integer getIdAsistencia() {
        return IdAsistencia;
    }

    public void setIdAsistencia(Integer IdAsistencia) {
        this.IdAsistencia = IdAsistencia;
    }

    public EstadoAsistencia getEstadoAsistencia() {
        return EstadoAsistencia;
    }

    public void setEstadoAsistencia(EstadoAsistencia EstadoAsistencia) {
        this.EstadoAsistencia = EstadoAsistencia;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public Tematica getAsistenciaTematica() {
        return AsistenciaTematica;
    }

    public void setAsistenciaTematica(Tematica AsistenciaTematica) {
        this.AsistenciaTematica = AsistenciaTematica;
    }

    @Override
    public String toString() {
        return "Estado: "+EstadoAsistencia+"Observacion:" + Observacion + "\n";
    }
                
}
