package dice;

/**
 *
 * @author Guilherme Ortiz
 */
public class Student {
    private int pk_aluno_monitoria;
    private int fk_pk_monitoria;
    private int fk_pk_usuario;

    public int getPk_aluno_monitoria() {
        return pk_aluno_monitoria;
    }

    public void setPk_aluno_monitoria(int pk_aluno_monitoria) {
        this.pk_aluno_monitoria = pk_aluno_monitoria;
    }

    public int getFk_pk_monitoria() {
        return fk_pk_monitoria;
    }

    public void setFk_pk_monitoria(int fk_pk_monitoria) {
        this.fk_pk_monitoria = fk_pk_monitoria;
    }

    public int getFk_pk_usuario() {
        return fk_pk_usuario;
    }

    public void setFk_pk_usuario(int fk_pk_usuario) {
        this.fk_pk_usuario = fk_pk_usuario;
    }
    
    
}
