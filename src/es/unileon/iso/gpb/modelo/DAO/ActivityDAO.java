/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.DAO;

import com.mysql.jdbc.Connection;
import es.unileon.iso.gpb.modelo.activities.Activity;
import es.unileon.iso.gpb.modelo.connection.DBConnection;
import es.unileon.iso.gpb.modelo.users.User;
import es.unileon.iso.gpb.modelo.users.User;
import java.awt.List;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

/**
 *
 * @author Roberto
 */
public class ActivityDAO extends DBConnection {

    public int createActivity(Activity activity) {

        int id = 1;

        try {

            this.abrirConexion();

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM activity");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                if (id <= Integer.parseInt(rs.getString("userID"))) {
                    id = Integer.parseInt(rs.getString("userID")) + 1;
                }
            }
            if (activity.getComments() != null) {
                PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO activity (ActivityID, Name, ActDate, endTime, startTime, Comment, Colour) VALUES (?,?,?,?,?,?,?)");

                stat.setInt(1, id);
                stat.setString(2, activity.getName());
                stat.setDate(3, Date.valueOf(activity.getDate()));
                stat.setTime(4, Time.valueOf(activity.getEndTime()));
                stat.setTime(5, Time.valueOf(activity.getStartTime()));
                stat.setString(6, activity.getComments());
                stat.setString(7, String.valueOf(activity.getColor().getRGB()));

                stat.executeUpdate();
            } else {
                PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO activity (ActivityID, Name, ActDate, endTime, startTime, Colour) VALUES (?,?,?,?,?,?)");

                stat.setInt(1, id);
                stat.setString(2, activity.getName());
                stat.setDate(3, Date.valueOf(activity.getDate()));
                stat.setTime(4, Time.valueOf(activity.getEndTime()));
                stat.setTime(5, Time.valueOf(activity.getStartTime()));
                stat.setString(6, String.valueOf(activity.getColor().getRGB()));

                stat.executeUpdate();

            }

            this.closeC();
            return id;
        } catch (Exception e) {
            System.out.println("activity");

            System.out.println(e);
            return 0;
            //Llamar a controlador para sacar mensaje por vista TODO
        }
        //Llamar a controlador para sacar mensaje por vista TODO
    }

}
