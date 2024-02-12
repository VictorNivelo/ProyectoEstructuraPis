
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
    
    private Alumno alumnoMatricula;
    private ListaDinamica<Alumno> listaAlumnosMatricula;
    
    private PeriodoAcademico periodoAcademicoMatricula;
    private ListaDinamica<PeriodoAcademico> listaPeriodoMatricula;
    
    public Matricula() {
        
    }

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

    public PeriodoAcademico getPeriodoAcademicoMatricula() {
        return periodoAcademicoMatricula;
    }

    public void setPeriodoAcademicoMatricula(PeriodoAcademico periodoAcademicoMatricula) {
        this.periodoAcademicoMatricula = periodoAcademicoMatricula;
    }

    public ListaDinamica<PeriodoAcademico> getListaPeriodoMatricula() {
        return listaPeriodoMatricula;
    }

    public void setListaPeriodoMatricula(ListaDinamica<PeriodoAcademico> listaPeriodoMatricula) {
        this.listaPeriodoMatricula = listaPeriodoMatricula;
    }

    public Alumno getAlumnoMatricula() {
        return alumnoMatricula;
    }

    public void setAlumnoMatricula(Alumno alumnoMatricula) {
        this.alumnoMatricula = alumnoMatricula;
    }

    public ListaDinamica<Alumno> getListaAlumnosMatricula() {
        return listaAlumnosMatricula;
    }

    public void setListaAlumnosMatricula(ListaDinamica<Alumno> listaAlumnosMatricula) {
        this.listaAlumnosMatricula = listaAlumnosMatricula;
    }

    @Override
    public String toString() {
        return CodigoMatricula +  " Alumno:" + alumnoMatricula.getDatosAlumno().getNumeroCedula() +"\n";
    }
    
}
