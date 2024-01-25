
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class Materia {
    private Integer IdMateria;
    private String NombreMateria;
    private String DescipcionMateria;
    private String NumeroHoras;
    
    private Ciclo cicloMateria;
    
    //datos poco uasdos
    private ListaDinamica<Ciclo> listaCicloMateria;
    
    private Horario horarioMateria;
    private ListaDinamica<Horario> listaHorarioMateria;
    
    public Materia() {
        
    }

//    public Materia(Integer IdMateria, String NombreMateria, String DescipcionMateria, String NumeroHoras, Horario horarioMateria, Ciclo cicloMateria) {
//        this.IdMateria = IdMateria;
//        this.NombreMateria = NombreMateria;
//        this.DescipcionMateria = DescipcionMateria;
//        this.NumeroHoras = NumeroHoras;
//        this.horarioMateria = horarioMateria;
//        this.cicloMateria = cicloMateria;
//    }

    public Integer getIdMateria() {
        return IdMateria;
    }

    public void setIdMateria(Integer IdMateria) {
        this.IdMateria = IdMateria;
    }

    public String getNombreMateria() {
        return NombreMateria;
    }

    public void setNombreMateria(String NombreMateria) {
        this.NombreMateria = NombreMateria;
    }

    public String getDescipcionMateria() {
        return DescipcionMateria;
    }

    public void setDescipcionMateria(String DescipcionMateria) {
        this.DescipcionMateria = DescipcionMateria;
    }

    public String getNumeroHoras() {
        return NumeroHoras;
    }

    public void setNumeroHoras(String NumeroHoras) {
        this.NumeroHoras = NumeroHoras;
    }

    public Horario getHorarioMateria() {
        return horarioMateria;
    }

    public void setHorarioMateria(Horario horarioMateria) {
        this.horarioMateria = horarioMateria;
    }

    public ListaDinamica<Horario> getListaHorarioMateria() {
        return listaHorarioMateria;
    }

    public void setListaHorarioMateria(ListaDinamica<Horario> listaHorarioMateria) {
        this.listaHorarioMateria = listaHorarioMateria;
    }

    public Ciclo getCicloMateria() {
        return cicloMateria;
    }

    public void setCicloMateria(Ciclo cicloMateria) {
        this.cicloMateria = cicloMateria;
    }

    public ListaDinamica<Ciclo> getListaCicloMateria() {
        return listaCicloMateria;
    }

    public void setListaCicloMateria(ListaDinamica<Ciclo> listaCicloMateria) {
        this.listaCicloMateria = listaCicloMateria;
    }

    @Override
    public String toString() {
        return NombreMateria+"\n";
    }
    
}
