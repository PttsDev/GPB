/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.DAO;

import es.unileon.iso.gpb.modelo.activities.Meeting;
import es.unileon.iso.gpb.modelo.activities.Tutorship;
import es.unileon.iso.gpb.modelo.connection.DBConnection;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

            PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO meeting (ActivityID, Place, TeaID, Tea2ID) VALUES (?,?,?,?)");

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
       public ArrayList<Meeting> listMeeting(String teaID) {

        ArrayList<Meeting> lista = new ArrayList<>();

        try {
            this.abrirConexion();

            PreparedStatement query0 = this.getConnection().prepareStatement("SELECT * FROM meeting WHERE TeaID=(?) OR Tea2ID=(?)");

            query0.setString(1, teaID);
            query0.setString(2, teaID);

            ResultSet rs0 = query0.executeQuery();

            while (rs0.next()) {

                PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM activity WHERE ActivityID=(?)");

                query.setString(1, rs0.getString("ActivityID"));

                ResultSet rs = query.executeQuery();
                if (rs.next()) {
                    Meeting ts = new Meeting(Long.valueOf(rs.getString("ActivityID")), rs.getString("Name"), rs.getDate("ActDate").toLocalDate(),
                            rs.getTime("endTime").toLocalTime(), rs.getTime("startTime").toLocalTime(), rs.getString("Comment"),
                            Color.getColor(rs.getString("Colour")), rs0.getString("Place"));

                    PreparedStatement query2 = this.getConnection().prepareStatement("SELECT * FROM user WHERE UserID=(?)");

                    query2.setString(1, rs0.getString("TeaID"));

                    ResultSet rs2 = query2.executeQuery();
                    if (rs2.next()) {
                        ts.setTeacher1(rs2.getString("Name"));
                    }

                    PreparedStatement query3 = this.getConnection().prepareStatement("SELECT * FROM user WHERE UserID=(?)");

                    query3.setString(1, teaID);

                    ResultSet rs3 = query3.executeQuery();
                    if (rs3.next()) {
                        ts.setTeacher2(rs3.getString("Name"));
                    }

                    lista.add(ts);
                }
            }
            this.closeC();

        } catch (Exception e) {
            System.out.println("listme");

            System.out.println(e);
        }
        return lista;
    }
}
