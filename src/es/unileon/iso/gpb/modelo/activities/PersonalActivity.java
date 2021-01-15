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
public class PersonalActivity extends Activity{
    
    //TODO
    /*
    * Añadir constructores sobrecargados
    */
    public PersonalActivity(long ID, String name, LocalDate date, LocalTime endTime, LocalTime startTime, String comments, Color color) {
        super(ID, name, date, endTime, startTime, comments, color);
    }
    
    public PersonalActivity(long ID, String name, LocalDate date, LocalTime endTime, LocalTime startTime, Color color) {
        super(ID, name, date, endTime, startTime, color);
    }
    
    @Override
    public String toString(){
        //TODO
        return "";
    }
}
