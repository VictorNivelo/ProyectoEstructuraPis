/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import java.util.Date;

/**
 *
 * @author Victor
 */
public class Horario {
    private Integer idHorario;
    private Date DiaSemana;
    private String horaIncio;
    private String horaFin;
    private Asistencia HorarioAsistencia;
        
    private String Dias;
    private String tematicaHorario;

    public Horario() {
        
    }

    public Horario(Integer idHorario, String Dias, String horaIncio, String horaFin, String tematicaHorario) {
        this.idHorario = idHorario;
        this.Dias = Dias;
        this.horaIncio = horaIncio;
        this.horaFin = horaFin;
        this.tematicaHorario = tematicaHorario;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public String getDias() {
        return Dias;
    }

    public void setDias(String Dias) {
        this.Dias = Dias;
    }

    public String getHoraIncio() {
        return horaIncio;
    }

    public void setHoraIncio(String horaIncio) {
        this.horaIncio = horaIncio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getTematicaHorario() {
        return tematicaHorario;
    }

    public void setTematicaHorario(String tematicaHorario) {
        this.tematicaHorario = tematicaHorario;
    }
    
    @Override
    public String toString() {
        return "Dia:" + Dias + ",Hora Incio:" + horaIncio + ", Fin:" + horaFin + "\n";
    }
    
}
