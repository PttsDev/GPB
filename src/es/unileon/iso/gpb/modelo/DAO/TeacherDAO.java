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

    public boolean registerTeacher(Teacher teacher) {

        try {

            this.abrirConexion();

            int id = -1;

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM teacher");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                if(rs.getString("DNI").equals(teacher.getDNI())){
                    return false;
                }
                id--;
            }

            PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO teacher (Name, SurName, DNI, Email, password, UserID, UserName) VALUES (?,?,?,?,?,?,?");

            stat.setString(1, teacher.getName());
            stat.setString(2, teacher.getSurName());
            stat.setString(3, teacher.getDNI());
            stat.setString(4, teacher.getEmail());
            stat.setString(5, teacher.getPw());
            stat.setInt(6, id);
            stat.setString(7, teacher.getUserName());
            stat.executeUpdate();

            this.close();
        } catch (Exception e) {
            System.out.println(e);
            //Llamar a controlador para sacar mensaje por vista TODO
        }
        
        return true;

    }

    public boolean teacherExist(String TeacherID) {

        boolean exists = false;

        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM teacher");
            ResultSet rs = query.executeQuery();

            while (rs.next() && !exists) {

                if (rs.getString("TeacherID").equals(TeacherID)) {
                    exists = true;
                }

            }

            this.close();

        } catch (Exception e) {
            System.out.println(e);
            //Llamar al controlador para mensaje por pantalla TODO
        }

        return exists;
    }

    public boolean teacherLogIn(String TeacherID, String pw) {

        boolean exists = false;

        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM teacher");
            ResultSet rs = query.executeQuery();

            while (rs.next() && !exists) {

                if (rs.getString("TeacherID").equals(TeacherID) && rs.getString("password").equals(pw)) {
                    exists = true;
                }

            }

            this.close();

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
                }

            }

            this.close();

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

}
