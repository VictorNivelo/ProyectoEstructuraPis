
package Modelo;

/**
 *
 * @author Victor
 */
public class Persona {
    private Integer IdP;
    private String TipoDNI;
    private String NroDNIP;
    private String NombreP;
    private String ApellidoP;
    private String GeneroP;
    private String FechaNP;
    private String DireP;
    private String TelefonoP;
    
    private Rol rolPersona;
    private Integer idRol;
    
    private Cuenta cuentaPersona;
    private Integer idCuenta;
    
    public Persona() {
        
    }

    public Integer getIdPersona() {
        return IdP;
    }

    public void setIdPersona(Integer IdPersona) {
        this.IdP = IdPersona;
    }

    public String getTipoDni() {
        return TipoDNI;
    }

    public void setTipoDni(String TipoDni) {
        this.TipoDNI = TipoDni;
    }

    public String getNumeroCedula() {
        return NroDNIP;
    }

    public void setNumeroCedula(String NumeroCedula) {
        this.NroDNIP = NumeroCedula;
    }

    public String getNombre() {
        return NombreP;
    }

    public void setNombre(String Nombre) {
        this.NombreP = Nombre;
    }

    public String getApellido() {
        return ApellidoP;
    }

    public void setApellido(String Apellido) {
        this.ApellidoP = Apellido;
    }

    public String getGenero() {
        return GeneroP;
    }

    public void setGenero(String Genero) {
        this.GeneroP = Genero;
    }

    public String getFechaNacimineto() {
        return FechaNP;
    }

    public void setFechaNacimineto(String FechaNacimineto) {
        this.FechaNP = FechaNacimineto;
    }

    public String getDireccion() {
        return DireP;
    }

    public void setDireccion(String Direccion) {
        this.DireP = Direccion;
    }

    public String getTelefono() {
        return TelefonoP;
    }

    public void setTelefono(String Telefono) {
        this.TelefonoP = Telefono;
    }

    public Rol getRolPersona() {
        return rolPersona;
    }

    public void setRolPersona(Rol rolPersona) {
        this.rolPersona = rolPersona;
    }

    public Cuenta getCuentaPersona() {
        return cuentaPersona;
    }

    public void setCuentaPersona(Cuenta cuentaPersona) {
        this.cuentaPersona = cuentaPersona;
    }

    public Integer getRolID() {
        return idRol;
    }

    public void setRolID(Integer RolID) {
        this.idRol = RolID;
    }

    public Integer getCuendaID() {
        return idCuenta;
    }

    public void setCuendaID(Integer CuendaID) {
        this.idCuenta = CuendaID;
    }

    @Override
    public String toString() {
        return NroDNIP + " " + NombreP  +" "+ ApellidoP +  "\n";
    }

}
