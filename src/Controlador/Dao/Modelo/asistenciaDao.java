
package Controlador.Dao.Modelo;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Asistencia;

/**
 *
 * @author Victor
 */
public class asistenciaDao extends DaoImplement<Asistencia>{
    private ListaDinamica<Asistencia> listaAsistencia = new ListaDinamica<>();
    private Asistencia asistencias;
    
    public asistenciaDao(){
        super (Asistencia.class);
    }

    public ListaDinamica<Asistencia> getListaAsistencia() {
        listaAsistencia = all();
        return listaAsistencia;
    }

    public void setListaAsistencia(ListaDinamica<Asistencia> listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
    }

    public Asistencia getAsistencias() {
        if(asistencias == null){
            asistencias = new Asistencia();
        }
        return asistencias;
    }

    public void setAsistencias(Asistencia asistencias) {
        this.asistencias = asistencias;
    }

    public Boolean Persist(){
        asistencias.setIdAsistencia(all().getLongitud()+1);
        return Persist(asistencias);
    }
    
}
