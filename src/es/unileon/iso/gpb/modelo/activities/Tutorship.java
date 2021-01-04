/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.activities;

import es.unileon.iso.gpb.modelo.users.Student;
import es.unileon.iso.gpb.modelo.users.Teacher;
import java.awt.Color;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Roberto
 */
public class Tutorship extends Activity{
    
    private String place;
    private Teacher teacher;
    private Student student;
    
    //TODO
    /*
    * Añadir constructores sobrecargados
    */
    public Tutorship(long ID, String name, Date date, Time endTime, long duration, String comments, Color color, Student student, Teacher teacher) {
        super(ID, name, date, endTime, duration, comments, color);
        this.place = place;
        this.student = student;
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
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
