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
public class Tutorship extends Activity{
    
    private String place;
    
    //TODO
    /*
    * Añadir constructores sobrecargados
    */
    public Tutorship(long ID, String name, Date date, Time endTime, long duration, String comments, Color color) {
        super(ID, name, date, endTime, duration, comments, color);
        this.place = place;
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
