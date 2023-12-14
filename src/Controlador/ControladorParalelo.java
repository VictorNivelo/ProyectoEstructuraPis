/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Paralelo;

/**
 *
 * @author Victor
 */
public class ControladorParalelo {
    private ListaDinamica<Paralelo> Paralelos;
    
    public ControladorParalelo() {
        Paralelos = new ListaDinamica<>();
        Paralelos.Agregar(new Paralelo(1, "A"));
        Paralelos.Agregar(new Paralelo(2, "B"));
        Paralelos.Agregar(new Paralelo(3, "C"));
        Paralelos.Agregar(new Paralelo(4, "D"));
    }

    public ListaDinamica<Paralelo> getParalelos() {
        return Paralelos;
    }

    public void setParalelos(ListaDinamica<Paralelo> Paralelos) {
        this.Paralelos = Paralelos;
    }
    
}
