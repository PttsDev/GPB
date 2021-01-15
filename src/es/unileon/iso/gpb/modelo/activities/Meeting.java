/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.activities;

import es.unileon.iso.gpb.modelo.users.Teacher;
import es.unileon.iso.gpb.modelo.users.Teachers;
import java.awt.Color;
import java.time.*;

/**
 *
 * @author Roberto
 */
public class Meeting extends Activity{
    
    private String place;
    private Teachers teachers;
    
    //TODO
    /*
    * Añadir constructores sobrecargados
    */
    public Meeting(long ID, String name, LocalDate date, LocalTime endTime, LocalTime startTime, String comments, Color color, String place) {
        super(ID, name, date, endTime, startTime, comments, color);
        this.place = place;
        this.teachers = new Teachers();
    }
    
    public Meeting(long ID, String name, LocalDate date, LocalTime endTime, LocalTime startTime, Color color, String place) {
        super(ID, name, date, endTime, startTime, color);
        this.place = place;
        this.teachers = new Teachers();
    }
    
    public void setPlace(String place){
        this.place = place;
    }
    
    public String getPlace(){
        return this.place;
    }

    public void addTeacher(Teacher tc){
        this.teachers.add(tc);
    }
    
    public void removeTeacher(String ID) {
        this.teachers.remove(ID);
    }
    
    public Teacher searchTeacher(String ID){
        return this.teachers.get(this.teachers.search(ID));
    }
    
    @Override
    public String toString(){
        //TODO
        return "";
    }
    
}
