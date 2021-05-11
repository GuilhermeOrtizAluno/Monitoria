package entities;

/**
 *
 * @author Guilherme Ortiz
 */
public class Schedule {
    private int pk_horario_monitoria;
    private String horarios;
    private int id_monitoria;

    public int getPk_horario_monitoria() {
        return pk_horario_monitoria;
    }

    public void setPk_horario_monitoria(int pk_horario_monitoria) {
        this.pk_horario_monitoria = pk_horario_monitoria;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public int getId_monitoria() {
        return id_monitoria;
    }

    public void setId_monitoria(int id_monitoria) {
        this.id_monitoria = id_monitoria;
    }
}