/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Dao.Modelo;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Paralelo;

/**
 *
 * @author Victor
 */
public class paraleloDao extends DaoImplement<Paralelo>{
    private ListaDinamica<Paralelo> ListaParalelos = new ListaDinamica<>();
    private Paralelo paralelos;
    
    public paraleloDao(){
        super (Paralelo.class);
    }

    public ListaDinamica<Paralelo> getListaParalelos() {
        ListaParalelos = all();
        return ListaParalelos;
    }

    public void setListaParalelos(ListaDinamica<Paralelo> ListaParalelos) {
        this.ListaParalelos = ListaParalelos;
    }

    public Paralelo getParalelos() {
        if(paralelos == null){
            paralelos = new Paralelo();
        }
        return paralelos;
    }

    public void setParalelos(Paralelo paralelos) {
        this.paralelos = paralelos;
    }
    
    public Boolean Persist(){
        paralelos.setIdParaleli(all().getLongitud()+1);
        return Persist(paralelos);
    }
    
}
