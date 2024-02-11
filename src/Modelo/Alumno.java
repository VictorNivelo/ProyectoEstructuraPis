
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class Alumno {
    private Integer IdAlumno;
    private String EstadoAlumno;
    
    private Persona DatosAlumno;
    
    private ListaDinamica<Matricula> listaMatriculaAlumno;

    public Alumno() {
        
    }

    public Integer getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(Integer IdAlumno) {
        this.IdAlumno = IdAlumno;
    }

    public String getEstadoAlumno() {
        return EstadoAlumno;
    }

    public void setEstadoAlumno(String EstadoAlumno) {
        this.EstadoAlumno = EstadoAlumno;
    }

    public Persona getDatosAlumno() {
        return DatosAlumno;
    }

    public void setDatosAlumno(Persona DatosAlumno) {
        this.DatosAlumno = DatosAlumno;
    }
    
    public void AgregarMatricula(Matricula matricula) {
        listaMatriculaAlumno.Agregar(matricula);
    }

    public ListaDinamica<Matricula> getListaMatriculaAlumno() {
        return listaMatriculaAlumno;
    }

    public void setListaMatriculaAlumno(ListaDinamica<Matricula> listaMatriculaAlumno) {
        this.listaMatriculaAlumno = listaMatriculaAlumno;
    }
    
    @Override
    public String toString() {
        return "DNI" + DatosAlumno.getNumeroCedula() + " Nombres: " + DatosAlumno.getNombre() +" " +DatosAlumno.getApellido()+ "\n";
    }
    
}
