
package Modelo;

/**
 *
 * @author Victor
 */
public class Docente {
    private Integer IdDocente;
    private String EspecialidadD;
    private String TitulacionD;
    private String AniosExperienciaD;
    
    private Persona DatosDocente;
    private Integer PersonaDocenteID;
    
    public Docente() {
        
    }

    public Integer getIdDocente() {
        return IdDocente;
    }

    public void setIdDocente(Integer IdDocente) {
        this.IdDocente = IdDocente;
    }

    public String getEspecialidad() {
        return EspecialidadD;
    }

    public void setEspecialidad(String Especialidad) {
        this.EspecialidadD = Especialidad;
    }

    public String getTitulacion() {
        return TitulacionD;
    }

    public void setTitulacion(String Titulacion) {
        this.TitulacionD = Titulacion;
    }

    public String getAniosExperiencia() {
        return AniosExperienciaD;
    }

    public void setAniosExperiencia(String AniosExperiencia) {
        this.AniosExperienciaD = AniosExperiencia;
    }

    public Persona getDatosDocente() {
        return DatosDocente;
    }

    public void setDatosDocente(Persona DatosDocente) {
        this.DatosDocente = DatosDocente;
    }

    public Integer getPersonaDocenteID() {
        return PersonaDocenteID;
    }

    public void setPersonaDocenteID(Integer PersonaDocenteID) {
        this.PersonaDocenteID = PersonaDocenteID;
    }
    
    @Override
    public String toString() {
        return DatosDocente.getNumeroCedula()+ " "+ DatosDocente.getNombre() +" "+ DatosDocente.getApellido() + "\n";
    }

}
