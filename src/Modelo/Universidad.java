
package Modelo;

/**
 *
 * @author Victor
 */
public class Universidad {
    private Integer IdU;
    private String NombreU;
    private String DireccionU;
    private String TelefonoU;
    private String CorreoU;
    private String FechaFU;

    public Universidad() {
        
    } 

    public Integer getIdU() {
        return IdU;
    }

    public void setIdU(Integer IdU) {
        this.IdU = IdU;
    }

    public String getNombreU() {
        return NombreU;
    }

    public void setNombreU(String NombreU) {
        this.NombreU = NombreU;
    }

    public String getDireccionU() {
        return DireccionU;
    }

    public void setDireccionU(String DireccionU) {
        this.DireccionU = DireccionU;
    }

    public String getTelefonoU() {
        return TelefonoU;
    }

    public void setTelefonoU(String TelefonoU) {
        this.TelefonoU = TelefonoU;
    }

    public String getCorreoU() {
        return CorreoU;
    }

    public void setCorreoU(String CorreoU) {
        this.CorreoU = CorreoU;
    }

    public String getFechaFU() {
        return FechaFU;
    }

    public void setFechaFU(String FechaFU) {
        this.FechaFU = FechaFU;
    }

    @Override
    public String toString() {
        return NombreU + "\n";
    }
        
}
