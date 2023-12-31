/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class PeriodoAcademico {
    private Integer idPeriodoAcademino;
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

    @Override
    public String toString() {
        return  fechaInicio + " - " + FechaFin + "\n";
    }
    
}
