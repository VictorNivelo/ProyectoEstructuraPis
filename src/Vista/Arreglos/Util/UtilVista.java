/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Arreglos.Util;

import Controlador.Tda.listas.Exepciones.ListaVacia;
import Modelo.Dao.materiaDao;
import Modelo.Dao.rolDao;
import Modelo.Materia;
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
            throw new ListaVacia("No hay roles que mostrar");
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
}
