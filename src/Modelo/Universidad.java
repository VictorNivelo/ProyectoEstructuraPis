
package Modelo;

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

    public Universidad() {
        
    } 

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

    @Override
    public String toString() {
        return NombreUniversidad + "\n";
    }
        
}
