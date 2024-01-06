/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Universidad {
    private Integer idUniversidad;
    private String NimbreUniversidad;
    private Integer amioFundacion;
    private String Ubicacion;
    private String Correo;
    private String NumeroTelefonico;

    public Universidad() {
        
    }

    public Universidad(Integer idUniversidad, String NimbreUniversidad, Integer amioFundacion, String Ubicacion, String Correo, String NumeroTelefonico) {
        this.idUniversidad = idUniversidad;
        this.NimbreUniversidad = NimbreUniversidad;
        this.amioFundacion = amioFundacion;
        this.Ubicacion = Ubicacion;
        this.Correo = Correo;
        this.NumeroTelefonico = NumeroTelefonico;
    }

    public Integer getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(Integer idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    public String getNimbreUniversidad() {
        return NimbreUniversidad;
    }

    public void setNimbreUniversidad(String NimbreUniversidad) {
        this.NimbreUniversidad = NimbreUniversidad;
    }

    public Integer getAmioFundacion() {
        return amioFundacion;
    }

    public void setAmioFundacion(Integer amioFundacion) {
        this.amioFundacion = amioFundacion;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getNumeroTelefonico() {
        return NumeroTelefonico;
    }

    public void setNumeroTelefonico(String NumeroTelefonico) {
        this.NumeroTelefonico = NumeroTelefonico;
    }

    @Override
    public String toString() {
        return "idUniversidad=" + idUniversidad + ", NimbreUniversidad=" + NimbreUniversidad + ", amioFundacion=" + amioFundacion + ", Ubicacion=" + Ubicacion + ", Correo=" + Correo + ", NumeroTelefonico=" + NumeroTelefonico + "\n";
    }
    
}
