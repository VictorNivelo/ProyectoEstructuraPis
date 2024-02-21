
package Modelo;


/**
 *
 * @author Victor
 */
public class Horario {
    private Integer IdH;
    private String CodigoH;
    private String DiaH;
    private String HoraInicioH;
    private String HoraFinH;
    
    private Materia materiaHorario;
    private Integer idMateria;

    public Horario() {
        
    }

    public Integer getIdHorario() {
        return IdH;
    }

    public void setIdHorario(Integer IdHorario) {
        this.IdH = IdHorario;
    }

    public String getDiaSemana() {
        return DiaH;
    }

    public void setDiaSemana(String DiaSemana) {
        this.DiaH = DiaSemana;
    }

    public String getHoraIncio() {
        return HoraInicioH;
    }

    public void setHoraIncio(String HoraIncio) {
        this.HoraInicioH = HoraIncio;
    }

    public String getHoraFin() {
        return HoraFinH;
    }

    public void setHoraFin(String HoraFin) {
        this.HoraFinH = HoraFin;
    }

    public Materia getMateriaHorario() {
        return materiaHorario;
    }

    public void setMateriaHorario(Materia materiaHorario) {
        this.materiaHorario = materiaHorario;
    }

    public String getCodigoHorario() {
        return CodigoH;
    }

    public void setCodigoHorario(String CodigoHorario) {
        this.CodigoH = CodigoHorario;
    }

    public Integer getMateriaID() {
        return idMateria;
    }

    public void setMateriaID(Integer MateriaID) {
        this.idMateria = MateriaID;
    }
    
    @Override
    public String toString() {
        return DiaH  + "  H "+ HoraInicioH + " - " + HoraFinH + "\n";
    }
    
}
