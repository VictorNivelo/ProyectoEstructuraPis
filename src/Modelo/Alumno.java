/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Alumno {
    private Integer idAlumno;
    private Persona datosAlumno;
    private Boolean estado;
    private Matricula matriculaAlumno;

    public Alumno() {
        
    }

    public Alumno(Integer idAlumno, Persona datosAlumno, Boolean estado, Matricula matriculaAlumno) {
        this.idAlumno = idAlumno;
        this.datosAlumno = datosAlumno;
        this.estado = estado;
        this.matriculaAlumno = matriculaAlumno;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Persona getDatosAlumno() {
        return datosAlumno;
    }

    public void setDatosAlumno(Persona datosAlumno) {
        this.datosAlumno = datosAlumno;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Matricula getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public void setMatriculaAlumno(Matricula matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", datosAlumno=" + datosAlumno + ", estado=" + estado + ", matriculaAlumno=" + matriculaAlumno + '}';
    }
    
}
