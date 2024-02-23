
package Modelo;

/**
 *
 * @author Victor
 */
public class Asistencia {
    private Integer IdAsistencia;
    private String Observacion;
    private String EstadoAsistencia;
    
    private Horario horarioAsistencia;
    private Integer IdH;
    
    private Alumno alumnoAsistencia;
    private Integer AlumnoID;
    
    private Tematica TematicaAsistencia;
    private Integer TematicaID;
    
    public Asistencia() {
        
    }

    public Integer getIdAsistencia() {
        return IdAsistencia;
    }

    public void setIdAsistencia(Integer IdAsistencia) {
        this.IdAsistencia = IdAsistencia;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public String getEstadoAsistencia() {
        return EstadoAsistencia;
    }

    public void setEstadoAsistencia(String EstadoAsistencia) {
        this.EstadoAsistencia = EstadoAsistencia;
    }

    public Horario getHorarioAsistencia() {
        return horarioAsistencia;
    }

    public void setHorarioAsistencia(Horario horarioAsistencia) {
        this.horarioAsistencia = horarioAsistencia;
    }

    public Integer getHorarioID() {
        return IdH;
    }

    public void setHorarioID(Integer HorarioID) {
        this.IdH = HorarioID;
    }

    public Tematica getTematicaAsistencia() {
        return TematicaAsistencia;
    }

    public void setTematicaAsistencia(Tematica TematicaAsistencia) {
        this.TematicaAsistencia = TematicaAsistencia;
    }

    public Integer getTematicaID() {
        return TematicaID;
    }

    public void setTematicaID(Integer TematicaID) {
        this.TematicaID = TematicaID;
    }

    public Alumno getAlumnoAsistencia() {
        return alumnoAsistencia;
    }

    public void setAlumnoAsistencia(Alumno alumnoAsistencia) {
        this.alumnoAsistencia = alumnoAsistencia;
    }

    public Integer getAlumnoID() {
        return AlumnoID;
    }

    public void setAlumnoID(Integer AlumnoID) {
        this.AlumnoID = AlumnoID;
    }
    
    @Override
    public String toString() {
        return "Estado: "+EstadoAsistencia+"Observacion:" + Observacion + "\n";
    }
                
}
