/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Rol;

/**
 *
 * @author Victor
 */
public class rolDao extends DaoImplement<Rol>{
    private ListaDinamica<Rol> listaRol = new ListaDinamica<>();
    private Rol rol;

    public rolDao() {
        super(Rol.class);
    }
    
    public ListaDinamica<Rol> getListaRol() {
        listaRol = all();
        return listaRol;
    }

    public void setListaRol(ListaDinamica<Rol> listaRol) {
        this.listaRol = listaRol;
    }

    public Rol getRol() {
        if(rol ==null){
            rol = new Rol();
        }
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public Boolean Persist(){
        rol.setIdRol(all().getLongitud()+1);
        return Persist(rol);
    }
//    
//    public static void main(String[] args) {
//        rolDao DaoRol = new rolDao();
//        
//        DaoRol.getRol().setDescripcionRol("Es un administrador");
//        DaoRol.getRol().setNombreRol("Administrador");
//        DaoRol.Persist();
//        DaoRol.setRol(null);
//        
//        DaoRol.getRol().setDescripcionRol("Es personal administrativo");
//        DaoRol.getRol().setNombreRol("Personal administrativo");
//        DaoRol.Persist();
//        DaoRol.setRol(null);
//        
//        DaoRol.getRol().setDescripcionRol("Es un docente");
//        DaoRol.getRol().setNombreRol("Docente");
//        DaoRol.Persist();
//        DaoRol.setRol(null);
//        
//        DaoRol.getRol().setDescripcionRol("Es un estudiante");
//        DaoRol.getRol().setNombreRol("Estudiante");
//        DaoRol.Persist();
//        DaoRol.setRol(null);
//    }
}
