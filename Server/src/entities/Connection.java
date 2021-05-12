/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.PrintWriter;


/**
 *
 * @author Maycon
 */
public class Connection {
    private PrintWriter pw;
    
    private User user;

    public Connection(PrintWriter pw) {
        this.pw = pw;
    }

    public PrintWriter getPw() {
        return pw;
    }

    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    
}
