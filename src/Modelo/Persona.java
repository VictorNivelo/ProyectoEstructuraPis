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
    private String Genero;
    private String FechaNacimineto;
    private String direccion;
    private String Telefono;
    private Rol rolPersona;
    private Cuenta cuentaPersona;

    public Persona() {
        
    }

    public Persona(Integer idPersona, String NumeroCedula, String Nombre, String Apellido, String Genero, String FechaNacimineto, String direccion, String Telefono, Rol rolPersona, Cuenta cuentaPersona) {
        this.idPersona = idPersona;
        this.NumeroCedula = NumeroCedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Genero = Genero;
        this.FechaNacimineto = FechaNacimineto;
        this.direccion = direccion;
        this.Telefono = Telefono;
        this.rolPersona = rolPersona;
        this.cuentaPersona = cuentaPersona;
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

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getFechaNacimineto() {
        return FechaNacimineto;
    }

    public void setFechaNacimineto(String FechaNacimineto) {
        this.FechaNacimineto = FechaNacimineto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public Rol getRolPersona() {
        return rolPersona;
    }

    public void setRolPersona(Rol rolPersona) {
        this.rolPersona = rolPersona;
    }

    public Cuenta getCuentaPersona() {
        return cuentaPersona;
    }

    public void setCuentaPersona(Cuenta cuentaPersona) {
        this.cuentaPersona = cuentaPersona;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", NumeroCedula=" + NumeroCedula + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Genero=" + Genero + ", FechaNacimineto=" + FechaNacimineto + ", direccion=" + direccion + ", Telefono=" + Telefono + ", rolPersona=" + rolPersona + ", cuentaPersona=" + cuentaPersona + '}';
    }
    
}
