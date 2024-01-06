/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.TDA.Colas;

import Controlador.TDA.ListaDinamica.Exepciones.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.TDA.Pilas.Excepcion.FullStackException;
/**
 *
 * @author Victor
 */
class Queue<E> extends ListaDinamica<E>{
    private Integer cima;

    public Queue(Integer Cima) {
        this.cima = Cima;
    }
    
    public Boolean isFull(){
        return getLongitud().intValue() >= cima.intValue();
    }
    
    public void queue(E info) throws ListaVacia, FullStackException{
        if(isFull()){
            throw new FullStackException("Cola llena");
//            error
        }
        else{
            Agregar(info);
        }
    }
    
    public E dequeue() throws ListaVacia{
        E info = extractFirst();        
        return info;
    }
}
