
package Modelo;

/**
 *
 * @author Victor
 */
public class ControlAccesoDocente {
    
    private static Docente docenteLogeado;

    public static Docente getDocenteLogeado() {
        return docenteLogeado;
    }

    public static void setDocenteLogeado(Docente docente) {
        docenteLogeado = docente;
    }
    
    public static Integer getIdDocenteLogeado() {
        if (docenteLogeado != null) {
            return docenteLogeado.getIdDocente();
        } 
        else {
            return null;
        }
    }
}
