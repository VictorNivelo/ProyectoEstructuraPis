/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Paralelo {
    private Integer idParaleli;
    private String NombreParalelo;

    public Paralelo() {
        
    }

    public Paralelo(Integer idParaleli, String NombreParalelo) {
        this.idParaleli = idParaleli;
        this.NombreParalelo = NombreParalelo;
    }

    public Integer getIdParaleli() {
        return idParaleli;
    }

    public void setIdParaleli(Integer idParaleli) {
        this.idParaleli = idParaleli;
    }

    public String getNombreParalelo() {
        return NombreParalelo;
    }

    public void setNombreParalelo(String NombreParalelo) {
        this.NombreParalelo = NombreParalelo;
    }

    @Override
    public String toString() {
        return NombreParalelo;
    }
    
    
}
