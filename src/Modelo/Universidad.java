
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class Universidad {
    private Integer IdUniversidad;
    private String NombreUniversidad;
    private String DireccionUniversidad;
    private String NumeroTelefono;
    private String CorreoUniversidad;
    private String FechaFundacion;
    
    //datos poco usados
    private Facultad facultaUniversidad;
    private ListaDinamica<Facultad> listaFacultadUniversidad;
    private Persona personaUniversidad;
    private ListaDinamica<Persona> listaPersonaUniversidad;

    public Universidad() {
        
    }

//    public Universidad(Integer IdUniversidad, String NombreUniversidad, String DireccionUniversidad, String NumeroTelefono, String CorreoUniversidad, String FechaFundacion) {
//        this.IdUniversidad = IdUniversidad;
//        this.NombreUniversidad = NombreUniversidad;
//        this.DireccionUniversidad = DireccionUniversidad;
//        this.NumeroTelefono = NumeroTelefono;
//        this.CorreoUniversidad = CorreoUniversidad;
//        this.FechaFundacion = FechaFundacion;
//    }    

    public Integer getIdUniversidad() {
        return IdUniversidad;
    }

    public void setIdUniversidad(Integer IdUniversidad) {
        this.IdUniversidad = IdUniversidad;
    }

    public String getNombreUniversidad() {
        return NombreUniversidad;
    }

    public void setNombreUniversidad(String NombreUniversidad) {
        this.NombreUniversidad = NombreUniversidad;
    }

    public String getDireccionUniversidad() {
        return DireccionUniversidad;
    }

    public void setDireccionUniversidad(String DireccionUniversidad) {
        this.DireccionUniversidad = DireccionUniversidad;
    }

    public String getNumeroTelefono() {
        return NumeroTelefono;
    }

    public void setNumeroTelefono(String NumeroTelefono) {
        this.NumeroTelefono = NumeroTelefono;
    }

    public String getCorreoUniversidad() {
        return CorreoUniversidad;
    }

    public void setCorreoUniversidad(String CorreoUniversidad) {
        this.CorreoUniversidad = CorreoUniversidad;
    }

    public String getFechaFundacion() {
        return FechaFundacion;
    }

    public void setFechaFundacion(String FechaFundacion) {
        this.FechaFundacion = FechaFundacion;
    }

    public Facultad getFacultaUniversidad() {
        return facultaUniversidad;
    }

    public void setFacultaUniversidad(Facultad facultaUniversidad) {
        this.facultaUniversidad = facultaUniversidad;
    }

    public ListaDinamica<Facultad> getListaFacultadUniversidad() {
        return listaFacultadUniversidad;
    }

    public void setListaFacultadUniversidad(ListaDinamica<Facultad> listaFacultadUniversidad) {
        this.listaFacultadUniversidad = listaFacultadUniversidad;
    }

    public Persona getPersonaUniversidad() {
        return personaUniversidad;
    }

    public void setPersonaUniversidad(Persona personaUniversidad) {
        this.personaUniversidad = personaUniversidad;
    }

    public ListaDinamica<Persona> getListaPersonaUniversidad() {
        return listaPersonaUniversidad;
    }

    public void setListaPersonaUniversidad(ListaDinamica<Persona> listaPersonaUniversidad) {
        this.listaPersonaUniversidad = listaPersonaUniversidad;
    }

    @Override
    public String toString() {
        return NombreUniversidad + "\n";
    }
        
}
