/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Ciclo;

/**
 *
 * @author Victor
 */
public class ControladorCiclo {
    private ListaDinamica<Ciclo> ciclo;
    
    public ControladorCiclo() {
        
    }

    public ListaDinamica<Ciclo> getCiclo() {
        return ciclo;
    }

    public void setCiclo(ListaDinamica<Ciclo> ciclo) {
        this.ciclo = ciclo;
    }
    
}
