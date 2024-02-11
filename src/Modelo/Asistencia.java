
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class Asistencia {
    private Integer IdAsistencia;
    private EstadoAsistencia EstadoAsistencia;
    private String Observacion;
    
    private Horario horarioAsistencia;
    private ListaDinamica<Horario> listaHorarioAsistencia;
    
    private Tematica AsistenciaTematica;
    private ListaDinamica<Tematica> listaTematicaAsistencia;
    
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

    public ListaDinamica<Horario> getListaHorarioAsistencia() {
        return listaHorarioAsistencia;
    }

    public void setListaHorarioAsistencia(ListaDinamica<Horario> listaHorarioAsistencia) {
        this.listaHorarioAsistencia = listaHorarioAsistencia;
    }

    public ListaDinamica<Tematica> getListaTematicaAsistencia() {
        return listaTematicaAsistencia;
    }

    public void setListaTematicaAsistencia(ListaDinamica<Tematica> listaTematicaAsistencia) {
        this.listaTematicaAsistencia = listaTematicaAsistencia;
    }

    @Override
    public String toString() {
        return "Estado: "+EstadoAsistencia+"Observacion:" + Observacion + "\n";
    }
                
}
