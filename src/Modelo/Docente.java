
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;

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
    
    private Cursa cursoDocente;
    private ListaDinamica<Cursa> listaCursoDocente;
    
    public Docente() {
        
    }

    public Docente(Integer IdDocente, String Especialidad, String Titulacion, String AniosExperiencia, Persona DatosDocente, Cursa cursoDocente) {
        this.IdDocente = IdDocente;
        this.Especialidad = Especialidad;
        this.Titulacion = Titulacion;
        this.AniosExperiencia = AniosExperiencia;
        this.DatosDocente = DatosDocente;
        this.cursoDocente = cursoDocente;
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

    public Cursa getCursoDocente() {
        return cursoDocente;
    }

    public void setCursoDocente(Cursa cursoDocente) {
        this.cursoDocente = cursoDocente;
    }

    public ListaDinamica<Cursa> getListaCursoDocente() {
        return listaCursoDocente;
    }

    public void setListaCursoDocente(ListaDinamica<Cursa> listaCursoDocente) {
        this.listaCursoDocente = listaCursoDocente;
    }
    
    @Override
    public String toString() {
        return "Dni:" + DatosDocente.getNumeroCedula()+ " Nombres:"+ DatosDocente.getNombre() +" "+ DatosDocente.getApellido() + "\n";
    }

}
