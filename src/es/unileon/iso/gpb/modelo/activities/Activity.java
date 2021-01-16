
package es.unileon.iso.gpb.modelo.activities;

import java.time.*;
import java.awt.Color;

/**
 *
 * @author Roberto
 */
public class Activity {
    private long ID;
    private String name;
    private LocalDate date;
    private LocalTime endTime;
    private LocalTime startTime;
    private String comments;
    private Color color;
    
 
    public Activity(long ID, String name, LocalDate date, LocalTime endTime, LocalTime startTime){
        this.ID=ID;
        this.name=name;
        this.date=date;
        this.endTime=endTime;
        this.startTime = startTime;
        this.comments="";
    }
        
    public Activity(long ID, String name, LocalDate date, LocalTime endTime, LocalTime startTime, String comments, Color color){
        this.ID=ID;
        this.name=name;
        this.date=date;
        this.endTime=endTime;
        this.startTime=startTime;
        this.comments=comments;
        this.color=color; 
    }
    public Activity(long ID, String name, LocalDate date, LocalTime endTime, LocalTime startTime, Color color){
        this.ID=ID;
        this.name=name;
        this.date=date;
        this.endTime=endTime;
        this.startTime=startTime;
        this.comments="";
        this.color=color; 
    }
    public Activity(long ID, String name, LocalDate date, LocalTime endTime, LocalTime startTime, String comments){
        this.ID=ID;
        this.name=name;
        this.date=date;
        this.endTime=endTime;
        this.startTime=startTime;
        this.comments=comments; 
    }
        
    public void setID(long ID){
        this.ID = ID;
    }
    public void setName(String name){
        this.name=name;
    }
    
    public void setDate(LocalDate date){
        this.date=date;
    }
    
    public void setEndTime(LocalTime endTime){
        this.endTime=endTime;
       
    }
    
    public void setStartTime(long duration){
        this.startTime=startTime;
        
    }
    
    public void setComments(String comments){
        this.comments=comments;
        
    }
    
    public void setColor(Color color){
        this.color=color; 
    }
    
    public long getID(){
        return this.ID;
    }
    
    public String getName(){
        return this.name;
    }
    
    public LocalDate getDate(){
        return this.date;
    }
    
    public LocalTime getEndTime(){
        return this.endTime;
    }
    
    public LocalTime getStartTime(){
        return this.startTime;
    }
    
    public String getComments(){
        return this.comments;
    }
    
    public Color getColor(){
        return this.color;
    }
    
    public void modify(){
        //TODO
    }
    
    @Override
    public String toString(){
        //TODO
        return "";
    }
            
}
