package crud;

import bd.ConnectionFactory;
import entities.Monitoring;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme Ortiz
 */
public class MonitoringDAO {
    public boolean create(Monitoring m) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO monitoria (nome, senha, nome_usuario)VALUES(?,?,?)");
            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getSenha());
          //stmt.setInt(3, m.getFk_pk_usuario());
            stmt.setString(3, m.getNomeUsuario());

            stmt.executeUpdate();
            
            ConnectionFactory.closeConnection(con, stmt);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } 
    }
    
    //Read
    public List<Monitoring> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Monitoring> monitorings = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM monitoria");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Monitoring monitoring = new Monitoring();

                monitoring.setPk_monitoria(rs.getInt("pk_monitoria"));
                monitoring.setFk_pk_usuario(rs.getInt("fk_pk_usuario"));
                monitoring.setNome(rs.getString("nome"));
                monitoring.setSenha(rs.getString("senha"));
                monitoring.setNomeUsuario(rs.getString("nomeUsuario"));
                monitorings.add(monitoring);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MonitoringDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return monitorings;

    }
    
    //Update
    public boolean update(Monitoring m) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE monitoria SET nome = ?, senha = ?, fk_pk_usuario = ? WHERE pk_monitoria = ?");
            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getSenha());
            stmt.setInt(3, m.getFk_pk_usuario());
            stmt.setInt(4, m.getPk_monitoria());

            stmt.executeUpdate();
            
            ConnectionFactory.closeConnection(con, stmt);
             
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            
            return false;
        } 

    }
    
    //Delete
    public boolean delete(Monitoring m) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM monitoria WHERE pk_monitoria() = ?");
            stmt.setInt(1, m.getPk_monitoria());

            stmt.executeUpdate();
            
            ConnectionFactory.closeConnection(con, stmt);
            
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } 

    }
}
