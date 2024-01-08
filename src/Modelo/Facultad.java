/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Facultad {
    private Integer idFacultad;
    private String nombreFacultad;
    private String decano;
    private String ubicacionFacultad;

    public Facultad() {
        
    }

    public Facultad(Integer idFacultad, String nombreFacultad, String decano, String ubicacionFacultad) {
        this.idFacultad = idFacultad;
        this.nombreFacultad = nombreFacultad;
        this.decano = decano;
        this.ubicacionFacultad = ubicacionFacultad;
    }

    public Integer getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Integer idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }

    public String getDecano() {
        return decano;
    }

    public void setDecano(String decano) {
        this.decano = decano;
    }

    public String getUbicacionFacultad() {
        return ubicacionFacultad;
    }

    public void setUbicacionFacultad(String ubicacionFacultad) {
        this.ubicacionFacultad = ubicacionFacultad;
    }

    @Override
    public String toString() {
        return  "idFacultad=" + idFacultad + ", nombreFacultad=" + nombreFacultad + ", decano=" + decano + ", ubicacionFacultad=" + ubicacionFacultad + "\n";
    }
    
}
