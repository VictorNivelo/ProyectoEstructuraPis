/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Cuenta {
    private Integer idCuenta;
    private String Correo;
    private String Contrasena;
    private Boolean EstadoCuenta;

    public Cuenta() {
        
    }

    public Cuenta(Integer idCuenta, String Correo, String Contrasena, Boolean EstadoCuenta) {
        this.idCuenta = idCuenta;
        this.Correo = Correo;
        this.Contrasena = Contrasena;
        this.EstadoCuenta = EstadoCuenta;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public Boolean getEstadoCuenta() {
        return EstadoCuenta;
    }

    public void setEstadoCuenta(Boolean EstadoCuenta) {
        this.EstadoCuenta = EstadoCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "idCuenta=" + idCuenta + ", Correo=" + Correo + ", Contrasena=" + Contrasena + ", EstadoCuenta=" + EstadoCuenta + '}';
    }
    
}
