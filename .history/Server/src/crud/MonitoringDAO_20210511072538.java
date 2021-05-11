package crud;

import bd.ConnectionFactory;
import entities.Monitoring;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Guilherme Ortiz
 */
public class MonitoringDAO {

    public boolean create(Monitoring m) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO monitoria (nome, senha, usuario_monitor)VALUES(?,?,?)");
            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getSenha());
            stmt.setString(3, m.getUsuario_monitor());

            stmt.executeUpdate();

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

        JSONArray monitorings = new JSONArray();

        try {
            stmt = con.prepareStatement("SELECT * FROM monitoria");
            rs = stmt.executeQuery();

            while (rs.next()) {
                PreparedStatement st = con.prepareStatement("SELECT * FROM usuario WHERE usuario = ?");
                st.setString(1, rs.getString("usuario_monitor"));
                ResultSet r = st.executeQuery();

                JSONObject monitoring = new JSONObject();

                monitoring.put("nome", rs.getString("nome"));
                monitoring.put("id", rs.getInt("pk_monitoria"));
                monitoring.put("usuario_monitor", rs.getString("usuario_monitor"));

                r.next();
                monitoring.put("nome_monitor", r.getString("nome"));

                PreparedStatement sth = con.prepareStatement("SELECT * FROM horario_monit WHERE fk_pk_monitoria = ?");
                sth.setInt(1, rs.getInt("pk_monitoria"));
                ResultSet rh = sth.executeQuery();

                JSONArray arr = new JSONArray();

                if (rh != null) {
                    while (rh.next()) {
                        arr.put(rh.getString("horario"));
                    }
                    monitoring.put("horarios", arr);
                }
                monitorings.put(monitoring);
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
            stmt = con.prepareStatement("UPDATE monitoria SET nome = ?, senha = ?, usuario_monitor = ? WHERE pk_monitoria = ?");
            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getSenha());
            stmt.setString(3, m.getUsuario_monitor());
            stmt.setInt(4, m.getId());

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
            stmt = con.prepareStatement("DELETE FROM monitoria WHERE pk_monitoria = ?");
            stmt.setInt(1, m.getId());

            stmt.executeUpdate();

            ConnectionFactory.closeConnection(con, stmt);

            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
}