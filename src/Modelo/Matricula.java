
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class Matricula {
    private Integer IdMatricula;
    private String CodigoMatricula;
    private String FechaMatricula;
    private String EstadoMatricula;
    
    private Cursa cursoMatricula;
    private PeriodoAcademico periodoAcademicoMatricula;
    
    private ListaDinamica<Cursa> listaCursoMatricula;
    private ListaDinamica<PeriodoAcademico> listaPeriodoMatricula;
    
    public Matricula() {
        
    }

//    public Matricula(Integer IdMatricula, String CodigoMatricula, String FechaMatricula, String EstadoMatricula, Cursa cursoMatricula, PeriodoAcademico periodoAcademicoMatricula) {
//        this.IdMatricula = IdMatricula;
//        this.CodigoMatricula = CodigoMatricula;
//        this.FechaMatricula = FechaMatricula;
//        this.EstadoMatricula = EstadoMatricula;
//        this.cursoMatricula = cursoMatricula;
//        this.periodoAcademicoMatricula = periodoAcademicoMatricula;
//    }

    public Integer getIdMatricula() {
        return IdMatricula;
    }

    public void setIdMatricula(Integer IdMatricula) {
        this.IdMatricula = IdMatricula;
    }

    public String getCodigoMatricula() {
        return CodigoMatricula;
    }

    public void setCodigoMatricula(String CodigoMatricula) {
        this.CodigoMatricula = CodigoMatricula;
    }

    public String getFechaMatricula() {
        return FechaMatricula;
    }

    public void setFechaMatricula(String FechaMatricula) {
        this.FechaMatricula = FechaMatricula;
    }

    public String getEstadoMatricula() {
        return EstadoMatricula;
    }

    public void setEstadoMatricula(String EstadoMatricula) {
        this.EstadoMatricula = EstadoMatricula;
    }

    public Cursa getCursoMatricula() {
        return cursoMatricula;
    }

    public void setCursoMatricula(Cursa cursoMatricula) {
        this.cursoMatricula = cursoMatricula;
    }

    public PeriodoAcademico getPeriodoAcademicoMatricula() {
        return periodoAcademicoMatricula;
    }

    public void setPeriodoAcademicoMatricula(PeriodoAcademico periodoAcademicoMatricula) {
        this.periodoAcademicoMatricula = periodoAcademicoMatricula;
    }

    public ListaDinamica<Cursa> getListaCursoMatricula() {
        return listaCursoMatricula;
    }

    public void setListaCursoMatricula(ListaDinamica<Cursa> listaCursoMatricula) {
        this.listaCursoMatricula = listaCursoMatricula;
    }

    public ListaDinamica<PeriodoAcademico> getListaPeriodoMatricula() {
        return listaPeriodoMatricula;
    }

    public void setListaPeriodoMatricula(ListaDinamica<PeriodoAcademico> listaPeriodoMatricula) {
        this.listaPeriodoMatricula = listaPeriodoMatricula;
    }
  

    @Override
    public String toString() {
        return "Codigo:" + CodigoMatricula +  ", Estado:" + EstadoMatricula +"\n";
    }
    
}
