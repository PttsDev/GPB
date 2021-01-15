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
  
                if ( rs.getString("StuID").equals(userID)) {
                    PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM subject");
                    ResultSet rs1 = query1.executeQuery();
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
  
                if ( rs.getString("TeaID").equals(userID)) {
                    PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM subject");
                    ResultSet rs1 = query1.executeQuery();
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

    //TODO
}
