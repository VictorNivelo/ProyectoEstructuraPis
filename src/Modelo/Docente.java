
package Modelo;

/**
 *
 * @author Victor
 */
public class Docente {
    private Integer IdDocente;
    private String Especialidad;
    private String Titulacion;
    private String AniosExperiencia;
    
    private Persona DatosDocente;
    
    public Docente() {
        
    }

    public Integer getIdDocente() {
        return IdDocente;
    }

    public void setIdDocente(Integer IdDocente) {
        this.IdDocente = IdDocente;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public String getTitulacion() {
        return Titulacion;
    }

    public void setTitulacion(String Titulacion) {
        this.Titulacion = Titulacion;
    }

    public String getAniosExperiencia() {
        return AniosExperiencia;
    }

    public void setAniosExperiencia(String AniosExperiencia) {
        this.AniosExperiencia = AniosExperiencia;
    }

    public Persona getDatosDocente() {
        return DatosDocente;
    }

    public void setDatosDocente(Persona DatosDocente) {
        this.DatosDocente = DatosDocente;
    }
    
    @Override
    public String toString() {
        return DatosDocente.getNumeroCedula()+ " Nombres:"+ DatosDocente.getNombre() +" "+ DatosDocente.getApellido() + "\n";
    }

}
