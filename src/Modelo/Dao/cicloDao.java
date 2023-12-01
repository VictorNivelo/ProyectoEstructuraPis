/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Ciclo;

/**
 *
 * @author Victor
 */
public class cicloDao extends DaoImplement<Ciclo>{
    private ListaDinamica<Ciclo> ListaCiclos = new ListaDinamica<>();
    private Ciclo ciclos;
    
    public cicloDao(){
        super (Ciclo.class);
    }

    public ListaDinamica<Ciclo> getListaCiclos() {
        ListaCiclos = all();
        return ListaCiclos;
    }

    public void setListaCiclos(ListaDinamica<Ciclo> ListaCiclos) {
        this.ListaCiclos = ListaCiclos;
    }

    public Ciclo getCiclos() {
        if(ciclos == null){
            ciclos = new Ciclo();
        }
        return ciclos;
    }

    public void setCiclos(Ciclo ciclos) {
        this.ciclos = ciclos;
    }
    
    public Boolean Persist(){
        ciclos.setIdCiclo(all().getLongitud()+1);
        return Persist(ciclos);
    }
}
