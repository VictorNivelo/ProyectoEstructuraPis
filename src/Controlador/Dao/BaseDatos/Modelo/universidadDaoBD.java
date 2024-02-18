
package Controlador.Dao.BaseDatos.Modelo;

import Controlador.Dao.BaseDatos.AdaptadorDaoBD;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.Universidad;
import java.io.IOException;

/**
 *
 * @author Victor
 */
public class universidadDaoBD extends AdaptadorDaoBD<Universidad> {

    private ListaDinamica<Universidad> ListaAsistencias;
    private Universidad asistencias = new Universidad();
    private Integer Indice = -1;

    public universidadDaoBD() {
        super(Universidad.class);
        this.ListaAsistencias = new ListaDinamica<>();
    }

    public ListaDinamica<Universidad> getListaAlumno() {
        if (ListaAsistencias.EstaVacio()) {
            ListaAsistencias = this.listar();
        }
        return ListaAsistencias;
    }

    public void setListaAlumno(ListaDinamica<Universidad> ListaAlumno) {
        this.ListaAsistencias = ListaAlumno;
    }

    public Universidad getAlumno() {
        return asistencias;
    }

    public void setAlumno(Universidad alumno) {
        this.asistencias = alumno;
    }

    public Integer getIndice() {
        return Indice;
    }

    public void setIndice(Integer Indice) {
        this.Indice = Indice;
    }

    public Boolean GuardarBD() throws Exception {
        return super.saveB(this.asistencias);
    }

    public Boolean Modificar() throws IOException {
        try {
            modificar(this.asistencias);
            return true;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
