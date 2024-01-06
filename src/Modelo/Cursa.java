/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.TDA.ListaDinamica.Exepciones.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class Cursa {
    private Integer idCurso;
    private String codigoCurso;
    private String paralelo;
    private Materia materiaCurso;
    private ListaDinamica<Materia> listaMateriasCurso;
    private PeriodoAcademico periodoAcademicoCurso;

    public Cursa() {
        
    }

    public Cursa(Integer idCurso, String codigoCurso, String paralelo, Materia materiaCurso, PeriodoAcademico periodoAcademicoCurso) {
        this.idCurso = idCurso;
        this.codigoCurso = codigoCurso;
        this.paralelo = paralelo;
        this.materiaCurso = materiaCurso;
        this.periodoAcademicoCurso = periodoAcademicoCurso;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    public Materia getMateriaCurso() {
        return materiaCurso;
    }

    public void setMateriaCurso(Materia materiaCurso) {
        this.materiaCurso = materiaCurso;
    }

    public PeriodoAcademico getPeriodoAcademicoCurso() {
        return periodoAcademicoCurso;
    }

    public void setPeriodoAcademicoCurso(PeriodoAcademico periodoAcademicoCurso) {
        this.periodoAcademicoCurso = periodoAcademicoCurso;
    }

    public ListaDinamica<Materia> getListaMateriasCurso() {
        return listaMateriasCurso;
    }

    public void setListaMateriasCurso(ListaDinamica<Materia> listaMateriasCurso) {
        this.listaMateriasCurso = listaMateriasCurso;
    }
    
    //Codigo para usar en la lista de materjas
    public void agregarMateria(Materia materia) {
        listaMateriasCurso.Agregar(materia);
    }

    public Materia obtenerMateria(Integer indice) throws ListaVacia, IndexOutOfBoundsException {
        return listaMateriasCurso.getInfo(indice);
    }

    public void eliminarMateria(Integer indice) throws ListaVacia, IndexOutOfBoundsException {
        listaMateriasCurso.eliminar(indice);
    }
    
    @Override
    public String toString() {
        return materiaCurso.getCicloMateria().getNombreCiclo() +" "+paralelo+ "\n";
    }
    
}
