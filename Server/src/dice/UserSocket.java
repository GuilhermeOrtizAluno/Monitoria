/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;

import entities.User;
import java.io.BufferedReader;
import java.net.Socket;

/**
 *
 * @author Maycon
 */
public class UserSocket {
    private Socket socket;
    private User user;
    private BufferedReader bf;
    
    public UserSocket(Socket socket, BufferedReader bf) {
        this.socket = socket;
        this.bf = bf;
    }

    public BufferedReader getBf() {
        return bf;
    }

    public void setBf(BufferedReader bf) {
        this.bf = bf;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
