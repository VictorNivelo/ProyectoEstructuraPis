/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Carrera {
    private Integer idCarrera;
    private String NombreCarrera;
    private Integer duracion;

    public Carrera() {
        
    }

    public Carrera(Integer idCarrera, String NombreCarrera, Integer duracion) {
        this.idCarrera = idCarrera;
        this.NombreCarrera = NombreCarrera;
        this.duracion = duracion;
    }

    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return NombreCarrera;
    }

    public void setNombreCarrera(String NombreCarrera) {
        this.NombreCarrera = NombreCarrera;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Carrera{" + "idCarrera=" + idCarrera + ", NombreCarrera=" + NombreCarrera + ", duracion=" + duracion + '}';
    }
    
}
