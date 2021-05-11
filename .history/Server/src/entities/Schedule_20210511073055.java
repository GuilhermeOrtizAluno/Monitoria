package entities;

/**
 *
 * @author Guilherme Ortiz
 */
public class Schedule {
    private int pk_horario_monitoria;
    private String horario;
    private int id_monitoria;

    public int getPk_horario_monitoria() {
        return pk_horario_monitoria;
    }

    public void setPk_horario_monitoria(int pk_horario_monitoria) {
        this.pk_horario_monitoria = pk_horario_monitoria;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorarios(String horario) {
        this.horario = horario;
    }

    public int getId_monitoria() {
        return id_monitoria;
    }

    public void setId_monitoria(int id_monitoria) {
        this.id_monitoria = id_monitoria;
    }
}