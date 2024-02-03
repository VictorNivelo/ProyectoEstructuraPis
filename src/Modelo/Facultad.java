
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class Facultad {
    private Integer IdFacultad;
    private String NombreFacultad;
    private String FechaCreacion;
    
    private Universidad universidadFacultad;
    
    //Datos poco usados
    private Carrera carreraFacultad;
    private ListaDinamica<Carrera> listaCarreraFacultad;
    private Persona personaFacultad;
    private ListaDinamica<Persona> listaPersonaFacultad;

    public Facultad() {

    }

//    public Facultad(Integer IdFacultad, String NombreFacultad, String FechaCreacion, Universidad universidadFacultad) {
//        this.IdFacultad = IdFacultad;
//        this.NombreFacultad = NombreFacultad;
//        this.FechaCreacion = FechaCreacion;
//        this.universidadFacultad = universidadFacultad;
//    }

    public Integer getIdFacultad() {
        return IdFacultad;
    }

    public void setIdFacultad(Integer IdFacultad) {
        this.IdFacultad = IdFacultad;
    }

    public String getNombreFacultad() {
        return NombreFacultad;
    }

    public void setNombreFacultad(String NombreFacultad) {
        this.NombreFacultad = NombreFacultad;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public Carrera getCarreraFacultad() {
        return carreraFacultad;
    }

    public void setCarreraFacultad(Carrera carreraFacultad) {
        this.carreraFacultad = carreraFacultad;
    }

    public ListaDinamica<Carrera> getListaCarreraFacultad() {
        return listaCarreraFacultad;
    }

    public void setListaCarreraFacultad(ListaDinamica<Carrera> listaCarreraFacultad) {
        this.listaCarreraFacultad = listaCarreraFacultad;
    }

    public Persona getPersonaFacultad() {
        return personaFacultad;
    }

    public void setPersonaFacultad(Persona personaFacultad) {
        this.personaFacultad = personaFacultad;
    }

    public ListaDinamica<Persona> getListaPersonaFacultad() {
        return listaPersonaFacultad;
    }

    public void setListaPersonaFacultad(ListaDinamica<Persona> listaPersonaFacultad) {
        this.listaPersonaFacultad = listaPersonaFacultad;
    }

    public Universidad getUniversidadFacultad() {
        return universidadFacultad;
    }

    public void setUniversidadFacultad(Universidad universidadFacultad) {
        this.universidadFacultad = universidadFacultad;
    }
        
    @Override
    public String toString() {
        return NombreFacultad +  "\n";
    }
    
}
