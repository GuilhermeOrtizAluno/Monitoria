package crud;

import bd.ConnectionFactory;
import entities.Schedule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScheduleDAO {
    //Create
    public boolean create(Schedule s) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO horario_monit(horario,fk_pk_monitoria)VALUES(?,?)");
            stmt.setString(1, s.getHorario());
            stmt.setInt(2, s.getFk_pk_monitoria());
            
            stmt.executeUpdate();
            
            ConnectionFactory.closeConnection(con, stmt);
            
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } 

    }
    
    //Read
    public List<Schedule> read(){

        List<Schedule> schedules = new ArrayList<Schedule>();

        Connection conn = ConnectionFactory.getConnection();
        
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            pstm = conn.prepareStatement("SELECT * FROM horario_monit");

            rset = pstm.executeQuery();

            while (rset.next()) {

                Schedule schedule = new Schedule();

                schedule.setPk_horario_monitoria(rset.getInt("pk_horario_monitoria"));
                schedule.setFk_pk_monitoria(rset.getInt("fk_pk_monitoria"));
                schedule.setHorario(rset.getString("horario"));

                schedules.add(schedule);

            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rset);
        }

        return schedules;
    }

    //Update
    public boolean update(Schedule s) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE horario_monit SET horario = ?, fk_pk_monitoria = ? WHERE pk_horario_monitoria = ?");
            stmt.setString(1, s.getHorario());
            stmt.setInt(2, s.getFk_pk_monitoria());
            stmt.setInt(3, s.getPk_horario_monitoria());

            stmt.executeUpdate();

            ConnectionFactory.closeConnection(con, stmt);
            
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } 
    }
    
    //Delete
    public boolean delete(Schedule s) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM horario_monit WHERE pk_horario_monitoria = ?");
            stmt.setInt(1, s.getPk_horario_monitoria());

            stmt.executeUpdate();

            ConnectionFactory.closeConnection(con, stmt);
            
            return true;
        } catch (SQLException ex) {
             System.out.println(ex);
            return false;
        } 
    }
}
