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

            this.close();

        } catch (Exception e) {
            System.out.println(e);
            //Llamar al controlador para mensaje por pantalla TODO
        }

        return exists;
    }
    
  

    public boolean userLogIn(String UserID, String pw) {

        boolean exists = false;
        boolean ets = false;

        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM user");
            ResultSet rs = query.executeQuery();

            while (rs.next() && !exists) {

                if (rs.getString("UserID").equals(UserID) && rs.getString("password").equals(pw)) {
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

    public User getUser(String UserID) {

        boolean exists = false;
        User user = new User();

        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM user");
            ResultSet rs = query.executeQuery();

            while (rs.next() && !exists) {

                if (rs.getString("UserID").equals(UserID)) {
                    exists = true;
                    user.setName(rs.getString("Name"));
                    user.setSurName(rs.getString("SurName"));
                    user.setDNI(rs.getString("DNI"));
                    user.setEmail(rs.getString("Email"));
                }

            }

            this.close();

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
                if (rs.getString("DNI").equals(user.getDNI())) {
                    return 0;
                }
                id++;
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

            this.close();
        } catch (Exception e) {
            System.out.println(e);
            //Llamar a controlador para sacar mensaje por vista TODO
        }

        return id;

    }

}
