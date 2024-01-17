
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import java.util.Date;

/**
 *
 * @author Victor
 */
public class Matricula {
    private Integer idMatricula;
    private Date FechaMatriculas;
    private Boolean EstadoMatricula;
    
    private Cursa matriculaCursa;
    private PeriodoAcademico matriculaPeriodoAcademico;
    
    private ListaDinamica<PeriodoAcademico> ListaPeriodos;
    private ListaDinamica<Cursa> ListaCursos;
    
    private String fechaMatricula;
    

    public Matricula() {
        
    }

    public Matricula(Integer idMatricula, String fechaMatricula, Boolean EstadoMatricula, PeriodoAcademico matriculaPeriodoAcademico, Cursa matriculaCursa) {
        this.idMatricula = idMatricula;
        this.fechaMatricula = fechaMatricula;
        this.EstadoMatricula = EstadoMatricula;
        this.matriculaPeriodoAcademico = matriculaPeriodoAcademico;
        this.matriculaCursa = matriculaCursa;
    }

    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Date getFechaMatriculas() {
        return FechaMatriculas;
    }

    public void setFechaMatriculas(Date FechaMatriculas) {
        this.FechaMatriculas = FechaMatriculas;
    }

    public Boolean getEstadoMatricula() {
        return EstadoMatricula;
    }

    public void setEstadoMatricula(Boolean EstadoMatricula) {
        this.EstadoMatricula = EstadoMatricula;
    }

    public Cursa getMatriculaCursa() {
        return matriculaCursa;
    }

    public void setMatriculaCursa(Cursa matriculaCursa) {
        this.matriculaCursa = matriculaCursa;
    }

    public PeriodoAcademico getMatriculaPeriodoAcademico() {
        return matriculaPeriodoAcademico;
    }

    public void setMatriculaPeriodoAcademico(PeriodoAcademico matriculaPeriodoAcademico) {
        this.matriculaPeriodoAcademico = matriculaPeriodoAcademico;
    }

    public ListaDinamica<PeriodoAcademico> getListaPeriodos() {
        return ListaPeriodos;
    }

    public void setListaPeriodos(ListaDinamica<PeriodoAcademico> ListaPeriodos) {
        this.ListaPeriodos = ListaPeriodos;
    }

    public ListaDinamica<Cursa> getListaCursos() {
        return ListaCursos;
    }

    public void setListaCursos(ListaDinamica<Cursa> ListaCursos) {
        this.ListaCursos = ListaCursos;
    }

    public String getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(String fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    @Override
    public String toString() {
        return "Fecha:" + fechaMatricula + "\n";
    }
    
}
