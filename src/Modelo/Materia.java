/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class Materia {
    private Integer idMateria;
    private String NombreMateria;
    private String DescipcionMateria;
    private Horario HorarioMateria;
    private ListaDinamica<Horario> ListaHorarios;
    
    private Ciclo cicloMateria;

    public Materia() {
        
    }

    public Materia(Integer idMateria, String NombreMateria, String DescipcionMateria, Ciclo cicloMateria, Horario HorarioMateria) {
        this.idMateria = idMateria;
        this.NombreMateria = NombreMateria;
        this.DescipcionMateria = DescipcionMateria;
        this.cicloMateria = cicloMateria;
        this.HorarioMateria = HorarioMateria;
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

    public Horario getHorarioMateria() {
        return HorarioMateria;
    }

    public void setHorarioMateria(Horario HorarioMateria) {
        this.HorarioMateria = HorarioMateria;
    }
    
    public Boolean comparar(Materia m, String campo, Integer tipo) {
        switch (tipo) {
            case 0:
                return compararCampo(m, campo) < 0;
            case 1:
                return compararCampo(m, campo) > 0;
            default:
                throw new IllegalArgumentException("Tipo de comparación no válido");
        }
    }

    private int compararCampo(Materia m, String campo) {
        switch (campo.toLowerCase()) {
            case "nombre":
                return NombreMateria.compareTo(m.getNombreMateria());
            default:
                throw new IllegalArgumentException("Campo no válido para la comparación");
        }
    }
    
    @Override
    public String toString() {
        return NombreMateria+"\n";
    }
    
}
