/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.DAO;

import com.mysql.jdbc.Connection;
import es.unileon.iso.gpb.modelo.connection.DBConnection;
import es.unileon.iso.gpb.modelo.users.User;
import es.unileon.iso.gpb.modelo.users.User;
import java.awt.List;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Roberto
 */
public class UserDAO extends DBConnection {

    public boolean userExist(String UserID) {

        boolean exists = false;

        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM user");
            ResultSet rs = query.executeQuery();

            while (rs.next() && !exists) {

                if (rs.getString("UserID").equals(UserID)) {
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

    public boolean userLogIn(String UserName, String pw) {

        boolean exists = false;

        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM user");
            ResultSet rs = query.executeQuery();

            while (rs.next() && !exists) {

                if (rs.getString("UserName").equals(UserName) && rs.getString("password").equals(pw)) {
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

    public User getUser(String UserName) {

        boolean exists = false;
        User user = new User();

        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM user");
            ResultSet rs = query.executeQuery();

            while (rs.next() && !exists) {

                if (rs.getString("UserName").equals(UserName)) {
                    exists = true;
                    user.setName(rs.getString("Name"));
                    user.setSurName(rs.getString("SurName"));
                    user.setDNI(rs.getString("DNI"));
                    user.setEmail(rs.getString("Email"));
                    user.setID(rs.getString("UserID"));
                    user.setUserName(rs.getString("UserName"));

                }

            }

            this.closeC();

        } catch (Exception e) {
            System.out.println(e);
            //Llamar al controlador para mensaje por pantalla TODO
        }
        if (exists) {
            return user;
        } else {
            return null;
        }
    }

    public int registerUser(User user) {

        int id = 1;

        try {

            this.abrirConexion();

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM user");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                if (rs.getString("UserName").equals(user.getUserName())) {
                    return 0;
                }

                if (id <= Integer.parseInt(rs.getString("userID"))) {
                    id = Integer.parseInt(rs.getString("userID")) + 1;
                }
            }

            PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO user (Name, SurName, DNI, Email, password, UserID, UserName) VALUES (?,?,?,?,?,?,?)");

            stat.setString(1, user.getName());
            stat.setString(2, user.getSurName());
            stat.setString(3, user.getDNI());
            stat.setString(4, user.getEmail());
            stat.setString(5, user.getPw());
            stat.setInt(6, id);
            stat.setString(7, user.getUserName());
            stat.executeUpdate();

            this.closeC();
        } catch (Exception e) {
            System.out.println(e);
            //Llamar a controlador para sacar mensaje por vista TODO
        }

        return id;

    }

    public void changePassword(String UserName, String pw) {
        try {
            this.abrirConexion();

            PreparedStatement stat = this.getConnection().prepareStatement("UPDATE user SET password = (?) WHERE UserName = (?)");

            stat.setString(1, pw);
            stat.setString(2, UserName);

            stat.executeUpdate();

            this.closeC();

        } catch (Exception e) {
            System.out.println(e);
            //Llamar a controlador para sacar mensaje por vista TODO
        }
    }

    public boolean changeEmail(String UserName, String email) {
        try {
            this.abrirConexion();

            PreparedStatement stat = this.getConnection().prepareStatement("UPDATE user SET Email = (?) WHERE UserName = (?)");

            stat.setString(1, email);
            stat.setString(2, UserName);

            stat.executeUpdate();

            this.closeC();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
            //Llamar a controlador para sacar mensaje por vista TODO
        }

    }

    public boolean deleteUser(String userID) {

        try {
            this.abrirConexion();

            PreparedStatement stat = this.getConnection().prepareStatement("DELETE FROM user WHERE UserID=?");

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

    public ArrayList<String> listUser() {

        ArrayList<String> lista = new <String>ArrayList();
        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM user");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                lista.add(rs.getString("UserName"));
            }
            this.closeC();

        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    public ArrayList<String> listStudent() {

        ArrayList<String> lista = new <String>ArrayList();
        try {
            this.abrirConexion();

            PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM student");
            ResultSet rs1 = query1.executeQuery();

            while (rs1.next()) {
                PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM user WHERE UserID=(?)");
                query.setString(1, rs1.getString("StuID"));
                ResultSet rs = query.executeQuery();
                if (rs.next()) {
                    lista.add(rs.getString("UserName"));
                }
            }
            this.closeC();

        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;

    }

    public ArrayList<String> listTeacher() {

        ArrayList<String> lista = new <String>ArrayList();
        try {
            this.abrirConexion();

            PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM teacher");
            ResultSet rs1 = query1.executeQuery();

            while (rs1.next()) {
                PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM user WHERE UserID=(?)");
                query.setString(1, rs1.getString("TeaID"));
                ResultSet rs = query.executeQuery();
                if (rs.next()) {
                    lista.add(rs.getString("UserName"));
                }
            }
            this.closeC();

        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;

    }

}
