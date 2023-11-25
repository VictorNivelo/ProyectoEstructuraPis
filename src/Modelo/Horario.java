/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Horario {
    private Integer idHorario;
    private String Dias;
    private String horaIncio;
    private String horaFin;

    public Horario() {
        
    }

    public Horario(Integer idHorario, String Dias, String horaIncio, String horaFin) {
        this.idHorario = idHorario;
        this.Dias = Dias;
        this.horaIncio = horaIncio;
        this.horaFin = horaFin;
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

    @Override
    public String toString() {
        return "Horario{" + "idHorario=" + idHorario + ", Dias=" + Dias + ", horaIncio=" + horaIncio + ", horaFin=" + horaFin + '}';
    }
    
}
