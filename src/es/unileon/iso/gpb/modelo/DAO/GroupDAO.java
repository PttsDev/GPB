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

    public ArrayList<String> listGroup(String teacherID) {

        ArrayList<String> lista = new <String>ArrayList();
        String temp = "";

        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM teagro WHERE TeaID=(?)");

            query.setString(1, teacherID);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM grups WHERE GroupID=(?)");

                query1.setString(1, rs.getString("GroupID"));

                ResultSet rs1 = query1.executeQuery();

                if (rs1.next()) {

                    temp = (rs1.getString("Num").concat(" ").concat(rs1.getString("Type")));

                    PreparedStatement query2 = this.getConnection().prepareStatement("SELECT * FROM subject WHERE SubjectID=(?)");

                    query2.setString(1, rs1.getString("SubjectID"));

                    ResultSet rs2 = query2.executeQuery();
                    if (rs2.next()) {

                        lista.add(rs2.getString("Name").concat(" ").concat(temp));
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

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM subject WHERE Name=(?)");

            query.setString(1, subject);

            ResultSet rs = query.executeQuery();

            PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM grups WHERE SubjectID=(?) AND Num=(?)");
            PreparedStatement query3 = this.getConnection().prepareStatement("SELECT * FROM grups WHERE SubjectID=(?)");

            if (rs.next()) {
                query1.setString(1, rs.getString("SubjectID"));
                query1.setString(2, number);
                query3.setString(1, rs.getString("SubjectID"));

                ResultSet rs3 = query3.executeQuery();

                ResultSet rs1 = query1.executeQuery();

                while (rs3.next()) {
                    PreparedStatement stat1 = this.getConnection().prepareStatement("DELETE FROM stugro WHERE StuID=(?) AND GroupID=(?)");

                    stat1.setString(1, UserID);
                    stat1.setString(2, rs3.getString("GroupID"));

                    stat1.executeUpdate();
                }

                if (rs1.next()) {
                    PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO stugro (StuID, GroupID) VALUES (?,?)");

                    stat.setString(1, UserID);

                    stat.setString(2, rs1.getString("GroupID"));

                    stat.executeUpdate();
                }
            }

            this.closeC();
            return true;
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

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM subject WHERE Name=(?)");

            query.setString(1, subject);

            ResultSet rs = query.executeQuery();

            PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM grups WHERE SubjectID=(?) AND Num=(?)");
            if (rs.next()) {
                query1.setString(1, rs.getString("SubjectID"));
                query1.setString(2, number);

                ResultSet rs1 = query1.executeQuery();
                if (rs1.next()) {
                    PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO teagro (TeaID, GroupID) VALUES (?,?)");

                    stat.setString(1, UserID);

                    stat.setString(2, rs1.getString("GroupID"));

                    stat.executeUpdate();
                }
            }
            this.closeC();
            return true;

        } catch (Exception e) {
            System.out.println(e);

        }
        return false;
    }

    public boolean deleteGroup(String subject, String Number) {

        try {
            this.abrirConexion();

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM subject WHERE Name=(?)");

            query.setString(1, subject);

            ResultSet rs = query.executeQuery();

            PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM grups WHERE SubjectID=(?) AND Num=(?)");
            if (rs.next()) {
                query1.setString(1, rs.getString("SubjectID"));
                query1.setString(2, Number);

                ResultSet rs1 = query1.executeQuery();
                if (rs1.next()) {
                    PreparedStatement stat = this.getConnection().prepareStatement("DELETE FROM grups WHERE GroupID=(?) ");

                    stat.setString(1, rs1.getString("GroupID"));

                    stat.executeUpdate();
                }
            }

            this.closeC();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
            //Llamar a controlador para sacar mensaje por vista TODO
        }

    }

}
