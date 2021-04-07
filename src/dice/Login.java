/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;

/**
 *
 * @author gui_o
 */
public class Login {
    String rota, usuario, senha;

    @Override
    public String toString() {
        return "Login{" + "rota=" + rota + ", usuario=" + usuario + ", senha=" + senha + '}';
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }   
    
}
