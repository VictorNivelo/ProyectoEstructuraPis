/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Matricula;

/**
 *
 * @author romer
 */
public class ControladorMatricula {
    private ListaDinamica<Matricula> matriculas;
    private Matricula matricula;

    public ControladorMatricula() {
        matriculas = new ListaDinamica<>();
    }
    
    public Boolean guardarMatricula(){
        getMatricula().setIdMatricula(getMatriculas().getLongitud());
        getMatriculas().Agregar(getMatricula());
        return true;
    }

    public ListaDinamica<Matricula> getMatriculas() {
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
    
    
    
    
}
