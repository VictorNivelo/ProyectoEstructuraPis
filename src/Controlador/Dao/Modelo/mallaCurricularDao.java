/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Dao.Modelo;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Modelo.MallaCurricular;

/**
 *
 * @author Victor
 */
public class mallaCurricularDao extends DaoImplement<MallaCurricular> {

    private ListaDinamica<MallaCurricular> ListaMalla = new ListaDinamica<>();
    private MallaCurricular mallaCurricular;
    
    public mallaCurricularDao() {
        super(MallaCurricular.class);
    }

    public ListaDinamica<MallaCurricular> getListaMalla() {
        ListaMalla = all();
        return ListaMalla;
    }

    public void setListaMalla(ListaDinamica<MallaCurricular> ListaCarreras) {
        this.ListaMalla = ListaCarreras;
    }

    public MallaCurricular getMallaCurricular() {
        if(mallaCurricular == null){
            mallaCurricular = new MallaCurricular();
        }
        return mallaCurricular;
    }

    public void setMallaCurricular(MallaCurricular mallaCurricular) {
        this.mallaCurricular = mallaCurricular;
    }
    
    public Boolean Persist() {
        mallaCurricular.setIdMallaCurricular(all().getLongitud() + 1);
        return Persist(mallaCurricular);
    }
}
