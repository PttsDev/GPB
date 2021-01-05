/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.DAO;

import es.unileon.iso.gpb.modelo.connection.DBConnection;
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
public class UserDAO {
    
    
    public void registerUser(User user){
        
        DBConnection connect = new DBConnection();
        
        try {
            Statement stat = connect.getConnection().createStatement();
            stat.executeUpdate("INSERT INTO user VALUES \\VALUES USER//");//TODO
            
            stat.close();
            connect.close();
        }catch (SQLException e){
            System.out.println(e);
            //Llamar a controlador para sacar mensaje por vista TODO
        }
        
    }
    
    public ArrayList<User> userList(){
        
        ArrayList<User> users = new ArrayList<User>();
        DBConnection connect = new DBConnection();
        
        try{
            PreparedStatement query = connect.getConnection().prepareStatement("SELECT * FROM user");
            ResultSet rs = query.executeQuery();
            
            while( rs.next() ){
                
                //String name, String surName, String DNI, String email
                //ADD USER DATA TODO
                User user = new User();
                user.setName(rs.getString("name"));
                user.setSurName(rs.getString("surname"));
                user.setDNI(rs.getString("DNI"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
            
        }catch(Exception e){
            System.out.println(e);
            //Llamar al controlador para mensaje por pantalla TODO
        }
        
        return users;
    }
    //TODO METODOS 
    
}
