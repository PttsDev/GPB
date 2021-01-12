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
    private static final String DB = "db_a6d7c4_gpb";
    private static final String USER = "a6d7c4_gpb";
    private static final String PW = "AlvaroPeroBien1.";
    private static final String URL = "jdbc:mysql://mysql5044.site4now.net/" + DB + "?useSSL=false";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private Connection connection = null;

    public DBConnection() {

        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USER, PW);

            if (connection != null) {
                System.out.println("Connection to " + DB + " OK");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public Connection getConnection() {
        return this.connection;
    }

    public void close() {
        this.connection = null;
    }

    public void abrirConexion() throws Exception {

        try {
            Class.forName(this.DRIVER);
            this.connection = DriverManager.getConnection(this.URL, this.USER, this.PW);

        } catch (Exception e) {
            throw new Exception("Al abrir la base de datos " + e.getMessage());
        }
    }
}
