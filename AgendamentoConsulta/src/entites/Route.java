/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author gui_o
 */
public class Route {
    String rota;
    String erro;
    String tipo_usuario;

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }
    
    public String getErro() {
        return erro;
    }

    public void setErro(String rota) {
        this.erro = rota;
    }
    

    @Override
    public String toString() {
        return "Login{" + "rota=" + rota + ", erro=" + erro + "}";
    }
    
}
