
package Modelo;

/**
 *
 * @author Victor
 */
public class Matricula {
    private Integer IdMatri;
    private String CodigoMatr;
    private String FechaM;
    private String EstadoM;
    
    private Alumno alumnoMatricula;
    private Integer IdAlumno;
    
    private PeriodoAcademico periodoAcademicoMatricula;
    private Integer PeriodoID;
    
    public Matricula() {
        
    }

    public Integer getIdMatricula() {
        return IdMatri;
    }

    public void setIdMatricula(Integer IdMatricula) {
        this.IdMatri = IdMatricula;
    }

    public String getCodigoMatricula() {
        return CodigoMatr;
    }

    public void setCodigoMatricula(String CodigoMatricula) {
        this.CodigoMatr = CodigoMatricula;
    }

    public String getFechaMatricula() {
        return FechaM;
    }

    public void setFechaMatricula(String FechaMatricula) {
        this.FechaM = FechaMatricula;
    }

    public String getEstadoMatricula() {
        return EstadoM;
    }

    public void setEstadoMatricula(String EstadoMatricula) {
        this.EstadoM = EstadoMatricula;
    }

    public PeriodoAcademico getPeriodoAcademicoMatricula() {
        return periodoAcademicoMatricula;
    }

    public void setPeriodoAcademicoMatricula(PeriodoAcademico periodoAcademicoMatricula) {
        this.periodoAcademicoMatricula = periodoAcademicoMatricula;
    }

    public Alumno getAlumnoMatricula() {
        return alumnoMatricula;
    }

    public void setAlumnoMatricula(Alumno alumnoMatricula) {
        this.alumnoMatricula = alumnoMatricula;
    }

    public Integer getAlumnoID() {
        return IdAlumno;
    }

    public void setAlumnoID(Integer AlumnoID) {
        this.IdAlumno = AlumnoID;
    }

    public Integer getPeriodoID() {
        return PeriodoID;
    }

    public void setPeriodoID(Integer PeriodoID) {
        this.PeriodoID = PeriodoID;
    }

    @Override
    public String toString() {
        return CodigoMatr +  " " + alumnoMatricula.getDatosAlumno().getNumeroCedula() +  " "+ alumnoMatricula.getDatosAlumno().getNombre() +" "+ alumnoMatricula.getDatosAlumno().getApellido()+"\n";
    }
    
}
