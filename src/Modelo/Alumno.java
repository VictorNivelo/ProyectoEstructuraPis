
package Modelo;

/**
 *
 * @author Victor
 */
public class Alumno {
    private Integer IdAlumno;
    private String EstadoA;
    
    private Persona DatosAlumno;
    private Integer PersonaAlumnoID;
    
    public Alumno() {
        
    }

    public Integer getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(Integer IdAlumno) {
        this.IdAlumno = IdAlumno;
    }

    public String getEstadoAlumno() {
        return EstadoA;
    }

    public void setEstadoAlumno(String EstadoAlumno) {
        this.EstadoA = EstadoAlumno;
    }

    public Persona getDatosAlumno() {
        return DatosAlumno;
    }

    public void setDatosAlumno(Persona DatosAlumno) {
        this.DatosAlumno = DatosAlumno;
    }

    public Integer getPersonaAlumnoID() {
        return PersonaAlumnoID;
    }

    public void setPersonaAlumnoID(Integer PersonaAlumnoID) {
        this.PersonaAlumnoID = PersonaAlumnoID;
    }
    
    @Override
    public String toString() {
        return DatosAlumno.getNumeroCedula() + " " + DatosAlumno.getNombre() +" " +DatosAlumno.getApellido()+ "\n";
    }
    
}
