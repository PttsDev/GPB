/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.users;

import java.awt.Color;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Roberto
 */
public class User {

    private String name;
    private String surName;
    private String DNI;
    private String email;
    
    public User(){}
    
    public User(String name, String surName, String DNI, String email) {
        this.name = name;
        this.surName = surName;
        this.DNI = DNI;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setSurName(String surName) {
        this.surName = surName;
    }
    
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }
    
    public String getSurName() {
        return this.surName;
    }

    public String getDNI() {
        return this.DNI;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean login(String user, String pw) {
        //TODO
        return true;
    }
    
    public void logout() {
        //TODO
    }
    
    /*
    * METODOS SOBRECARGADOS DE CREAR ACTIVIDAD 
    * UNA QUE PERMITA INTRODUCIR COMENTARIOS, UNA QUE PERMITA INTRODUCIR COLOR
    * UNA QUE PERMITA INTRODUCIR AMBOS Y OTRA NINGUNO
    */
    public void createAct(String type, Time hour, Date date, long duration) {
        //TODO
    }
    public void createAct(String type, Time hour, Date date, long duration, Color color, String comments) {
        //TODO
    }
    public void createAct(String type, Time hour, Date date, long duration, String comments) {
        //TODO
    }
    public void createAct(String type, Time hour, Date date, long duration, Color color) {
        //TODO
    }
    
    @Override
    public String toString(){
        //TODO
        return "";
    }
}
