/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Materia;

/**
 *
 * @author Victor
 */
public class ControladorMateria {
    private ListaDinamica<Materia> materias;
    
    public ControladorMateria() {
//        materias = new ListaDinamica<>();
//        materias.Agregar(new Materia(1, "Estructura de datos", "Materia principal"));
//        materias.Agregar(new Materia(2, "Base de datos", "Materia principal"));
//        materias.Agregar(new Materia(3, "Requisitos de software", "Materia principal"));
//        materias.Agregar(new Materia(4, "Arquitectura de ordenadores", "Materia principal"));
//        materias.Agregar(new Materia(5, "Relleno", "Materia principal"));
    }

    public ListaDinamica<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ListaDinamica<Materia> materias) {
        this.materias = materias;
    }
    
}
