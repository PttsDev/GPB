/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.DAO;

import es.unileon.iso.gpb.modelo.connection.DBConnection;
import es.unileon.iso.gpb.modelo.sets.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Roberto
 */
public class SubjectDAO extends DBConnection {

    public ArrayList<String> listAllSubjects() {

        ArrayList<String> lista = new <String>ArrayList();
        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM subject");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                lista.add(rs.getString("Name"));
            }
            this.closeC();

        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    public String getSubject(String SubID) {

        boolean exists = false;
        String name = "";

        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM subject");
            ResultSet rs = query.executeQuery();

            while (rs.next() && !exists) {

                if (rs.getString("SubjectID").equals(SubID)) {
                    exists = true;
                    name = rs.getString("Name");

                }

            }

            this.closeC();

        } catch (Exception e) {
            System.out.println(e);
            //Llamar al controlador para mensaje por pantalla TODO
        }
        if (exists) {
            return name;
        } else {
            return null;
        }
    }

    public ArrayList<String> listStuSubSubjects(String userID) {

        ArrayList<String> lista = new <String>ArrayList();
        boolean exists = false;

        try {
            this.abrirConexion();

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM stusub");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                if (rs.getString("StuID").equals(userID)) {
                    PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM subject");
                    ResultSet rs1 = query1.executeQuery();
                    exists = false;
                    while (rs1.next() && !exists) {

                        if (rs1.getString("SubjectID").equals(rs.getString("SubjectID"))) {
                            exists = true;
                            lista.add(rs1.getString("Name"));

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

    public ArrayList<String> listTeaSubSubjects(String userID) {

        ArrayList<String> lista = new <String>ArrayList();
        boolean exists = false;

        try {
            this.abrirConexion();

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM teasub");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                if (rs.getString("TeaID").equals(userID)) {
                    PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM subject");
                    ResultSet rs1 = query1.executeQuery();
                    exists = false;
                    while (rs1.next() && !exists) {

                        if (rs1.getString("SubjectID").equals(rs.getString("SubjectID"))) {
                            exists = true;
                            lista.add(rs1.getString("Name"));

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

    public void joinSubjectTea(String userID, String Subject) {

        boolean exist = false;
        String SubjectID = "";

        try {
            this.abrirConexion();

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM subject");
            ResultSet rs = query.executeQuery();
            while (rs.next() && !exist) {

                if (rs.getString("Name").equals(Subject)) {
                    exist = true;
                    SubjectID = rs.getString("SubjectID");
                }
            }

            PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO teasub (TeaID, SubjectID) VALUES (?,?)");

            stat.setString(1, userID);
            stat.setString(2, SubjectID);

            stat.executeUpdate();

            this.closeC();

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void joinSubjectStu(String userID, String Subject) {

        boolean exist = false;
        String SubjectID = "";

        try {
            this.abrirConexion();

            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM subject");
            ResultSet rs = query.executeQuery();
            while (rs.next() && !exist) {

                if (rs.getString("Name").equals(Subject)) {
                    exist = true;
                    SubjectID = rs.getString("SubjectID");
                }
            }

            PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO stusub (StuID, SubjectID) VALUES (?,?)");

            stat.setString(1, userID);
            stat.setString(2, SubjectID);

            stat.executeUpdate();

            this.closeC();

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void leaveStuSubject(String userID, String Subject) {

        try {
            this.abrirConexion();
            PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM subject");
            ResultSet rs = query.executeQuery();
            boolean exist=false;
            String SubjectID = "";
            while (rs.next() && !exist) {

                if (rs.getString("Name").equals(Subject)) {
                    exist = true;
                    SubjectID = rs.getString("SubjectID");
                }
            }
            PreparedStatement stat = this.getConnection().prepareStatement("DELETE FROM stusub WHERE StuID=? AND SubjectID=?");

            stat.setString(1, userID);
            stat.setString(2, SubjectID);

            stat.executeUpdate();

            this.closeC();

        } catch (Exception e) {
            System.out.println(e);
            //Llamar a controlador para sacar mensaje por vista TODO
        }

    }

    public void leaveTeaSubject(String userID, String Subject) {

        try {
            this.abrirConexion();
            
                       PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM subject");
            ResultSet rs = query.executeQuery();
            boolean exist=false;
            String SubjectID = "";
            while (rs.next() && !exist) {

                if (rs.getString("Name").equals(Subject)) {
                    exist = true;
                    SubjectID = rs.getString("SubjectID");
                }
            }

            PreparedStatement stat = this.getConnection().prepareStatement("DELETE FROM teasub WHERE TeaID=? AND SubjectID=?");

            stat.setString(1, userID);
            stat.setString(2, SubjectID);

            stat.executeUpdate();

            this.closeC();

        } catch (Exception e) {
            System.out.println(e);
            //Llamar a controlador para sacar mensaje por vista TODO
        }

    }
}

//TODO}
