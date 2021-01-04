/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.users;

import es.unileon.iso.gpb.modelo.activities.Meeting;
import es.unileon.iso.gpb.modelo.activities.Meetings;
import es.unileon.iso.gpb.modelo.activities.Tutorship;
import es.unileon.iso.gpb.modelo.activities.Tutorships;
import es.unileon.iso.gpb.modelo.sets.Subjects;

/**
 *
 * @author Roberto
 */
public class Teacher extends User{
    
    private Tutorships tutorships;
    private Meetings meetings;
    private String idTeacher;
    private Subjects subjects; //TODO
    
    public Teacher(String name, String surName, String DNI, String email, String idTeacher) {
        super(name, surName, DNI, email);
        
        this.tutorships = new Tutorships();
        this.meetings = new Meetings();
        this.subjects = new Subjects();
        this.idTeacher = idTeacher;
    }

    public String getIdTeacher() {
        return this.idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    /*
    * Metodos que gestionan las tutorship
    */
    public void addTutorship(Tutorship ts) {
        this.tutorships.add(ts);
    }
    
    public void removeTutorship(String name){
        this.tutorships.remove(name);
    }
    
    public void removeTutorship(long ID){
        this.tutorships.remove(ID);
    }
    
    public Tutorship searchTutorship(String name){
        return this.tutorships.get(this.tutorships.search(name));
    }
    
    public Tutorship searchTutorship(long ID){
        return this.tutorships.get(this.tutorships.search(ID));
    }
    
    /*
    * Metodos que gestionan los meetings
    */    
    public void addMeeting(Meeting mt) {
        this.meetings.add(mt);
    }
 
    public void removeMeeting(String name){
        this.meetings.remove(name);
    }
    
    public void removeMeeting(long ID){
        this.meetings.remove(ID);
    }
    
    public Meeting searchMeeting(String name){
        return this.meetings.get(this.meetings.search(name));
    }
    
    public Meeting searchMeeting(long ID){
        return this.meetings.get(this.meetings.search(ID));
    }

    @Override
    public String toString(){
        //TODO
        return "";
    }
    
}
