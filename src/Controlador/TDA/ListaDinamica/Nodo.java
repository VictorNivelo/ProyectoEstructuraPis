/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.TDA.ListaDinamica;

/**
 *
 * @author Victor
 * @param <E>
 */
public class Nodo<E> {

    private E info;
    private Nodo<E> Siguiente;

    public Nodo(E info) {
        this.info = info;
        Siguiente = null;

    }

    public Nodo(E info, Nodo<E> siguiente) {
        this.info = info;
        this.Siguiente = siguiente;

    }

    public Nodo() {
        Siguiente = null;
        info = null;

    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public Nodo<E> getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo<E> siguiente) {
        this.Siguiente = siguiente;
    }
    
    public String toString() {
        if (info != null) {
            return info.toString();
        } 
        else {
            return null;
        }
    }
}
