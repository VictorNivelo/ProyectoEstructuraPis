/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Victor
 */
public class Tematica {
    private Integer idTematica;
    private String NombreTematica;
    private Date FechaTematica;
    private String DiaTematica;

    public Tematica() {
        
    }

    public Tematica(Integer idTematica, String DiaTematica, String NombreTematica) {
        this.idTematica = idTematica;
        this.DiaTematica = DiaTematica;
        this.NombreTematica = NombreTematica;
    }

    public Integer getIdTematica() {
        return idTematica;
    }

    public void setIdTematica(Integer idTematica) {
        this.idTematica = idTematica;
    }

    public String getDiaTematica() {
        return DiaTematica;
    }

    public void setDiaTematica(String DiaTematica) {
        this.DiaTematica = DiaTematica;
    }

    public String getNombreTematica() {
        return NombreTematica;
    }

    public void setNombreTematica(String NombreTematica) {
        this.NombreTematica = NombreTematica;
    }

    @Override
    public String toString() {
        return "idTematica=" + idTematica + ", DiaTematica=" + DiaTematica + ", NombreTematica=" + NombreTematica + "\n";
    }
     
}
