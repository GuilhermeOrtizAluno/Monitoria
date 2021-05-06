package entities;

import org.json.JSONArray;

/**
 *
 * @author Guilherme Ortiz
 */
public class Monitoring {
    private int id;
    private String nome;
    private String senha;
    private int id_usuario;
    private String usuario_monitor;
    //private JSONArray horarios;

    /*public JSONArray getHorarios() {
        return horarios;
    }

    public void setHorarios(JSONArray horarios) {
        this.horarios = horarios;
    }*/

    public String getUsuario_monitor() {
        return usuario_monitor;
    }

    public void setUsuario_monitor(String usuario_monitor) {
        this.usuario_monitor = usuario_monitor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int fk_pk_usuario) {
        this.id_usuario = fk_pk_usuario;
    }
    
    
}
