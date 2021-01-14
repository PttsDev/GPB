/*
 * Clase encargada de registrar lo seleccionado por los usuarios
 */
package es.unileon.iso.gpb.controller;

import es.unileon.iso.gpb.modelo.DAO.GroupDAO;
import es.unileon.iso.gpb.modelo.DAO.LectureDAO;
import es.unileon.iso.gpb.modelo.DAO.MeetingDAO;
import es.unileon.iso.gpb.modelo.DAO.PersonalActivityDAO;
import es.unileon.iso.gpb.modelo.DAO.StudentDAO;
import es.unileon.iso.gpb.modelo.DAO.TeacherDAO;
import es.unileon.iso.gpb.modelo.DAO.TutorshipDAO;
import es.unileon.iso.gpb.modelo.DAO.UserDAO;
import es.unileon.iso.gpb.modelo.activities.Activity;
import es.unileon.iso.gpb.modelo.activities.Lecture;
import es.unileon.iso.gpb.modelo.activities.Meeting;
import es.unileon.iso.gpb.modelo.activities.Tutorship;
import es.unileon.iso.gpb.modelo.sets.Group;
import es.unileon.iso.gpb.modelo.users.Student;
import es.unileon.iso.gpb.modelo.users.Teacher;
import es.unileon.iso.gpb.modelo.users.User;

import java.util.Date;
import java.sql.Time;
import java.awt.Color;

/**
 *
 * @author Angel
 */
public class Controller {

    //DUDA: SE PUEDE PASAR POR ATRIBUTO Teacher teacher por ejemplo o siempre nombre, etc... y crearlo en ese metodo
    //Esto es basicamente el esqueleto

    public static User registerUser(String name, String surName, String DNI, String email, String userName, String pw, String tipo){

        //User user = new User(name, surName, DNI, email, userName, pw);

        

        if(tipo == "Teacher"){
        
           return registTeacher(name, surName, DNI, email, userName, pw);

        }else if(tipo == "Student"){
           return registStudent(name, surName, DNI, email, userName, pw);
        }

        return null;
    }

    public static Teacher registTeacher(String name, String surName, String DNI, String email, String userName, String pw){
        
        UserDAO userDAO = new UserDAO();
        
        Teacher teacher = new Teacher(name, surName, DNI, email, userName);

        TeacherDAO teacherDAO = new TeacherDAO();

        if(teacherDAO.registerTeacher(teacher)==true){
            return teacher;
        }else{
            return null;
        }

    }

    public static Student registStudent(String name, String surName, String DNI, String email, String userName, String pw){
        
        int i;

        UserDAO userDAO = new UserDAO();
        
        Student student = new Student(name, surName, DNI, email, userName);

        i= userDAO.registerUser(student);

        if(i!=0){

            student.setID(String.valueOf(i));

            StudentDAO studentDAO = new StudentDAO();

            if(studentDAO.registerStudent(student.getID())==true){
                return student;
            }else{
                return null;
            }
        }   
        
    }

    public User loginUser(String user, String pw){
        UserDAO userDAO = new UserDAO();
        //Llamar al DAO
        return null;
    }

    //Visualizar calendario personal

    public Activity createPersonalActivity(long ID, String name, Date date, Time endTime, long duration, String comments, Color color){
        //eeeeeee
        //Activity activity = new Activity(ID, name, date, endTime, duration, comments, color);
        PersonalActivityDAO personalActivityDAO = new PersonalActivityDAO();
        //Llamar al DAO.
        return null;
    }

    /*
    Crear una activity personal por cada tipo que puede modificar?
    */

    public boolean removePersonalActivity(long ID, User user){//boolean o user?

        UserDAO userDAO = new UserDAO();
        //Llamar a borrarActividad de Dao
        return false;

    }

    /*
    Mostrar Actividades?
    */
    public Activity showActivity(User user){
        return null;
    }

    public boolean selectGroup(User user, Group group){//boolean o group?
        GroupDAO groupDAO = new GroupDAO();//El grupo ya tiene que estar creado
        return false;
    }

    public Lecture showLectures(User user){
        LectureDAO lectureDAO = new LectureDAO();
        return null;
    }

    public Tutorship showTutorship(User user){
        TutorshipDAO tutorshipDAO = new TutorshipDAO();
        return null;
    }

    //Haria falta un ClaseDao?

    public Group createGroup(Teacher teacher, int number, String type){
        Group group = new Group(number, type);
        GroupDAO groupDAO = new GroupDAO();
        //comprobar el grupo del profesor
        return null;
    }

    public Group modifyGroup(Teacher teacher, Group group){
        GroupDAO groupDAO = new GroupDAO();
        return null;
    }

    public boolean removeGroup(Teacher teacher, Group group){
        GroupDAO groupDAO = new GroupDAO();
        return false;
    }

    public Meeting createMeeting(Teacher teacher){//Al elegir quienes son, se le pasa por atributo la lista de alumnos?
        return null;
    }

    public Meeting modifyMeeting(Teacher teacher, Meeting meeting){
        MeetingDAO meetingDAO = new MeetingDAO();
        return null;
    }

    public boolean removeMeeting(Teacher teacher, Meeting meeting){
        MeetingDAO meetingDAO = new MeetingDAO();
        return false;
    }

}
