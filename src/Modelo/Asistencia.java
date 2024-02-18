
package Modelo;

/**
 *
 * @author Victor
 */
public class Asistencia {
    private Integer IdAsistencia;
    private String Observacion;
    
    private EstadoAsistencia EstadoAsistencia;
    private Integer EstadoAsistenciaID;
    
    private Horario horarioAsistencia;
    private Integer HorarioID;
    
    private Tematica AsistenciaTematica;
    private Integer AsistenciaID;
    
    public Asistencia() {
        
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

    public Horario getHorarioAsistencia() {
        return horarioAsistencia;
    }

    public void setHorarioAsistencia(Horario horarioAsistencia) {
        this.horarioAsistencia = horarioAsistencia;
    }

    public Integer getEstadoAsistenciaID() {
        return EstadoAsistenciaID;
    }

    public void setEstadoAsistenciaID(Integer EstadoAsistenciaID) {
        this.EstadoAsistenciaID = EstadoAsistenciaID;
    }

    public Integer getHorarioID() {
        return HorarioID;
    }

    public void setHorarioID(Integer HorarioID) {
        this.HorarioID = HorarioID;
    }

    public Integer getAsistenciaID() {
        return AsistenciaID;
    }

    public void setAsistenciaID(Integer AsistenciaID) {
        this.AsistenciaID = AsistenciaID;
    }

    @Override
    public String toString() {
        return "Estado: "+EstadoAsistencia+"Observacion:" + Observacion + "\n";
    }
                
}
