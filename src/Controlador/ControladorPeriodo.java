/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.PeriodoAcademico;

/**
 *
 * @author romer
 */
public class ControladorPeriodo {
    private ListaDinamica<PeriodoAcademico> periodos;
    private PeriodoAcademico periodoAcademico;
    
    public ControladorPeriodo(){
        periodos = new ListaDinamica<>();
    }
    
    public Boolean guardarPeriodo(){
        getPeriodoAcademico().setIdPeriodoAcademino(getPeriodos().getLongitud());
        getPeriodos().Agregar(getPeriodoAcademico());
        return true;
    }

    public ListaDinamica<PeriodoAcademico> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(ListaDinamica<PeriodoAcademico> periodos) {
        this.periodos = periodos;
    }

    public PeriodoAcademico getPeriodoAcademico() {
        if (periodoAcademico == null) {
            periodoAcademico = new PeriodoAcademico();
        }
        return periodoAcademico;
    }

    public void setPeriodoAcademico(PeriodoAcademico periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }
    
    
    
}
