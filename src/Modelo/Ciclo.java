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
    private MallaCurricular mallaCiclo;

    public Ciclo() {
        
    }

    public Ciclo(Integer idCiclo, String NombreCiclo, MallaCurricular mallaCiclo) {
        this.idCiclo = idCiclo;
        this.NombreCiclo = NombreCiclo;
        this.mallaCiclo = mallaCiclo;
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

    public MallaCurricular getMallaCiclo() {
        return mallaCiclo;
    }

    public void setMallaCiclo(MallaCurricular mallaCiclo) {
        this.mallaCiclo = mallaCiclo;
    }
    
    @Override
    public String toString() {
        return NombreCiclo+"\n";
    }
    
}
