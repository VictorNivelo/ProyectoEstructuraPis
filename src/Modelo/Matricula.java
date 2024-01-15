
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import java.util.Date;

/**
 *
 * @author Victor
 */
public class Matricula {
    private Integer idMatricula;
    private Date FechaMatricula;
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

    public String getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(String fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public Boolean getEstadoMatricula() {
        return EstadoMatricula;
    }

    public void setEstadoMatricula(Boolean EstadoMatricula) {
        this.EstadoMatricula = EstadoMatricula;
    }

    public PeriodoAcademico getMatriculaPeriodoAcademico() {
        return matriculaPeriodoAcademico;
    }

    public void setMatriculaPeriodoAcademico(PeriodoAcademico matriculaPeriodoAcademico) {
        this.matriculaPeriodoAcademico = matriculaPeriodoAcademico;
    }

    public Cursa getMatriculaCursa() {
        return matriculaCursa;
    }

    public void setMatriculaCursa(Cursa matriculaCursa) {
        this.matriculaCursa = matriculaCursa;
    }

    @Override
    public String toString() {
        return "Fecha:" + fechaMatricula + "\n";
    }
    
}
