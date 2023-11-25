/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Cursa {
    private Integer idCurso;
    private String nombreCurso;
    private String DescripcionCurso;
    private Ciclo cicloCurso;
    private MallaCurricular mallaCurso;
    private Materia materiaCurso;
    private Horario horarioCurso;

    public Cursa() {
        
    }

    public Cursa(Integer idCurso, String nombreCurso, String DescripcionCurso, Ciclo cicloCurso, MallaCurricular mallaCurso, Materia materiaCurso, Horario horarioCurso) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.DescripcionCurso = DescripcionCurso;
        this.cicloCurso = cicloCurso;
        this.mallaCurso = mallaCurso;
        this.materiaCurso = materiaCurso;
        this.horarioCurso = horarioCurso;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDescripcionCurso() {
        return DescripcionCurso;
    }

    public void setDescripcionCurso(String DescripcionCurso) {
        this.DescripcionCurso = DescripcionCurso;
    }

    public Ciclo getCicloCurso() {
        return cicloCurso;
    }

    public void setCicloCurso(Ciclo cicloCurso) {
        this.cicloCurso = cicloCurso;
    }

    public MallaCurricular getMallaCurso() {
        return mallaCurso;
    }

    public void setMallaCurso(MallaCurricular mallaCurso) {
        this.mallaCurso = mallaCurso;
    }

    public Materia getMateriaCurso() {
        return materiaCurso;
    }

    public void setMateriaCurso(Materia materiaCurso) {
        this.materiaCurso = materiaCurso;
    }

    public Horario getHorarioCurso() {
        return horarioCurso;
    }

    public void setHorarioCurso(Horario horarioCurso) {
        this.horarioCurso = horarioCurso;
    }

    @Override
    public String toString() {
        return "Cursa{" + "idCurso=" + idCurso + ", nombreCurso=" + nombreCurso + ", DescripcionCurso=" + DescripcionCurso + ", cicloCurso=" + cicloCurso + ", mallaCurso=" + mallaCurso + ", materiaCurso=" + materiaCurso + ", horarioCurso=" + horarioCurso + '}';
    }
    
}
