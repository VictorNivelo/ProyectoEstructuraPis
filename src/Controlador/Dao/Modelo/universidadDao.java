/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Dao.Modelo;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Universidad;

/**
 *
 * @author Victor
 */
public class universidadDao extends DaoImplement<Universidad>{
    private ListaDinamica<Universidad> ListaUniversidades = new ListaDinamica<>();
    private Universidad universidades;
    
    public universidadDao(){
        super (Universidad.class);
    }

    public ListaDinamica<Universidad> getListaUniversidades() {
        ListaUniversidades = all();
        return ListaUniversidades;
    }

    public void setListaUniversidades(ListaDinamica<Universidad> ListaUniversidades) {
        this.ListaUniversidades = ListaUniversidades;
    }

    public Universidad getUniversidades() {
        if(universidades == null){
            universidades = new Universidad();
        }
        return universidades;
    }

    public void setUniversidades(Universidad universidades) {
        this.universidades = universidades;
    }
    
    public Boolean Persist(){
        universidades.setIdUniversidad(all().getLongitud()+1);
        return Persist(universidades);
    }
    
}
