/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.users;

import es.unileon.iso.gpb.modelo.activities.PersonalActivities;
import es.unileon.iso.gpb.modelo.activities.PersonalActivity;
import es.unileon.iso.gpb.modelo.activities.Tutorship;
import es.unileon.iso.gpb.modelo.activities.Tutorships;
import es.unileon.iso.gpb.modelo.sets.Subject;
import es.unileon.iso.gpb.modelo.sets.Subjects;
import java.util.ArrayList;

/**
 *
 * @author Roberto
 */
public class Student extends User {

    private PersonalActivities persAct;
    private Tutorships tutorships;
    private Subjects subjects;

    private ArrayList<Integer> group; //TODO METODOS, ETC

    public Student() {
    }

    public Student(String name, String surName, String DNI, String email, String username) {
        super(name, surName, DNI, email, username);
        this.tutorships = new Tutorships();
        this.persAct = new PersonalActivities();
        this.subjects = new Subjects();
        this.group = new ArrayList<Integer>();
    }



    public Student(User user) {
		super(user.getName(), user.getSurName(), user.getDNI(), user.getEmail(), user.getUserName());
	}

	/*
    * Metodos que gestionan las activity
     */
    public void addPersonalActivity(PersonalActivity pa) {
        this.persAct.add(pa);
    }

    public void removePersonalActivity(String name) {
        this.persAct.remove(name);
    }

    public void removePersonalActivity(long ID) {
        this.persAct.remove(ID);
    }

    public PersonalActivity searchPersonalActivity(String name) {
        return this.persAct.get(this.persAct.search(name));
    }

    public PersonalActivity searchPersonalActivity(long ID) {
        return this.persAct.get(this.persAct.search(ID));
    }

    /*
    * Metodos que gestionan los tutorships
     */
    public void addTutorship(Tutorship ts) {
        this.tutorships.add(ts);
    }

    public void removeTutorship(String name) {
        this.tutorships.remove(name);
    }

    public void removeTutorship(long ID) {
        this.tutorships.remove(ID);
    }

    public Tutorship searchTutorship(String name) {
        return this.tutorships.get(this.tutorships.search(name));
    }

    public Tutorship searchTutorship(long ID) {
        return this.tutorships.get(this.tutorships.search(ID));
    }

    /*
    * Metodos que gestionan las subjects
     */
    public void addSubject(Subject sb) {
        this.subjects.add(sb);
    }

    public void removeSubject(String name) {
        this.subjects.remove(name);
    }

    public void removeSubject(long ID) {
        this.subjects.remove(ID);
    }

    public Subject searchSubject(String name) {
        return this.subjects.get(this.subjects.search(name));
    }

    public Subject searchSubject(long ID) {
        return this.subjects.get(this.subjects.search(ID));
    }

    @Override
    public String toString() {
        //TODO
        return "";
    }
}
