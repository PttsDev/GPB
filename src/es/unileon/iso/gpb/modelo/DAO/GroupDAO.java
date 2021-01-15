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
import java.util.ArrayList;

/**
 *
 * @author Roberto
 */
public class GroupDAO extends DBConnection {

    public boolean createGroup(String subject, String number, String type) {

        int id = 1;

        int subjectID = 0;

        try {

            this.abrirConexion();

            PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM subject");
            ResultSet rs1 = query1.executeQuery();
            boolean exist = false;
            while (rs1.next() && !exist) {
                if (rs1.getString("Name").equals(subject)) {
                    exist = true;
                    subjectID = rs1.getInt("SubjectID");
                }
            }

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM grups");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                if (rs.getInt("SubjectID") == subjectID && rs.getString("Num").equals(number)) {
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
            stat.setInt(4, subjectID);

            stat.executeUpdate();

            this.closeC();
        } catch (Exception e) {
            System.out.println(e);
            //Llamar a controlador para sacar mensaje por vista TODO
        }
        return true;

    }

    public ArrayList<String> listGroups(String subject) {

        ArrayList<String> lista = new <String>ArrayList();
        boolean exists = false;

        try {
            this.abrirConexion();

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM subject");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                if (rs.getString("Name").equals(subject)) {
                    PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM grups");
                    ResultSet rs1 = query1.executeQuery();
                    exists = false;
                    while (rs1.next() && !exists) {

                        if (rs1.getString("SubjectID").equals(rs.getString("SubjectID"))) {
                            exists = true;
                            lista.add(rs1.getString("Num").concat(" ").concat(rs1.getString("Type")));

                        }

                    }
                }
            }
            this.closeC();

        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    public String findGroup(String UserID, String subject) {

        try {
            this.abrirConexion();

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM subject");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                if (rs.getString("Name").equals(subject)) {
                    PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM stugro");
                    ResultSet rs1 = query1.executeQuery();

                    while (rs1.next()) {

                        if (rs1.getString("SubjectID").equals(rs.getString("SubjectID")) && rs1.getString("StuID").equals(UserID)) {

                            PreparedStatement query2 = this.getConnection().prepareStatement("SELECT * FROM grups");
                            ResultSet rs2 = query2.executeQuery();

                            while (rs2.next()) {
                            }
                            if(rs2.getString("GroupID").equals(rs1.getString("GroupID"))){
                            return (rs2.getString("Num").concat(" ").concat(rs2.getString("Type")));
                            }

                        }

                    }
                }
            }
            this.closeC();

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    //TODO
}
