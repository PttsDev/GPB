/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.DAO;

import es.unileon.iso.gpb.modelo.connection.DBConnection;
import es.unileon.iso.gpb.modelo.users.Student;
import es.unileon.iso.gpb.modelo.users.Student;
import es.unileon.iso.gpb.modelo.users.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Roberto
 */
public class StudentDAO extends DBConnection {

    public void registerStudent(Student student) {

        try {

            this.abrirConexion();

            int id = -1;

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM student");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                id++;
            }

            PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO student (Name, SurName, DNI, Email, password, UserID) VALUES (?,?,?,?,?,?");

            stat.setString(1, student.getName());
            stat.setString(2, student.getSurName());
            stat.setString(3, student.getDNI());
            stat.setString(4, student.getEmail());
            stat.setString(5, student.getPw());
            stat.setInt(6, id);
            stat.executeUpdate();

            this.close();
        } catch (Exception e) {
            System.out.println(e);
            //Llamar a controlador para sacar mensaje por vista TODO
        }

    }

    public boolean studentExist(String StudentID) {

        boolean exists = false;

        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM student");
            ResultSet rs = query.executeQuery();

            while (rs.next() && !exists) {

                if (rs.getString("StudentID").equals(StudentID)) {
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

    public boolean studentLogIn(String StudentID, String pw) {

        boolean exists = false;

        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM student");
            ResultSet rs = query.executeQuery();

            while (rs.next() && !exists) {

                if (rs.getString("StudentID").equals(StudentID) && rs.getString("password").equals(pw)) {
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

    public Student getStudent(String StudentID) {

        boolean exists = false;
        Student student = new Student();

        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM student");
            ResultSet rs = query.executeQuery();

            while (rs.next() && !exists) {

                if (rs.getString("StudentID").equals(StudentID)) {
                    exists = true;
                    student.setName(rs.getString("Name"));
                    student.setSurName(rs.getString("SurName"));
                    student.setDNI(rs.getString("DNI"));
                    student.setEmail(rs.getString("Email"));
                }

            }

            this.close();

        } catch (Exception e) {
            System.out.println(e);
            //Llamar al controlador para mensaje por pantalla TODO
        }
        if (exists) {
            return student;
        } else {
            return null;
        }
    }

}
