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
    private String DiaAsistencia;
    private Cursa asistenciaCurso;
    private Boolean EstadoAsistencia;

    public Asistencia() {
        
    }

    public Asistencia(Integer idAsistencia, String DiaAsistencia, Cursa asistenciaCurso, Boolean EstadoAsistencia) {
        this.idAsistencia = idAsistencia;
        this.DiaAsistencia = DiaAsistencia;
        this.asistenciaCurso = asistenciaCurso;
        this.EstadoAsistencia = EstadoAsistencia;
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

    public Cursa getAsistenciaCurso() {
        return asistenciaCurso;
    }

    public void setAsistenciaCurso(Cursa asistenciaCurso) {
        this.asistenciaCurso = asistenciaCurso;
    }

    public Boolean getEstadoAsistencia() {
        return EstadoAsistencia;
    }

    public void setEstadoAsistencia(Boolean EstadoAsistencia) {
        this.EstadoAsistencia = EstadoAsistencia;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "idAsistencia=" + idAsistencia + ", DiaAsistencia=" + DiaAsistencia + ", asistenciaCurso=" + asistenciaCurso + ", EstadoAsistencia=" + EstadoAsistencia + '}';
    }
    
    
}
