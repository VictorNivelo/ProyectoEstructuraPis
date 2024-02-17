
package Controlador.Dao.Modelo;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.CodigoCurso;

/**
 *
 * @author Victor
 */
public class codigoCursoDao extends DaoImplement<CodigoCurso>{
    private ListaDinamica<CodigoCurso> ListaCodigoCurso = new ListaDinamica<>();
    private CodigoCurso codigosCursos;
    
    public codigoCursoDao(){
        super (CodigoCurso.class);
    }

    public ListaDinamica<CodigoCurso> getListaCodigoCurso() {
        ListaCodigoCurso = all();
        return ListaCodigoCurso;
    }

    public void setListaCodigoCurso(ListaDinamica<CodigoCurso> ListaCodigoCurso) {
        this.ListaCodigoCurso = ListaCodigoCurso;
    }

    public CodigoCurso getCodigosCursos() {
        if(codigosCursos == null){
            codigosCursos = new  CodigoCurso();
        }
        return codigosCursos;
    }

    public void setCodigosCursos(CodigoCurso codigosCursos) {
        this.codigosCursos = codigosCursos;
    }
    
    public Boolean Persist(){
        codigosCursos.setIdCodigoCurso(all().getLongitud()+1);
        return Persist(codigosCursos);
    }
    
}
