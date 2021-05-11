package entities;

/**
 *
 * @author Guilherme Ortiz
 */
public class Schedule {
    private int pk_horario_monitoria;
    private String horario;
    private int fk_pk_monitoria;

    public int getPk_horario_monitoria() {
        return pk_horario_monitoria;
    }

    public void setPk_horario_monitoria(int pk_horario_monitoria) {
        this.pk_horario_monitoria = pk_horario_monitoria;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getFk_pk_monitoria() {
        return fk_pk_monitoria;
    }

    public void setFk_pk_monitoria(int fk_pk_monitoria) {
        this.fk_pk_monitoria = fk_pk_monitoria;
    }
    
    
}
