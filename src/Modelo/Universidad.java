
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import java.util.Date;

/**
 *
 * @author Victor
 */
public class Universidad {
    private Integer idUniversidad;
    private String NimbreUniversidad;
    private String DireccionUniversidad;
    private String NumeroTelefono;
    private String CorreoUniversidad;
    private Date FechaFundacion;
    private ListaDinamica<Facultad> ListaFacultades;

    public Universidad() {
        
    }

    public Universidad(Integer idUniversidad, String NimbreUniversidad, String DireccionUniversidad, String NumeroTelefono, String CorreoUniversidad, Date FechaFundacion) {
        this.idUniversidad = idUniversidad;
        this.NimbreUniversidad = NimbreUniversidad;
        this.DireccionUniversidad = DireccionUniversidad;
        this.NumeroTelefono = NumeroTelefono;
        this.CorreoUniversidad = CorreoUniversidad;
        this.FechaFundacion = FechaFundacion;
    }

    public Integer getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(Integer idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    public String getNimbreUniversidad() {
        return NimbreUniversidad;
    }

    public void setNimbreUniversidad(String NimbreUniversidad) {
        this.NimbreUniversidad = NimbreUniversidad;
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

    public Date getFechaFundacion() {
        return FechaFundacion;
    }

    public void setFechaFundacion(Date FechaFundacion) {
        this.FechaFundacion = FechaFundacion;
    }

    @Override
    public String toString() {
        return "Universidad{" + "idUniversidad=" + idUniversidad + ", NimbreUniversidad=" + NimbreUniversidad + ", DireccionUniversidad=" + DireccionUniversidad + ", NumeroTelefono=" + NumeroTelefono + ", CorreoUniversidad=" + CorreoUniversidad + ", FechaFundacion=" + FechaFundacion + '}';
    }
        
}
