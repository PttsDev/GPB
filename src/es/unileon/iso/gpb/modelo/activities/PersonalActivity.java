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
public class PersonalActivity extends Activity{
    
    //TODO
    /*
    * Añadir constructores sobrecargados
    */
    public PersonalActivity(long ID, String name, Date date, Time endTime, long duration, String comments, Color color) {
        super(ID, name, date, endTime, duration, comments, color);
    }
    
    @Override
    public String toString(){
        //TODO
        return "";
    }
}
