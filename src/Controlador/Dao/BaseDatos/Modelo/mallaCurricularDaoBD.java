
package Controlador.Dao.BaseDatos.Modelo;

import Controlador.Dao.BaseDatos.AdaptadorDaoBD;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.MallaCurricular;
import java.io.IOException;

/**
 *
 * @author Victor
 */
public class mallaCurricularDaoBD extends AdaptadorDaoBD<MallaCurricular> {

    private ListaDinamica<MallaCurricular> ListaAsistencias;
    private MallaCurricular asistencias = new MallaCurricular();
    private Integer Indice = -1;

    public mallaCurricularDaoBD() {
        super(MallaCurricular.class);
        this.ListaAsistencias = new ListaDinamica<>();
    }

    public ListaDinamica<MallaCurricular> getListaAlumno() {
        if (ListaAsistencias.EstaVacio()) {
            ListaAsistencias = this.listar();
        }
        return ListaAsistencias;
    }

    public void setListaAlumno(ListaDinamica<MallaCurricular> ListaAlumno) {
        this.ListaAsistencias = ListaAlumno;
    }

    public MallaCurricular getAlumno() {
        return asistencias;
    }

    public void setAlumno(MallaCurricular alumno) {
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
