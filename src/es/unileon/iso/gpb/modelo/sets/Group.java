/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.sets;

import es.unileon.iso.gpb.modelo.activities.Lecture;
import es.unileon.iso.gpb.modelo.activities.Lectures;
import es.unileon.iso.gpb.modelo.users.Student;
import es.unileon.iso.gpb.modelo.users.Students;
import es.unileon.iso.gpb.modelo.users.Teacher;
import es.unileon.iso.gpb.modelo.users.Teachers;

/**
 *
 * @author Roberto
 */
public class Group {
    
    private int number;
    private String type;
    private Lectures lectures;
    private Students students;
    private Teachers teachers;
    
    public Group(int number, String type) {
        this.number = number;
        this.type = type;
        this.lectures = new Lectures();
        this.students = new Students();
        this.teachers = new Teachers();
    }
    
    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*
    * Funciones que manejan las lectures
    */
    public void addLecture(Lecture lect){
        this.lectures.add(lect);
    }
    
    public void removeLecture(String name) {
        this.lectures.remove(name);
    }
    
    public void removeLecture(long ID) {
        this.lectures.remove(ID);
    }
    
    public Lecture searchLecture(String name){
        return this.lectures.get(this.lectures.search(name));
    }
    
    public Lecture searchLecture(long ID){
        return this.lectures.get(this.lectures.search(ID));
    }
    
    /*
    * Funciones que manejan los students
    */
    public void addStudent(Student st){
        this.students.add(st);
    }
    
    public void removeStudent(String ID) {
        this.students.remove(ID);
    }
    
    public Student searchStudent(String ID){
        return this.students.get(this.students.search(ID));
    }
    /*
    * Funciones que manejan los teachers
    */
    public void addTeacher(Teacher tc){
        this.teachers.add(tc);
    }
    
    public void removeTeacher(String ID) {
        this.teachers.remove(ID);
    }
    
    public Teacher searchTeacher(String ID){
        return this.teachers.get(this.teachers.search(ID));
    }
    
    
    @Override
    public String toString() {
        //TODO
        return "";
    }
}
