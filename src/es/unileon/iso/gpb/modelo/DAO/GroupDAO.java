/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.DAO;

import es.unileon.iso.gpb.modelo.connection.DBConnection;
import es.unileon.iso.gpb.modelo.sets.Group;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Roberto
 */
public class GroupDAO {
    
    public void createGroup(Group gp){
        
        DBConnection connect = new DBConnection();
        
        try {
            Statement stat = connect.getConnection().createStatement();
            stat.executeUpdate("INSERT INTO user VALUES \\VALUES GROUP//");//TODO
            
            stat.close();
            connect.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            //Llamar a controlador para sacar mensaje por vista TODO
        }
        
    }
    //TODO
}
