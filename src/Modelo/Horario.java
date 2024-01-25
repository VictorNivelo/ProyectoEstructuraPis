
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 */
public class Horario {
    private Integer IdHorario;
    private String DiaSemana;
    private String HoraIncio;
    private String HoraFin;
    
    private Asistencia asistenciaHorario;
    private ListaDinamica<Asistencia> listaAsistenciaHorario;
        
    public Horario() {
        
    }

    public Horario(Integer IdHorario, String DiaSemana, String HoraIncio, String HoraFin, Asistencia asistenciaHorario) {
        this.IdHorario = IdHorario;
        this.DiaSemana = DiaSemana;
        this.HoraIncio = HoraIncio;
        this.HoraFin = HoraFin;
        this.asistenciaHorario = asistenciaHorario;
    } 

    public Integer getIdHorario() {
        return IdHorario;
    }

    public void setIdHorario(Integer IdHorario) {
        this.IdHorario = IdHorario;
    }

    public String getDiaSemana() {
        return DiaSemana;
    }

    public void setDiaSemana(String DiaSemana) {
        this.DiaSemana = DiaSemana;
    }

    public String getHoraIncio() {
        return HoraIncio;
    }

    public void setHoraIncio(String HoraIncio) {
        this.HoraIncio = HoraIncio;
    }

    public String getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(String HoraFin) {
        this.HoraFin = HoraFin;
    }

    public Asistencia getAsistenciaHorario() {
        return asistenciaHorario;
    }

    public void setAsistenciaHorario(Asistencia asistenciaHorario) {
        this.asistenciaHorario = asistenciaHorario;
    }

    public ListaDinamica<Asistencia> getListaAsistenciaHorario() {
        return listaAsistenciaHorario;
    }

    public void setListaAsistenciaHorario(ListaDinamica<Asistencia> listaAsistenciaHorario) {
        this.listaAsistenciaHorario = listaAsistenciaHorario;
    }
    
    @Override
    public String toString() {
        return "DiaSemana:" + DiaSemana + ", Incio:" + HoraIncio + ", horaFin:" + HoraFin + "\n";
    }
    
}
