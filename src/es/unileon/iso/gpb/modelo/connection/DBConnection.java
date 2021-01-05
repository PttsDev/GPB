/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.connection;

import java.sql.*;
/**
 *
 * @author Roberto
 */
public class DBConnection {
    
    //TODO
    private static final String DB = "NOMBRE_BASE_DATOS";
    private static final String USER = "USERNAME_BASE_DATOS";
    private static final String PW = "PASSWORD_BASE_DATOS";
    private static final String URL = "jdbc:mysql//URL_BASE_DATOS/"+DB;
    private static final String DRIVER = "com.mysql.jdbc.driver";
    
    private Connection connection = null;
    
    public DBConnection() {

        try{
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USER, PW);
            
            if(connection!=null) System.out.println("Connection to"+DB+"OK");
            
        }catch(Exception e){
            System.out.println(e);
        } 
        
    }
    
    public Connection getConnection() {
        return this.connection;
    }
    
    public void disconnect() {
        this.connection = null;
    }
    
}
