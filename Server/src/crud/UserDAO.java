/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import bd.ConnectionFactory;
import entities.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
            stmt.setBoolean(4, false);
            stmt.setBoolean(5, u.isIs_monitor());

            stmt.executeUpdate();

            //Gson gson = new Gson();
            //System.out.println(gson.toJson(u));
            ConnectionFactory.closeConnection(con, stmt);
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }

    //Read
    public JSONArray read() throws JSONException {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        JSONArray users = new JSONArray();

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();

            while (rs.next()) {

                JSONObject user = new JSONObject();

                user.put("usuario", rs.getString("usuario"));
                user.put("nome", rs.getString("nome"));
                user.put("tipo_usuario",
                        rs.getBoolean("is_admin") ? "admin"
                        : rs.getBoolean("is_monitor") ? "monitor"
                        : "aluno"
                );
                users.put(user);
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

            if (u.getNovo_usuario() != null) {
                stmt = con.prepareStatement("UPDATE usuario SET usuario = ? WHERE usuario = ?");
                stmt.setString(1, u.getNovo_usuario());
                stmt.setString(2, u.getUsuario());
                
                stmt.executeUpdate();
                
                stmt = con.prepareStatement("UPDATE aluno_monit SET usuario_aluno = ? WHERE usuario_aluno = ?");
                stmt.setString(1, u.getNovo_usuario());
                stmt.setString(2, u.getUsuario());

                stmt.executeUpdate();

                stmt = con.prepareStatement("UPDATE monitoria SET usuario_monitor = ? WHERE usuario_monitor = ?");
                stmt.setString(1, u.getNovo_usuario());
                stmt.setString(2, u.getUsuario());

                stmt.executeUpdate();
            }
            
            if(u.getNome() != null){
                stmt = con.prepareStatement("UPDATE usuario SET nome = ? WHERE usuario = ?");
                stmt.setString(1, u.getNome());
                if(u.getNovo_usuario() == null){
                    stmt.setString(2, u.getUsuario());
                }else{
                    stmt.setString(2, u.getNovo_usuario());
                }
                
                stmt.executeUpdate();
            }

            if(u.getSenha() != null){
                stmt = con.prepareStatement("UPDATE usuario SET senha = ? WHERE usuario = ?");
                stmt.setString(1, u.getSenha());
                if(u.getNovo_usuario() == null){
                    stmt.setString(2, u.getUsuario());
                }else{
                    stmt.setString(2, u.getNovo_usuario());
                }
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
            ConnectionFactory.closeConnection(con, stmt);
            return false;
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

            if (u.getUsuario() != null) {
                stmt = con.prepareStatement("DELETE from aluno_monit WHERE usuario_aluno = ?");
                stmt.setString(1, u.getUsuario());

                stmt.executeUpdate();

                stmt = con.prepareStatement("UPDATE monitoria SET usuario_monitor = ? WHERE usuario_monitor = ?");
                stmt.setString(1, "");
                stmt.setString(2, u.getUsuario());

                stmt.executeUpdate();
            }

            //JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
            return false;
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
