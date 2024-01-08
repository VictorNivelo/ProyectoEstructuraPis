/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.TDA.Pilas;

import Controlador.TDA.ListaDinamica.Exepciones.ListaVacia;
import Controlador.TDA.Pilas.Excepcion.FullStackException;

/**
 *
 * @author Victor
 * @param <E>
 */
public class StackUltimate<E> {
    private Stack<E> stack;

    public StackUltimate(Integer legngt) {
        this.stack = new Stack<>(legngt);
    }
    
    public void push(E info) throws ListaVacia, FullStackException{
        stack.push(info);
    }
    
    public E pop() throws ListaVacia{
        return stack.pop();
    }
    
    public Integer length(){
        return stack.getLongitud();
    }
    
    public Boolean isfull(){
        return stack.isFull();
    }
    
    public void print(){
        System.out.println("Stack");
        System.out.println(stack.toString());
        System.out.println("");
    }
}
