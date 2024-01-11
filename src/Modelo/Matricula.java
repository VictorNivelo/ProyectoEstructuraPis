/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Matricula {
    private Integer idMatricula;
    private String fechaMatricula;
    private Boolean EstadoMatricula;
    private PeriodoAcademico matriculaPeriodoAcademico;
    private Cursa matriculaCursa;

    public Matricula() {
        
    }

    public Matricula(Integer idMatricula, String fechaMatricula, Boolean EstadoMatricula, PeriodoAcademico matriculaPeriodoAcademico, Cursa matriculaCursa) {
        this.idMatricula = idMatricula;
        this.fechaMatricula = fechaMatricula;
        this.EstadoMatricula = EstadoMatricula;
        this.matriculaPeriodoAcademico = matriculaPeriodoAcademico;
        this.matriculaCursa = matriculaCursa;
    }

    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(String fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public Boolean getEstadoMatricula() {
        return EstadoMatricula;
    }

    public void setEstadoMatricula(Boolean EstadoMatricula) {
        this.EstadoMatricula = EstadoMatricula;
    }

    public PeriodoAcademico getMatriculaPeriodoAcademico() {
        return matriculaPeriodoAcademico;
    }

    public void setMatriculaPeriodoAcademico(PeriodoAcademico matriculaPeriodoAcademico) {
        this.matriculaPeriodoAcademico = matriculaPeriodoAcademico;
    }

    public Cursa getMatriculaCursa() {
        return matriculaCursa;
    }

    public void setMatriculaCursa(Cursa matriculaCursa) {
        this.matriculaCursa = matriculaCursa;
    }

    @Override
    public String toString() {
        return "Fecha:" + fechaMatricula + "\n";
    }
    
}
