/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.activities;

import java.awt.Color;
import java.time.*;

/**
 *
 * @author Roberto
 */
public class Lecture extends Activity {
    
    private String classroom;
    private boolean exam;
    
    //TODO
    /*
    * Añadir constructores sobrecargados
    */
    public Lecture(long ID, String name, LocalDate date, LocalTime endTime, LocalTime startTime, String comments, Color color, String classroom) {
        super(ID, name, date, endTime, startTime, comments, color);
        this.classroom = classroom;
        this.exam = false;
    }
    
    public Lecture(long ID, String name, LocalDate date, LocalTime endTime, LocalTime startTime, Color color, String classroom) {
        super(ID, name, date, endTime, startTime, color);
        this.classroom = classroom;
        this.exam = false;
    }

    public boolean isExam() {
        return exam;
    }

    public void setIsExam(boolean isExam) {
        this.exam = isExam;
    }
    
    public void setClassroom(String classroom){
        this.classroom = classroom;
    }
    
    public String getClassroom(){
        return this.classroom;
    }
    
    @Override
    public String toString(){
        //TODO
        return "";
    }
}
