/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Dao.matricula;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Matricula;

/**
 *
 * @author romer
 */
public class ControlMatriculaDao extends DaoImplement<Matricula>{
    
    private ListaDinamica<Matricula> matriculas;
    private Matricula matricula;
    
    public ControlMatriculaDao() {
        super(Matricula.class);
    }

    public ListaDinamica<Matricula> getMatriculas() {
        matriculas = all();
        return matriculas;
    }

    public void setMatriculas(ListaDinamica<Matricula> matriculas) {
        this.matriculas = matriculas;
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
