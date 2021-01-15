/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.DAO;

import es.unileon.iso.gpb.modelo.connection.DBConnection;
import es.unileon.iso.gpb.modelo.users.Teacher;
import es.unileon.iso.gpb.modelo.users.Teacher;
import es.unileon.iso.gpb.modelo.users.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Roberto
 */
public class TeacherDAO extends DBConnection {

    public boolean registerTeacher(String ID) {

        try {

            this.abrirConexion();

            PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO teacher (TeaID) VALUES (?)");

            stat.setString(1, ID);

            stat.executeUpdate();

            this.closeC();
        } catch (Exception e) {
            System.out.println(e);
            //Llamar a controlador para sacar mensaje por vista TODO
        }
        return true;
    }

    public boolean teacherExist(String ID) {

        boolean exists = false;

        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM teacher");
            ResultSet rs = query.executeQuery();

            while (rs.next() && !exists) {

                if (rs.getString("TeaID").equals(ID)) {
                    exists = true;
                }

            }

            this.closeC();

        } catch (Exception e) {
            System.out.println(e);
            //Llamar al controlador para mensaje por pantalla TODO
        }

        return exists;
    }

    public boolean teacherLogIn(String teacherName, String pw) {

        boolean exists = false;

        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM teacher");
            ResultSet rs = query.executeQuery();

            while (rs.next() && !exists) {

                if (rs.getString("UserName").equals(teacherName) && rs.getString("password").equals(pw)) {
                    exists = true;
                }

            }

            this.closeC();

        } catch (Exception e) {
            System.out.println(e);
            //Llamar al controlador para mensaje por pantalla TODO
        }

        return exists;
    }

    public Teacher getTeacher(String TeacherID) {

        boolean exists = false;
        Teacher teacher = new Teacher();

        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM teacher");
            ResultSet rs = query.executeQuery();

            while (rs.next() && !exists) {

                if (rs.getString("TeacherID").equals(TeacherID)) {
                    exists = true;
                    teacher.setName(rs.getString("Name"));
                    teacher.setSurName(rs.getString("SurName"));
                    teacher.setDNI(rs.getString("DNI"));
                    teacher.setEmail(rs.getString("Email"));
                    teacher.setID(rs.getString("ID"));
                    teacher.setUserName(rs.getString("UserName"));
                }

            }

            this.closeC();

        } catch (Exception e) {
            System.out.println(e);
            //Llamar al controlador para mensaje por pantalla TODO
        }
        if (exists) {
            return teacher;
        } else {
            return null;
        }
    }

    public boolean deleteTeacher(String userID) {
        try {
            this.abrirConexion();

            PreparedStatement stat = this.getConnection().prepareStatement("DELETE FROM teacher WHERE TEaID=?");

            stat.setString(1, userID);

            stat.executeUpdate();

            this.closeC();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
            //Llamar a controlador para sacar mensaje por vista TODO
        }
    }

}
