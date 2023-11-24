/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Persona {
    private Integer idPersona;
    private String NumeroCedula;
    private String Nombre;
    private String Apellido;
    private String Telefono;

    public Persona() {
        
    }

    public Persona(Integer idPersona, String NumeroCedula, String Nombre, String Apellido, String Telefono) {
        this.idPersona = idPersona;
        this.NumeroCedula = NumeroCedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNumeroCedula() {
        return NumeroCedula;
    }

    public void setNumeroCedula(String NumeroCedula) {
        this.NumeroCedula = NumeroCedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", NumeroCedula=" + NumeroCedula + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Telefono=" + Telefono + '}';
    }
    
}
