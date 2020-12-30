/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.activities;

import java.awt.Color;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Roberto
 */
public class Lecture extends Activity {
    
    private String classroom;
    
    public Lecture(long ID, String name, Date date, Time endTime, long duration, String comments, Color color, String classroom) {
        super(ID, name, date, endTime, duration, comments, color);
        this.classroom = classroom;
    }
    
    public void setClassroom(String classroom){
        this.classroom = classroom;
    }
    
    public String getClassroom(){
        return this.classroom;
    }
}
