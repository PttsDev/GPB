
package es.unileon.iso.gpb.modelo.activities;

import java.util.Date;
import java.sql.Time;
import java.awt.Color;

/**
 *
 * @author Roberto
 */
public class Activity {
    private long ID;
    private String name;
    private Date date;
    private Time endTime;
    private long duration;
    private String comments;
    private Color color;
    
    
    public Activity(long ID, String name, Date date, Time endTime, long duration, String comments, Color color){
        this.ID=ID;
        this.name=name;
        this.date=date;
        this.endTime=endTime;
        this.duration=duration;
        this.comments=comments;
        this.color=color; 
    }
    
    public void setID(long ID){
        this.ID = ID;
    }
    public void setName(String name){
        this.name=name;
    }
    
    public void setDate(Date date){
        this.date=date;
    }
    
    public void setEndTime(Time endTime){
        this.endTime=endTime;
       
    }
    
    public void setDuration(long duration){
        this.duration=duration;
        
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
    
    public Date getDate(){
        return this.date;
    }
    
    public Time getEndTime(){
        return this.endTime;
    }
    
    public long getDuration(){
        return this.duration;
    }
    
    public String getComments(){
        return this.comments;
    }
    
    public Color getColor(){
        return this.color;
    }
    
    public void modify(){
        
    }
    
            
}
