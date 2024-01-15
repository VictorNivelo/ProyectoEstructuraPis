
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class Persona {
    private Integer idPersona;
    private String TipoDni;
    private String NumeroCedula;
    private String Nombre;
    private String Apellido;
    private String Genero;
    private String FechaNacimineto;
    private String direccion;
    private String Telefono;
    private Rol rolPersona;
    private Cuenta cuentaPersona;
    
    private ListaDinamica<Cursa> cursosAsignados;

    public Persona() {
        
    }
    
//    public Persona() {
//        cursosAsignados = new ListaDinamica<>();
//    }

    public Persona(Integer idPersona, String NumeroCedula, String Nombre, String Apellido, String Genero, String FechaNacimineto, String direccion, String Telefono, Rol rolPersona, Cuenta cuentaPersona) {
        this.idPersona = idPersona;
        this.NumeroCedula = NumeroCedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Genero = Genero;
        this.FechaNacimineto = FechaNacimineto;
        this.direccion = direccion;
        this.Telefono = Telefono;
        this.rolPersona = rolPersona;
        this.cuentaPersona = cuentaPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getTipoDni() {
        return TipoDni;
    }

    public void setTipoDni(String TipoDni) {
        this.TipoDni = TipoDni;
    }

    public String getNumeroCedula() {
        return NumeroCedula;
    }

    public void setNumeroCedula(String NumeroCedula) {
        this.NumeroCedula = NumeroCedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getFechaNacimineto() {
        return FechaNacimineto;
    }

    public void setFechaNacimineto(String FechaNacimineto) {
        this.FechaNacimineto = FechaNacimineto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
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

    
    
//    public Boolean comparar(Persona p, String campo, Integer tipo) {
//        switch (tipo) {
//            case 0:
//                return compararCampo(p, campo) < 0;
//            case 1:
//                return compararCampo(p, campo) > 0;
//            default:
//                throw new IllegalArgumentException("Tipo de comparación no válido");
//        }
//    }
//
//    private int compararCampo(Persona p, String campo) {
//        switch (campo.toLowerCase()) {
//            case "numerocedula":
//                return NumeroCedula.compareTo(p.getNumeroCedula());
//            case "nombre":
//                return Nombre.compareTo(p.getNombre());
//            case "apellido":
//                return Apellido.compareTo(p.getApellido());
//            case "genero":
//                return Genero.compareTo(p.getGenero());
//            case "rol":
//                return rolPersona.getNombreRol().compareTo(p.getRolPersona().getNombreRol());
//
//            default:
//                throw new IllegalArgumentException("Campo no válido para la comparación");
//        }
//    }
//    
//
//
//    public void inscribirCurso(Cursa curso) {
//        cursosAsignados.Agregar(curso);
//    }
//
//    public ListaDinamica<Cursa> getCursosAsignados() {
//        return cursosAsignados;
//    }

    @Override
    public String toString() {
        return "DNI:" + NumeroCedula + ", Nombres:" + Nombre  +" "+ Apellido +  "\n";
    }

}
