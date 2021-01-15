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
          PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM subject WHERE Name=(?)");

            query.setString(1, subject);

            ResultSet rs = query.executeQuery();

            PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM grups WHERE SubjectID=(?)");
            if (rs.next()) {
                query1.setString(1, rs.getString("SubjectID"));

                ResultSet rs1 = query1.executeQuery();

                while (rs1.next()) {

                    lista.add(rs1.getString("Num").concat(" ").concat(rs1.getString("Type")));

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

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM subject WHERE Name=(?)");

            query.setString(1, subject);

            ResultSet rs = query.executeQuery();

            PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM grups WHERE SubjectID=(?)");
            if (rs.next()) {
                query1.setString(1, rs.getString("SubjectID"));

                ResultSet rs1 = query1.executeQuery();

                while (rs1.next()) {

                    PreparedStatement query2 = this.getConnection().prepareStatement("SELECT * FROM stugro WHERE StuID=(?) AND GroupID=(?)");
                    query2.setString(1, UserID);
                    query2.setString(2, rs1.getString("GroupID"));
                    

                    ResultSet rs2 = query2.executeQuery();

                    if (rs2.next()) {
                        return rs1.getString("Num").concat(" ").concat(rs1.getString("Type"));
                    }

                }
            }

            this.closeC();

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean assignStuGroup(String UserID, String subject, String number) {
        try {
            this.abrirConexion();

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM subject");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                if (rs.getString("Name").equals(subject)) {
                    PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM grups");
                    ResultSet rs1 = query1.executeQuery();
                    while (rs1.next()) {
                        if (rs1.getString("SubjectID").equals(rs.getString("SubjectID"))) {

                            PreparedStatement query2 = this.getConnection().prepareStatement("SELECT * FROM stugro");
                            ResultSet rs2 = query2.executeQuery();

                            while (rs2.next()) {

                                if (rs1.getString("GroupID").equals(number) && rs2.getString("StuID").equals(number)) {
                                    this.closeC();
                                    return false;
                                }
                            }

                            PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO stugro (StuID, GroupID) VALUES (?,?)");

                            stat.setString(1, UserID);
                            stat.setString(2, number);

                            stat.executeUpdate();
                            this.closeC();
                            return true;
                        }

                    }
                }
            }
            this.closeC();

        } catch (Exception e) {
            System.out.println(e);

        }
        return false;
    }

    public boolean assignTeaGroup(String UserID, String subject, String number) {
        boolean exist = false;
        String groupID = "";

        try {
            this.abrirConexion();

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM subject");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                if (rs.getString("Name").equals(subject)) {
                    PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM grups");
                    ResultSet rs1 = query1.executeQuery();
                    while (rs1.next()) {
                        if (rs1.getString("SubjectID").equals(rs.getString("SubjectID"))) {

                            PreparedStatement query2 = this.getConnection().prepareStatement("SELECT * FROM teagro");
                            ResultSet rs2 = query2.executeQuery();

                            while (rs2.next()) {

                                if (rs1.getString("GroupID").equals(number) && rs2.getString("TeaID").equals(number)) {
                                    this.closeC();
                                    return false;
                                }
                            }

                            PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO teagro (TeaID, GroupID) VALUES (?,?)");

                            stat.setString(1, UserID);
                            stat.setString(2, number);

                            stat.executeUpdate();
                            this.closeC();
                            return true;
                        }

                    }
                }
            }
            this.closeC();

        } catch (Exception e) {
            System.out.println(e);

        }
        return false;
    }

}
