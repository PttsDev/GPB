/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.activities;

import es.unileon.iso.gpb.modelo.users.Student;
import es.unileon.iso.gpb.modelo.users.Teacher;
import java.awt.Color;
import java.time.*;

/**
 *
 * @author Roberto
 */
public class Tutorship extends Activity{
    
    private String place;
    private String teacher;
    private String student;
    
    //TODO
    /*
    * Añadir constructores sobrecargados
    */
    public Tutorship(long ID, String name, LocalDate date, LocalTime endTime, LocalTime startTime, String comments, Color color, String student, String teacher, String place) {
        super(ID, name, date, endTime, startTime, comments, color);
        this.place = place;
        this.student = student;
        this.teacher = teacher;
    }
    
    public Tutorship(long ID, String name, LocalDate date, LocalTime endTime, LocalTime startTime, Color color, String student, String teacher, String place){
        super(ID, name, date, endTime, startTime, color);
        this.place = place;
        this.student = student;
        this.teacher = teacher;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }
    
    
    public void setPlace(String place){
        this.place = place;
    }
    
    public String getPlace(){
        return this.place;
    }
    
    @Override
    public String toString(){
        //TODO
        return "";
    }
}
