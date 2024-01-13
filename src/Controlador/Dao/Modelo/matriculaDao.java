/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Dao.Modelo;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Matricula;

/**
 *
 * @author romer
 */
public class matriculaDao extends DaoImplement<Matricula>{
    
    private ListaDinamica<Matricula> ListaMatriculas;
    private Matricula matricula;
    
    public matriculaDao() {
        super(Matricula.class);
    }

    public ListaDinamica<Matricula> getListaMatriculas() {
        ListaMatriculas = all();
        return ListaMatriculas;
    }

    public void setListaMatriculas(ListaDinamica<Matricula> ListaMatriculas) {
        this.ListaMatriculas = ListaMatriculas;
    } 

    public Matricula getMatricula() {
        if (matricula == null) {
            matricula = new Matricula();
        }
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    
    public Boolean persist(){
        matricula.setIdMatricula(all().getLongitud()+1);
        return Persist(matricula);
    }
}
