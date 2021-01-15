/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.DAO;

import es.unileon.iso.gpb.modelo.connection.DBConnection;
import es.unileon.iso.gpb.modelo.sets.Group;
import es.unileon.iso.gpb.modelo.users.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Roberto
 */
public class GroupDAO extends DBConnection {

    public boolean createGroup(String subject, String number, String type) {

        int id = 1;
  
        String subjectID = "";

        try {

            this.abrirConexion();
            
            PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM subject");
            ResultSet rs1 = query1.executeQuery();
            boolean exist = false;
            while (rs1.next() && !exist) {

                if (rs1.getString("Name").equals(subject)) {
                    exist = true;
                    subjectID = rs1.getString("SubjectID");
                }
            }

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM grups");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                if (rs.getString("SubjectID").equals(subjectID) && rs.getString("Num").equals(number)) {
                    return false;
                }

                if (id <= Integer.parseInt(rs.getString("GroupID"))) {
                    id = Integer.parseInt(rs.getString("GroupID")) + 1;
                }
            }

            PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO grups (GroupID, Num, Type, SubjectID ) VALUES (?,?,?,?)");

            stat.setString(1, String.valueOf(id));
            stat.setString(2, number);
            stat.setString(3, type);
            stat.setString(4, subjectID);

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
