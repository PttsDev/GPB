/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.DAO;

import es.unileon.iso.gpb.modelo.activities.Tutorship;
import es.unileon.iso.gpb.modelo.connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Roberto
 */
public class TutorshipDAO extends DBConnection {

    public boolean createTutorship(Tutorship ts, String sName, int Id, String tId) {

        try {

            this.abrirConexion();

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM user WHERE UserName=(?)");
            query.setString(1, sName);
            ResultSet rs = query.executeQuery();

            PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO lecture (ActivityID, Place, StuID, TeaID) VALUES (?,?,?,?)");

            stat.setString(1, String.valueOf(Id));
            stat.setString(2, ts.getPlace());
            if (rs.next()) {
                stat.setString(3,rs.getString("UserID"));
            }
            stat.setString(4, tId);

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
