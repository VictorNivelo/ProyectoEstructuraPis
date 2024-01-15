
package Modelo;

import Controlador.TDA.ListaDinamica.Exepciones.ListaVacia;
import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class Alumno {
    private Integer idAlumno;
    private Persona datosAlumno;
    private Boolean estado;
    private Matricula matriculaAlumno;
    private ListaDinamica<Matricula> ListaMatriculas;
    
    private ListaDinamica<Cursa> cursosAsignados;

    public Alumno() {
        
    }

    public Alumno(Integer idAlumno, Persona datosAlumno, Boolean estado, Matricula matriculaAlumno) {
        this.idAlumno = idAlumno;
        this.datosAlumno = datosAlumno;
        this.estado = estado;
        this.matriculaAlumno = matriculaAlumno;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Persona getDatosAlumno() {
        return datosAlumno;
    }

    public void setDatosAlumno(Persona datosAlumno) {
        this.datosAlumno = datosAlumno;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Matricula getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public void setMatriculaAlumno(Matricula matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }
    
    public void agregarCursoAsignado(Cursa curso) {
        cursosAsignados.Agregar(curso);
    }

    public ListaDinamica<Cursa> getCursosAsignados() {
        return cursosAsignados;
    }

    public Cursa obtenerCursoAsignado(Integer indice) throws ListaVacia, IndexOutOfBoundsException {
        return cursosAsignados.getInfo(indice);
    }

    public void eliminarCursoAsignado(Integer indice) throws ListaVacia, IndexOutOfBoundsException {
        cursosAsignados.eliminar(indice);
    }

    @Override
    public String toString() {
        return "idAlumno=" + idAlumno + ", datosAlumno=" + datosAlumno + ", estado=" + estado + ", matriculaAlumno=" + matriculaAlumno + "\n";
    }
    
}
