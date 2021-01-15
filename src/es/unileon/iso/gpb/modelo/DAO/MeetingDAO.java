/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.DAO;

import es.unileon.iso.gpb.modelo.activities.Meeting;
import es.unileon.iso.gpb.modelo.connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Roberto
 */
public class MeetingDAO extends DBConnection {

    public boolean createMeeting(Meeting mt, int Id, String tId, String tName) {

        try {

            this.abrirConexion();

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM user WHERE UserName=(?)");
            query.setString(1, tName);
            ResultSet rs = query.executeQuery();

            PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO lecture (ActivityID, Place, TeaID, TeaID2) VALUES (?,?,?,?)");

            stat.setString(1, String.valueOf(Id));
            stat.setString(2, mt.getPlace());
            stat.setString(3, tId);
            if (rs.next()) {
                stat.setString(4, rs.getString("userName"));
            }

            stat.executeUpdate();

            this.closeC();
        } catch (Exception e) {
            System.out.println(e);
            //Llamar a controlador para sacar mensaje por vista TODO
        }
        return true;

    }
    //TODO
}
