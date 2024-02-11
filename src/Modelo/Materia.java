
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
    private Cursa cursoMateria;
    private ListaDinamica<Cursa> listaCursaMateria;
    private Docente docenteMateria;
    
    public Materia() {
        
    }

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

    public Ciclo getCicloMateria() {
        return cicloMateria;
    }

    public void setCicloMateria(Ciclo cicloMateria) {
        this.cicloMateria = cicloMateria;
    }

    public Cursa getCursoMateria() {
        return cursoMateria;
    }

    public void setCursoMateria(Cursa cursoMateria) {
        this.cursoMateria = cursoMateria;
    }

    public Docente getDocenteMateria() {
        return docenteMateria;
    }

    public void setDocenteMateria(Docente docenteMateria) {
        this.docenteMateria = docenteMateria;
    }

    public ListaDinamica<Cursa> getListaCursaMateria() {
        return listaCursaMateria;
    }

    public void setListaCursaMateria(ListaDinamica<Cursa> listaCursaMateria) {
        this.listaCursaMateria = listaCursaMateria;
    }
    
    @Override
    public String toString() {
        return NombreMateria+"\n";
    }
    
}
