package entities;

/**
 *
 * @author Guilherme Ortiz
 */
public class Student {
    private int pk_aluno_monitoria;
    private String id;
    private String usuario_aluno;

    public int getPk_aluno_monitoria() {
        return pk_aluno_monitoria;
    }

    public void setPk_aluno_monitoria(int pk_aluno_monitoria) {
        this.pk_aluno_monitoria = pk_aluno_monitoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario_aluno() {
        return usuario_aluno;
    }

    public void setUsuario_aluno(String usuario_aluno) {
        this.usuario_aluno = usuario_aluno;
    }   
}
