/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Ciclo {
    private Integer idCiclo;
    private String NombreCiclo;
    private Integer NumeroCiclo;
    private String NombreParalelo;

    public Ciclo() {
        
    }

    public Ciclo(Integer idCiclo, String NombreCiclo, Integer NumeroCiclo, String NombreParalelo) {
        this.idCiclo = idCiclo;
        this.NombreCiclo = NombreCiclo;
        this.NumeroCiclo = NumeroCiclo;
        this.NombreParalelo = NombreParalelo;
    }

    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getNombreCiclo() {
        return NombreCiclo;
    }

    public void setNombreCiclo(String NombreCiclo) {
        this.NombreCiclo = NombreCiclo;
    }

    public Integer getNumeroCiclo() {
        return NumeroCiclo;
    }

    public void setNumeroCiclo(Integer NumeroCiclo) {
        this.NumeroCiclo = NumeroCiclo;
    }

    public String getNombreParalelo() {
        return NombreParalelo;
    }

    public void setNombreParalelo(String NombreParalelo) {
        this.NombreParalelo = NombreParalelo;
    }

    @Override
    public String toString() {
        return NombreCiclo +" "+ NombreParalelo;
    }
    
}
