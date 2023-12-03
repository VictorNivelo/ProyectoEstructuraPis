/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Arreglos.Util;

import Controlador.Tda.listas.Exepciones.ListaVacia;
import Modelo.Ciclo;
import Modelo.Dao.cicloDao;
import Modelo.Dao.materiaDao;
import Modelo.Dao.paraleloDao;
import Modelo.Dao.rolDao;
import Modelo.Materia;
import Modelo.Paralelo;
import Modelo.Rol;
import javax.swing.JComboBox;

/**
 *
 * @author Victor
 */
public class UtilVista {
    public static void cargarcomboRoles(JComboBox cbx) throws ListaVacia{
        rolDao rc = new rolDao();
        cbx.removeAllItems();
        
        if(rc.getListaRol().EstaVacio()){
            throw new ListaVacia("No hay roles que mostrar");
        }
        else{
           for (int i = 0; i < rc.getListaRol().getLongitud(); i++) {
            cbx.addItem(rc.getListaRol().getInfo(i));
           }
        }
    }
    
    public static Rol obtenerRolControl(JComboBox cbx){
        return (Rol) cbx.getSelectedItem();
    }
    
    public static void CargarComboMateria(JComboBox cbx) throws ListaVacia{
        materiaDao mc = new materiaDao();
        cbx.removeAllItems();
        
        if(mc.getListaMateria().EstaVacio()){
            throw new ListaVacia("No hay materias que mostrar");
        }
        else{
           for (int i = 0; i < mc.getListaMateria().getLongitud(); i++) {
            cbx.addItem(mc.getListaMateria().getInfo(i));
           }
        }
    }
    
    public static Materia obtenreComboMateria(JComboBox cbx){
        return (Materia) cbx.getSelectedItem();
    }
    
    
    public static void cargarComboCiclo(JComboBox cbxC) throws ListaVacia{
        cicloDao rc = new cicloDao();
        cbxC.removeAllItems();

        
        if(rc.getListaCiclos().EstaVacio()){
            throw new ListaVacia("No hay ciclos que mostrar");
        }
        else{
           for (int i = 0; i < rc.getListaCiclos().getLongitud(); i++) {
            cbxC.addItem(rc.getListaCiclos().getInfo(i));
            
           }
        }
    }
    
    public static Ciclo obtenerCicloControl(JComboBox cbx){
        return (Ciclo) cbx.getSelectedItem();
    }
    
    public static void cargarcomboParalelo(JComboBox cbx) throws ListaVacia{
        paraleloDao rc = new paraleloDao();
        cbx.removeAllItems();
        
        if(rc.getListaParalelos().EstaVacio()){
            throw new ListaVacia("No hay paralelos que mostrar");
        }
        else{
           for (int i = 0; i < rc.getListaParalelos().getLongitud(); i++) {
            cbx.addItem(rc.getListaParalelos().getInfo(i));
           }
        }
    }
    
    public static Paralelo obtenerParaleloControl(JComboBox cbx){
        return (Paralelo) cbx.getSelectedItem();
    }
    
}
