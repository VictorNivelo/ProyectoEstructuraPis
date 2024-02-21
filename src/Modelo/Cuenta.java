
package Modelo;

/**
 *
 * @author Victor
 */
public class Cuenta {
    private Integer IdCuenta;
    private String CorreoC;
    private String ContraseniaC;
    private String EstadoC;

    public Cuenta() {
        
    }

    public Integer getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.IdCuenta = idCuenta;
    }

    public String getCorreo() {
        return CorreoC;
    }

    public void setCorreo(String Correo) {
        this.CorreoC = Correo;
    }

    public String getContrasena() {
        return ContraseniaC;
    }

    public void setContrasena(String Contrasena) {
        this.ContraseniaC = Contrasena;
    }

    public String getEstadoCuenta() {
        return EstadoC;
    }

    public void setEstadoCuenta(String EstadoCuenta) {
        this.EstadoC = EstadoCuenta;
    }
    
    @Override
    public String toString() {
        return "idCuenta=" + IdCuenta + ", Correo=" + CorreoC + ", Contrasena=" + ContraseniaC + ", EstadoCuenta=" + EstadoC;
    }
    
}
