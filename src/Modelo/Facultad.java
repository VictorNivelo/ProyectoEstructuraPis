
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class Facultad {
    private Integer idFacultad;
    private String NombreFacultad;
    private String NombreDecano;
    private String FechaCreacion;
    private Carrera FacultadCarrera;
    private ListaDinamica<Carrera> ListaCarreras;

    public Facultad() {

    }

    public Facultad(Integer idFacultad, String NombreFacultad, String NombreDecano, String FechaCreacion, Carrera FacultadCarrera) {
        this.idFacultad = idFacultad;
        this.NombreFacultad = NombreFacultad;
        this.NombreDecano = NombreDecano;
        this.FechaCreacion = FechaCreacion;
        this.FacultadCarrera = FacultadCarrera;
    }

    public Integer getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Integer idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombreFacultad() {
        return NombreFacultad;
    }

    public void setNombreFacultad(String NombreFacultad) {
        this.NombreFacultad = NombreFacultad;
    }

    public String getNombreDecano() {
        return NombreDecano;
    }

    public void setNombreDecano(String NombreDecano) {
        this.NombreDecano = NombreDecano;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public Carrera getFacultadCarrera() {
        return FacultadCarrera;
    }

    public void setFacultadCarrera(Carrera FacultadCarrera) {
        this.FacultadCarrera = FacultadCarrera;
    }

    public ListaDinamica<Carrera> getListaCarreras() {
        return ListaCarreras;
    }

    public void setListaCarreras(ListaDinamica<Carrera> ListaCarreras) {
        this.ListaCarreras = ListaCarreras;
    }

    @Override
    public String toString() {
        return "Facultad{" + "idFacultad=" + idFacultad + ", NombreFacultad=" + NombreFacultad + ", NombreDecano=" + NombreDecano + ", FechaCreacion=" + FechaCreacion + ", FacultadCarrera=" + FacultadCarrera + '}';
    }
    
}
