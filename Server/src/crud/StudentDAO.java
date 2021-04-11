package crud;

import dice.Student;
import java.sql.Connection;
import bd.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class StudentDAO {
    
    //Create
    public void create(Student s) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO aluno_monit(fk_pk_monitoria, fk_pk_usuario)VALUES(?,?)");
            stmt.setInt(1, s.getFk_pk_monitoria());
            stmt.setInt(2, s.getFk_pk_usuario());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    //Read
    public List<Student> read(){

        List<Student> students = new ArrayList<Student>();

        Connection conn = ConnectionFactory.getConnection();
        
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            pstm = conn.prepareStatement("SELECT * FROM aluno_monit");

            rset = pstm.executeQuery();

            while (rset.next()) {

                Student student = new Student();

                student.setPk_aluno_monitoria(rset.getInt("pk_aluno_monitoria"));
                student.setFk_pk_monitoria(rset.getInt("fk_pk_monitoria"));
                student.setFk_pk_usuario(rset.getInt("fk_pk_usuario"));

                students.add(student);

            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rset);
        }

        return students;
    }

    //Update
    public void update(Student s) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE aluno_monit SET fk_pk_monitoria = ?, fk_pk_usuario = ? WHERE pk_aluno_monitoria = ?");
            stmt.setInt(1, s.getFk_pk_monitoria());
            stmt.setInt(2, s.getFk_pk_usuario());
            stmt.setInt(3, s.getPk_aluno_monitoria());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    //Delete
    public void delete(Student s) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM aluno_monit WHERE pk_aluno_monitoria = ?");
            stmt.setInt(1, s.getPk_aluno_monitoria());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
