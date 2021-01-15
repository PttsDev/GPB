/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.DAO;

import es.unileon.iso.gpb.modelo.activities.PersonalActivity;
import es.unileon.iso.gpb.modelo.connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Roberto
 */
public class PersonalActivityDAO extends DBConnection{
    
    public boolean createPersonalActivity(PersonalActivity pa, int Id){
        
                
        try {

            this.abrirConexion();

            PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO lecture (ActivityID, StuID) VALUES (?,?)");

            stat.setString(1, String.valueOf(Id));
            stat.setString(2, );


            stat.executeUpdate();

            this.closeC();
        } catch (Exception e) {
            System.out.println(e);
            //Llamar a controlador para sacar mensaje por vista TODO
        }
        return true;
    }
    //TODO
}
