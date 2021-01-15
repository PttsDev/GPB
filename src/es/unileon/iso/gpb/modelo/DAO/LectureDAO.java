/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.DAO;

import es.unileon.iso.gpb.modelo.activities.Activity;
import es.unileon.iso.gpb.modelo.activities.Lecture;
import es.unileon.iso.gpb.modelo.connection.DBConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

/**
 *
 * @author Roberto
 */
public class LectureDAO extends DBConnection {

    public boolean createActivity(Lecture lecture, String group, String sub, int Id) {

        try {

            this.abrirConexion();

            PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO lecture (ActivityID, Classroom, GroupID) VALUES (?)");

            stat.setString(1, String.valueOf(Id));
            stat.setString(2, lecture.getClassroom());
            stat.setString(3,);

            stat.executeUpdate();

            this.closeC();
        } catch (Exception e) {
            System.out.println(e);
            //Llamar a controlador para sacar mensaje por vista TODO
        }
        return true;
    }

}
