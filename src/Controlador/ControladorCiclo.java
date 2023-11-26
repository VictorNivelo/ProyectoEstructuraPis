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
        ciclo = new ListaDinamica<>();
        ciclo.Agregar(new Ciclo(1, "Administrador", 1));
        ciclo.Agregar(new Ciclo(2, "Personal administrativo", 2));
        ciclo.Agregar(new Ciclo(3, "Docente", 3));
        ciclo.Agregar(new Ciclo(4, "Estrudiante", 4));
    }

    public ListaDinamica<Ciclo> getCiclo() {
        return ciclo;
    }

    public void setCiclo(ListaDinamica<Ciclo> ciclo) {
        this.ciclo = ciclo;
    }
    
}
