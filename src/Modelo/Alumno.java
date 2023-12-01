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

    public Alumno() {
        
    }

    public Alumno(Integer idAlumno, Persona datosAlumno, Boolean estado) {
        this.idAlumno = idAlumno;
        this.datosAlumno = datosAlumno;
        this.estado = estado;
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
    
}
