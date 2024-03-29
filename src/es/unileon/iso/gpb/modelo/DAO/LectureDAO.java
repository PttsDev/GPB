/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.DAO;

import es.unileon.iso.gpb.modelo.activities.Activity;
import es.unileon.iso.gpb.modelo.activities.Lecture;
import es.unileon.iso.gpb.modelo.connection.DBConnection;
import java.awt.Color;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author Roberto
 */
public class LectureDAO extends DBConnection {

    public boolean createActivity(Lecture lecture, String group, String sub, int Id) {

        try {

            this.abrirConexion();

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM subject WHERE Name=(?)");

            query.setString(1, sub);

            ResultSet rs = query.executeQuery();

            if (rs.next()) {
                PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM grups WHERE SubjectID=(?) AND Num=(?)");

                query1.setString(1, rs.getString("SubjectID"));
                query1.setString(2, group);
                ResultSet rs1 = query1.executeQuery();
                if (rs1.next()) {
                    PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO lecture (ActivityID, Classroom, GroupID) VALUES (?,?,?)");

                    stat.setString(1, String.valueOf(Id));
                    stat.setString(2, lecture.getClassroom());

                    stat.setString(3, rs1.getString("GroupID"));
                    stat.executeUpdate();
                }

            }

            this.closeC();
        } catch (Exception e) {
            System.out.println("Lecture" + e);
            //Llamar a controlador para sacar mensaje por vista TODO
        }
        return true;
    }

    public ArrayList<Lecture> listLecturesStu(String stuID) {

        ArrayList<Lecture> lista = new <String>ArrayList();
        String temp = "";

        try {
            this.abrirConexion();

            PreparedStatement query0 = this.getConnection().prepareStatement("SELECT * FROM stugro WHERE StuID=(?)");

            query0.setString(1, stuID);

            ResultSet rs0 = query0.executeQuery();

            while (rs0.next()) {

                PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM lecture WHERE GroupID=(?)");

                query.setString(1, rs0.getString("GroupID"));

                ResultSet rs = query.executeQuery();

                while (rs.next()) {

                    PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM activity WHERE ActivityID=(?)");

                    query1.setString(1, rs.getString("ActivityID"));

                    ResultSet rs1 = query1.executeQuery();
                    if (rs1.next()) {

                        Lecture lecture = new Lecture(Long.valueOf(rs1.getString("ActivityID")), rs1.getString("Name"), rs1.getDate("ActDate").toLocalDate(), rs1.getTime("endTime").toLocalTime(), rs1.getTime("startTime").toLocalTime(), Color.getColor(rs1.getString("Colour")), rs.getString("Classroom"));
                        lista.add(lecture);
                    }

                }
            }
            this.closeC();

        } catch (Exception e) {
            System.out.println("listLectures");

            System.out.println(e);
        }
        return lista;
    }

    public ArrayList<Lecture> listLecturesTea(String teaID) {

        ArrayList<Lecture> lista = new ArrayList<>();
     

        try {
            this.abrirConexion();

            PreparedStatement query0 = this.getConnection().prepareStatement("SELECT * FROM teagro WHERE TeaID=(?)");

            query0.setString(1, teaID);

            ResultSet rs0 = query0.executeQuery();

            while (rs0.next()) {

                PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM lecture WHERE GroupID=(?)");

                query.setString(1, rs0.getString("GroupID"));

                ResultSet rs = query.executeQuery();

                while (rs.next()) {

                    PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM activity WHERE ActivityID=(?)");

                    query1.setString(1, rs.getString("ActivityID"));

                    ResultSet rs1 = query1.executeQuery();
                    if (rs1.next()) {

                        Lecture lecture = new Lecture(Long.valueOf(rs1.getString("ActivityID")), rs1.getString("Name"), rs1.getDate("ActDate").toLocalDate(), rs1.getTime("endTime").toLocalTime(), rs1.getTime("startTime").toLocalTime(), Color.getColor(rs1.getString("Colour")), rs.getString("Classroom"));
                        lista.add(lecture);
                    }

                }
            }
            this.closeC();

        } catch (Exception e) {
            System.out.println("listLectures");

            System.out.println(e);
        }
        return lista;
    }
}
