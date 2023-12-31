/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Docente {
    private Integer idDocente;
    private Persona datosDocente;
    private String especialidad;
    private String titulacion;
    private Cursa cursoAsignado;

    public Docente() {
        
    }

    public Docente(Integer idDocente, Persona datosDocente, String especialidad, String titulacion, Cursa cursoAsignado) {
        this.idDocente = idDocente;
        this.datosDocente = datosDocente;
        this.especialidad = especialidad;
        this.titulacion = titulacion;
        this.cursoAsignado = cursoAsignado;
    }
    
    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public Persona getDatosDocente() {
        return datosDocente;
    }

    public void setDatosDocente(Persona datosDocente) {
        this.datosDocente = datosDocente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Cursa getCursoAsignado() {
        return cursoAsignado;
    }

    public void setCursoAsignado(Cursa cursoAsignado) {
        this.cursoAsignado = cursoAsignado;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    @Override
    public String toString() {
        return "idDocente=" + idDocente + ", datosDocente=" + datosDocente + ", especialidad=" + especialidad + ", cursoAsignado=" + cursoAsignado + ", titulacion=" + titulacion + "\n";
    }
    
}
