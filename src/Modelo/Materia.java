/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Materia {
    private Integer idMateria;
    private String NombreMateria;
    private String DescipcionMateria;
    private Ciclo cicloMateria;

    public Materia() {
        
    }

    public Materia(Integer idMateria, String NombreMateria, String DescipcionMateria, Ciclo cicloMateria) {
        this.idMateria = idMateria;
        this.NombreMateria = NombreMateria;
        this.DescipcionMateria = DescipcionMateria;
        this.cicloMateria = cicloMateria;
    }
    
    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return NombreMateria;
    }

    public void setNombreMateria(String NombreMateria) {
        this.NombreMateria = NombreMateria;
    }

    public String getDescipcionMateria() {
        return DescipcionMateria;
    }

    public void setDescipcionMateria(String DescipcionMateria) {
        this.DescipcionMateria = DescipcionMateria;
    }

    public Ciclo getCicloMateria() {
        return cicloMateria;
    }

    public void setCicloMateria(Ciclo cicloMateria) {
        this.cicloMateria = cicloMateria;
    }
    
    @Override
    public String toString() {
        return NombreMateria;
    }
    
}
