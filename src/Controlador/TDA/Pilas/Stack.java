/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.TDA.Pilas;

import Controlador.TDA.ListaDinamica.Exepciones.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.TDA.Pilas.Excepcion.FullStackException;
/**
 *
 * @author Victor
 */
class Stack<E> extends ListaDinamica<E>{
    private Integer tope;

    public Stack(Integer Tope) {
        this.tope = Tope;
    }
    
    public Boolean isFull(){
        return getLongitud().intValue() >= tope.intValue();
    }
    
    public void push(E info) throws ListaVacia, FullStackException{
        if(isFull()){
            throw new FullStackException("Pilas llena");
//            error
        }
        else{
            Agregar(info, 0);
        }
    }
    
    public E pop() throws ListaVacia{
        E info = extractFirst();        
        return info;
    }
}
