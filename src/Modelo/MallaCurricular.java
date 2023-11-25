/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class MallaCurricular {
    private Integer idMallaCurricular;
    private String NombreMallaCurricular;
    private Integer duracionMallaCurricular;

    public MallaCurricular() {
        
    }

    public MallaCurricular(Integer idMallaCurricular, String NombreMallaCurricular, Integer duracionMallaCurricular) {
        this.idMallaCurricular = idMallaCurricular;
        this.NombreMallaCurricular = NombreMallaCurricular;
        this.duracionMallaCurricular = duracionMallaCurricular;
    }

    public Integer getIdMallaCurricular() {
        return idMallaCurricular;
    }

    public void setIdMallaCurricular(Integer idMallaCurricular) {
        this.idMallaCurricular = idMallaCurricular;
    }

    public String getNombreMallaCurricular() {
        return NombreMallaCurricular;
    }

    public void setNombreMallaCurricular(String NombreMallaCurricular) {
        this.NombreMallaCurricular = NombreMallaCurricular;
    }

    public Integer getDuracionMallaCurricular() {
        return duracionMallaCurricular;
    }

    public void setDuracionMallaCurricular(Integer duracionMallaCurricular) {
        this.duracionMallaCurricular = duracionMallaCurricular;
    }

    @Override
    public String toString() {
        return "MallaCurricular{" + "idMallaCurricular=" + idMallaCurricular + ", NombreMallaCurricular=" + NombreMallaCurricular + ", duracionMallaCurricular=" + duracionMallaCurricular + '}';
    }
    
}
