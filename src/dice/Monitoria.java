package dice;

/**
 *
 * @author Guilherme Ortiz
 */
public class Monitoria {
    private int pk_monitoria;
    private String nome;
    private String senha;
    private int fk_pk_usuario;

    public int getPk_monitoria() {
        return pk_monitoria;
    }

    public void setPk_monitoria(int pk_monitoria) {
        this.pk_monitoria = pk_monitoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getFk_pk_usuario() {
        return fk_pk_usuario;
    }

    public void setFk_pk_usuario(int fk_pk_usuario) {
        this.fk_pk_usuario = fk_pk_usuario;
    }
    
    
}
