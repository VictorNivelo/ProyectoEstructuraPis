/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Asistencia {
    private Integer idAsistencia;
    private EstadoAsistencia estadoAsistencia;
    private String Observacion;
    private Tematica AsistenciaTematica;
    
    private String DiaAsistencia;
    private String HoraAsistencia;
    
    private Horario HorarioAsistencia;

    public Asistencia() {
        
    }

    public Asistencia(Integer idAsistencia, String DiaAsistencia, String HoraAsistencia, EstadoAsistencia estadoAsistencia, String Observacion, Horario HorarioAsistencia) {
        this.idAsistencia = idAsistencia;
        this.DiaAsistencia = DiaAsistencia;
        this.HoraAsistencia = HoraAsistencia;
        this.estadoAsistencia = estadoAsistencia;
        this.Observacion = Observacion;
        this.HorarioAsistencia = HorarioAsistencia;
    }

    public Integer getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(Integer idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public String getDiaAsistencia() {
        return DiaAsistencia;
    }

    public void setDiaAsistencia(String DiaAsistencia) {
        this.DiaAsistencia = DiaAsistencia;
    }

    public String getHoraAsistencia() {
        return HoraAsistencia;
    }

    public void setHoraAsistencia(String HoraAsistencia) {
        this.HoraAsistencia = HoraAsistencia;
    }

    public EstadoAsistencia getEstadoAsistencia() {
        return estadoAsistencia;
    }

    public void setEstadoAsistencia(EstadoAsistencia estadoAsistencia) {
        this.estadoAsistencia = estadoAsistencia;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public Horario getHorarioAsistencia() {
        return HorarioAsistencia;
    }

    public void setHorarioAsistencia(Horario HorarioAsistencia) {
        this.HorarioAsistencia = HorarioAsistencia;
    }
    
    @Override
    public String toString() {
        return "Dia:" + DiaAsistencia + ", Hora:" + HoraAsistencia  + "\n";
    }
                
}
