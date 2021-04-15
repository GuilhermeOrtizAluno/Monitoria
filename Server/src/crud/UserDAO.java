/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import bd.ConnectionFactory;
import com.google.gson.Gson;
import dice.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme Ortiz
 */
public class UserDAO {

    // Create
    public boolean create(User u) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO usuario (usuario, nome, senha, is_admin, is_monitor)VALUES(?,?,?,?,?)");
            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getSenha());
            stmt.setBoolean(4, u.isIs_admin());
            stmt.setBoolean(5, u.isIs_monitor());

            stmt.executeUpdate();
           
            //Gson gson = new Gson();
            //System.out.println(gson.toJson(u));
           
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return true;
    }

    //Read
    public List<User> read() {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<User> users = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();

            while (rs.next()) {

                User user = new User();

                user.setPk_usuario(rs.getInt("pk_usuario"));
                user.setUsuario(rs.getString("usuario"));
                user.setNome(rs.getString("nome"));
                user.setSenha(rs.getString("senha"));
                user.setIs_monitor(rs.getBoolean("is_monitor"));
                user.setIs_admin(rs.getBoolean("is_admin"));
                users.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return users;

    }

    //Update
    public boolean update(User u) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE usuario SET senha = ? WHERE usuario = ?");
            //stmt = con.prepareStatement("UPDATE usuario SET usuario = ?, senha = ? WHERE pk_usuario = ?");
            //stmt.setString(1, u.getUsuario());
            stmt.setString(1, u.getSenha());
            //stmt.setBoolean(4, u.isIs_admin());
            //stmt.setBoolean(5, u.isIs_monitor());
            stmt.setString(2, u.getUsuario());

            stmt.executeUpdate();

            //JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return true;
    }

    //Delete
    public boolean delete(User u) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM usuario WHERE usuario = ?");
            //stmt.setInt(1, u.getPk_usuario());
            stmt.setString(1, u.getUsuario());

            stmt.executeUpdate();

            //JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return true;
    }

    //search
    public User search(User u) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        User user = new User();

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE usuario = ? AND senha = ?");
            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getSenha());
            rs = stmt.executeQuery();

            while (rs.next()) {
                user.setPk_usuario(rs.getInt("pk_usuario"));
                user.setUsuario(rs.getString("usuario"));
                user.setNome(rs.getString("nome"));
                user.setIs_admin(rs.getBoolean("is_admin"));
                user.setIs_monitor(rs.getBoolean("is_monitor"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return user;
    }
}
