/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Alumno;

/**
 *
 * @author Victor
 */
public class personaDao extends DaoImplement<Alumno>{
    private ListaDinamica<Alumno> ListaAlumnos = new ListaDinamica<>();
    private Alumno alumnos;
    
    public personaDao(){
        super (Alumno.class);
    }

    public ListaDinamica<Alumno> getListaAlumnos() {
        ListaAlumnos = all();
        return ListaAlumnos;
    }

    public void setListaAlumnos(ListaDinamica<Alumno> ListaAlumnos) {
        this.ListaAlumnos = ListaAlumnos;
    }

    public Alumno getAlumnos() {
        if(alumnos == null){
            alumnos = new Alumno();
        }
        return alumnos;
    }

    public void setAlumnos(Alumno alumnos) {
        this.alumnos = alumnos;
    }
    
    public Boolean Persist(){
        alumnos.setIdAlumno(all().getLongitud()+1);
        return Persist(alumnos);
    }
}
