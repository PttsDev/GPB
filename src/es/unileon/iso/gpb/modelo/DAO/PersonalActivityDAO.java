/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.DAO;

import es.unileon.iso.gpb.modelo.activities.Lecture;
import es.unileon.iso.gpb.modelo.activities.PersonalActivity;
import es.unileon.iso.gpb.modelo.connection.DBConnection;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Roberto
 */
public class PersonalActivityDAO extends DBConnection {

    public boolean createPersonalActivity(PersonalActivity pa, int aId, String uId) {

        try {

            this.abrirConexion();

            PreparedStatement stat = this.getConnection().prepareStatement("INSERT INTO lecture (ActivityID, StuID) VALUES (?,?)");

            stat.setString(1, String.valueOf(aId));
            stat.setString(2, uId);

            stat.executeUpdate();

            this.closeC();
        } catch (Exception e) {
            System.out.println(e);
            //Llamar a controlador para sacar mensaje por vista TODO
        }
        return true;
    }

    public ArrayList<PersonalActivity> listPa(String stuID) {

        ArrayList<PersonalActivity> lista = new ArrayList<>();

        try {
            this.abrirConexion();

            PreparedStatement query0 = this.getConnection().prepareStatement("SELECT * FROM personalactivity WHERE StuID=(?)");

            query0.setString(1, stuID);

            ResultSet rs0 = query0.executeQuery();

            while (rs0.next()) {

                PreparedStatement query = this.getConnection().prepareStatement("SELECT * FROM lecture WHERE GroupID=(?)");

                query.setString(1, rs0.getString("GroupID"));

                ResultSet rs = query.executeQuery();

                while (rs.next()) {

                    PreparedStatement query1 = this.getConnection().prepareStatement("SELECT * FROM activity WHERE ActivityID=(?)");

                    query1.setString(1, rs.getString("ActivityID"));

                    ResultSet rs1 = query1.executeQuery();
                    if (rs1.next()) {

                        PersonalActivity pa = new PersonalActivity(Long.valueOf(rs1.getString("ActivityID")), rs1.getString("Name"), rs1.getDate("ActDate").toLocalDate(),
                                rs1.getTime("endTime").toLocalTime(), rs1.getTime("startTime").toLocalTime(),
                                Color.getColor(rs1.getString("Colour")));
                        lista.add(pa);
                    }
                }
            }
          
            this.closeC();
              return lista;

        } catch (Exception e) {
            System.out.println("listLectures");

            System.out.println(e);
        }
        return lista;
    }
}
