/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Rol {
    private Integer idRol;
    private String nombreRol;
    private String DescripcionRol;

    public Rol() {
        
    }

    public Rol(Integer idRol, String nombreRol, String DescripcionRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.DescripcionRol = DescripcionRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcionRol() {
        return DescripcionRol;
    }

    public void setDescripcionRol(String DescripcionRol) {
        this.DescripcionRol = DescripcionRol;
    }

    @Override
    public String toString() {
        return "Rol{" + "idRol=" + idRol + ", nombreRol=" + nombreRol + ", DescripcionRol=" + DescripcionRol + '}';
    }
    
}
