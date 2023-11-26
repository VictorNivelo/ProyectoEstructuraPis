/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Dao;

import Controlador.Tda.listas.Exepciones.PosicionNoEncontrada;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import com.thoughtworks.xstream.XStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Victor
 */
public class DaoImplement<T> implements DaoInterface<T>{
    private Class<T> clazz;
    private XStream conection;
    private String URL;
    
    public DaoImplement(Class<T> clazz) {
        this.clazz = clazz;
        conection = Bridge.getConection();
        URL = Bridge.URL + clazz.getSimpleName() + ".json";
    }
    
    
    
    @Override
    public Boolean Persist(T dato) {
        ListaDinamica<T> ld = all();
        ld.Agregar(dato);
        
        try {
            conection.toXML(ld,new FileWriter(URL));
            return true;
        } 
        catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public Boolean Merge(T data, Integer indice) {
        ListaDinamica<T> ListaModificar = all();

        if (indice >= 0 && indice < ListaModificar.getLongitud()) {
            try {
                ListaModificar.modificarPosicion(data, indice);
            } 
            catch (PosicionNoEncontrada ex) {
                Logger.getLogger(DaoImplement.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                conection.toXML(ListaModificar, new FileWriter(URL));
                return true;
            } 
            catch (Exception e) {
                return false;
            }
        } 
        else {
            return false;
        }
    }

    @Override
    public ListaDinamica<T> all() {
        ListaDinamica<T> dl = new ListaDinamica<>();
        try {
            dl = (ListaDinamica<T>)conection.fromXML(new FileReader(URL));
        } 
        catch (Exception e) {
            
        }
        return dl;
    }

    @Override
    public T get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Boolean Eliminar(Integer index) {
        ListaDinamica<T> listaActualizada = all();

        try {
            listaActualizada.eliminar(index);

            conection.toXML(listaActualizada, new FileWriter(URL));

            return true;
        } 
        catch (Exception e) {
            return false;
        }
    }
}
