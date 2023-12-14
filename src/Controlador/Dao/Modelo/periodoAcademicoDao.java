/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Dao.Modelo;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.PeriodoAcademico;

/**
 *
 * @author Victor
 */
public class periodoAcademicoDao extends DaoImplement<PeriodoAcademico> {
    private ListaDinamica<PeriodoAcademico> periodos;
    private PeriodoAcademico periodo;
    
    public periodoAcademicoDao(){
        super(PeriodoAcademico.class);
    }

    public ListaDinamica<PeriodoAcademico> getPeriodos() {
        periodos  = all();
        return periodos;
    }

    public void setPeriodos(ListaDinamica<PeriodoAcademico> periodos) {
        this.periodos = periodos;
    }

    public PeriodoAcademico getPeriodo() {
        if (periodo == null) {
            periodo = new PeriodoAcademico();
        }
        return periodo;
    }

    public void setPeriodo(PeriodoAcademico periodo) {
        this.periodo = periodo;
    }

    
    public Boolean persist(){
        periodo.setIdPeriodoAcademino(all().getLongitud() + 1);
        return Persist(periodo);
    }
}
