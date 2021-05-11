package crud;

import entities.Student;
import java.sql.Connection;
import bd.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class StudentDAO {
    
    //Create
    public boolean create(Student s) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO aluno_monit(fk_pk_monitoria, usuario_aluno)VALUES(?,?)");
            stmt.setInt(1, Integer.parseInt(s.getId()));
            stmt.setString(2, s.getUsuario_aluno());

            stmt.executeUpdate();

            ConnectionFactory.closeConnection(con, stmt);
            
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } 

    }
    
    //Delete
    public boolean delete(Student s) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM aluno_monit WHERE usuario_aluno = ? and fk_pk_monitoria = ?");
            stmt.setString(1, s.getUsuario_aluno());
            stmt.setInt(2, Integer.parseInt(s.getId()));

            stmt.executeUpdate();

            ConnectionFactory.closeConnection(con, stmt);
            
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } 
    }
}
