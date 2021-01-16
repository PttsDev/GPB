/*
 * Clase encargada de registrar lo seleccionado por los usuarios
 */
package es.unileon.iso.gpb.controller;

import es.unileon.iso.gpb.modelo.DAO.ActivityDAO;
import es.unileon.iso.gpb.modelo.DAO.GroupDAO;
import es.unileon.iso.gpb.modelo.DAO.LectureDAO;
import es.unileon.iso.gpb.modelo.DAO.MeetingDAO;
import es.unileon.iso.gpb.modelo.DAO.PersonalActivityDAO;
import es.unileon.iso.gpb.modelo.DAO.StudentDAO;
import es.unileon.iso.gpb.modelo.DAO.SubjectDAO;
import es.unileon.iso.gpb.modelo.DAO.TeacherDAO;
import es.unileon.iso.gpb.modelo.DAO.TutorshipDAO;
import es.unileon.iso.gpb.modelo.DAO.UserDAO;
import es.unileon.iso.gpb.modelo.activities.Activity;
import es.unileon.iso.gpb.modelo.activities.Lecture;
import es.unileon.iso.gpb.modelo.activities.Lectures;
import es.unileon.iso.gpb.modelo.activities.Meeting;
import es.unileon.iso.gpb.modelo.activities.PersonalActivity;
import es.unileon.iso.gpb.modelo.activities.Tutorship;
import es.unileon.iso.gpb.modelo.sets.Group;
import es.unileon.iso.gpb.modelo.users.Student;
import es.unileon.iso.gpb.modelo.users.Teacher;
import es.unileon.iso.gpb.modelo.users.User;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.Color;

/**
 *
 * @author Angel
 */
public class Controller {

    // DUDA: SE PUEDE PASAR POR ATRIBUTO Teacher teacher por ejemplo o siempre
    // nombre, etc... y crearlo en ese metodo
    // Esto es basicamente el esqueleto
    public static boolean registerUser(String name, String surName, String DNI, String email, String userName,
            String pw, String tipo) {

        // User user = new User(name, surName, DNI, email, userName, pw);
        if (tipo == "Teacher") {

            return registTeacher(name, surName, DNI, email, userName, pw);

        } else if (tipo == "Student") {
            return registStudent(name, surName, DNI, email, userName, pw);
        }
        return false;
    }

    public static boolean registTeacher(String name, String surName, String DNI, String email, String userName, String pw) {

        int i = 0;

        UserDAO userDAO = new UserDAO();

        Teacher teacher = new Teacher(name, surName, DNI, email, userName);

        teacher.setPw(pw);

        i = userDAO.registerUser(teacher);

        if (i != 0) {

            teacher.setID(String.valueOf(i));

            TeacherDAO teacherDAO = new TeacherDAO();

            if (teacherDAO.registerTeacher(teacher.getID()) == true) {
                return true;
            } else {
                return false;
            }
        }
        return false;

    }

    public static boolean registStudent(String name, String surName, String DNI, String email, String userName,
            String pw) {

        int i;

        UserDAO userDAO = new UserDAO();

        Student student = new Student(name, surName, DNI, email, userName);

        student.setPw(pw);

        i = userDAO.registerUser(student);

        if (i != 0) {

            student.setID(String.valueOf(i));

            StudentDAO studentDAO = new StudentDAO();

            if (studentDAO.registerStudent(student.getID()) == true) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static User loginUser(String userName, String pw) {
        UserDAO userDAO = new UserDAO();

        if (userDAO.userLogIn(userName, pw) == true) {
            User user = userDAO.getUser(userName);
            return user;
        }

        return null;
    }

    public static String getTipo(String UserID) {
        TeacherDAO teacherDAO = new TeacherDAO();
        String type;

        if (teacherDAO.teacherExist(UserID)) {
            type = "Teacher";
        } else {
            type = "Student";
        }

        return type;

    }

    public static boolean changePassword(String userName, String pw, String newPw) {
        UserDAO userDAO = new UserDAO();

        if (userDAO.userLogIn(userName, pw) == true) {
            userDAO.changePassword(userName, newPw);
            return true;
        }
        return false;
    }

    public static boolean changePassword(String userName, String newPw) {
        UserDAO userDAO = new UserDAO();

        userDAO.changePassword(userName, newPw);
        return true;
    }

    public static boolean changeEmail(String userName, String newEmail) {
        UserDAO userDAO = new UserDAO();

        return userDAO.changeEmail(userName, newEmail);

    }

    public static ArrayList<String> listUser() {
        UserDAO userDAO = new UserDAO();
        return userDAO.listUser();
    }

    public static boolean removeUser(String ID) {
        UserDAO userDAO = new UserDAO();

        return userDAO.deleteUser(ID);

    }

    public static User getUser(String userName) {
        UserDAO userDAO = new UserDAO();
        return userDAO.getUser(userName);
    }

    public static ArrayList<String> listSubjectHave(String ID) {
        StudentDAO userDAO = new StudentDAO();
        if (userDAO.studentExist(ID)) {
            return listSubjectHaveStu(ID);
        } else {
            return listSubjectHaveTea(ID);
        }
    }

    public static ArrayList<String> listSubjectNotHave(String ID) {
        StudentDAO userDAO = new StudentDAO();
        if (userDAO.studentExist(ID)) {
            return listSubjectNotHaveStu(ID);
        } else {
            return listSubjectNotHaveTea(ID);
        }
    }

    public static ArrayList<String> listSubjectHaveStu(String ID) {
        SubjectDAO subjectDAO = new SubjectDAO();
        return subjectDAO.listStuSubSubjects(ID);
    }

    public static ArrayList<String> listSubjectNotHaveStu(String ID) {
        SubjectDAO subjectDAO = new SubjectDAO();

        ArrayList<String> allSubjects, haveSubjects, notHaveSubjects;

        haveSubjects = subjectDAO.listStuSubSubjects(ID);
        allSubjects = subjectDAO.listAllSubjects();
        notHaveSubjects = allSubjects;

        for (int i = 0; i < allSubjects.size(); i++) {
            for (int j = 0; j < haveSubjects.size(); j++) {
                if (allSubjects.get(i).compareTo(haveSubjects.get(j)) == 0) {
                    notHaveSubjects.remove(haveSubjects.get(j));
                }
            }
        }
        return notHaveSubjects;
    }

    public static ArrayList<String> listSubjectHaveTea(String ID) {
        SubjectDAO subjectDAO = new SubjectDAO();

        return subjectDAO.listTeaSubSubjects(ID);
    }

    public static ArrayList<String> listSubjectNotHaveTea(String ID) {
        SubjectDAO subjectDAO = new SubjectDAO();

        ArrayList<String> allSubjects, haveSubjects, notHaveSubjects;

        haveSubjects = subjectDAO.listTeaSubSubjects(ID);
        allSubjects = subjectDAO.listAllSubjects();
        notHaveSubjects = allSubjects;

        for (int i = 0; i < allSubjects.size(); i++) {
            for (int j = 0; j < haveSubjects.size(); j++) {
                if (allSubjects.get(i).compareTo(haveSubjects.get(j)) == 0) {
                    notHaveSubjects.remove(haveSubjects.get(j));
                }
            }
        }
        return notHaveSubjects;
    }

    public static void joinSubject(String ID, String subjectName) {
        StudentDAO userDAO = new StudentDAO();
        SubjectDAO subDAO = new SubjectDAO();
        if (userDAO.studentExist(ID)) {
            subDAO.joinSubjectStu(ID, subjectName);
        } else {
            subDAO.joinSubjectTea(ID, subjectName);
        }
    }
    
    public static void leaveSubject(String ID, String subjectName) {
        StudentDAO userDAO = new StudentDAO();
        SubjectDAO subDAO = new SubjectDAO();
        if (userDAO.studentExist(ID)) {
            subDAO.leaveStuSubject(ID, subjectName);
        } else {
            subDAO.leaveTeaSubject(ID, subjectName);
        }
    }

    public static boolean createGroup(String subject, String number, String type, String userID) {
    	    	
    	GroupDAO groupDAO = new GroupDAO();
    
    	boolean sol = groupDAO.createGroup( subject,  number, type);
        groupDAO.assignTeaGroup(userID, subject, number);
        return sol;
    	
    }  
    
    public static ArrayList<String> listGroups(String nameSubject){
    	GroupDAO groupDAO = new GroupDAO();
    	
    	return groupDAO.listGroups(nameSubject);
    }
    
    public static String findGroup(String userID, String subjectName) {
    	GroupDAO groupDAO = new GroupDAO();
    	
    	return groupDAO.findGroup(userID, subjectName);
    }
    
    public static boolean assignStuGroup(String userID, String subject, String nameGroup) {
    	GroupDAO groupDAO = new GroupDAO();
    	String part[] = nameGroup.split(" ");
    	return groupDAO.assignStuGroup(userID, subject, part[0]);
    }
    
    public static boolean deleteGroup(String subject, String nameGroup) {
    	
    	GroupDAO groupDAO = new GroupDAO();
    	String part[] = nameGroup.split(" ");
    	return groupDAO.deleteGroup(subject, part[0]);
    	
    }
    
    public static ArrayList<String> listStudents(){
    	UserDAO userDAO = new UserDAO();
    	return userDAO.listStudent();
    }
    
    public static ArrayList<String> listTeachers(){
    	UserDAO teacherDAO = new UserDAO();
    	return teacherDAO.listTeacher();
    }
    
    public static ArrayList<String> listGroup(String teacherID){
    	GroupDAO groupDAO = new GroupDAO();
    	return groupDAO.listGroup(teacherID);
    }
    
    public static boolean createActivity(String actName, LocalDate date, LocalTime sHour, LocalTime eHour, java.awt.Color color, String type, String userID) {
    	long ID = (long) (Math.random()*100+1);
    	Activity activity = new Activity(ID, actName, date, eHour, sHour, color);
    	PersonalActivity personalActivity = new PersonalActivity(ID, actName, date, eHour, sHour, color);
    	ActivityDAO activityDAO = new ActivityDAO();
    	PersonalActivityDAO personalActivityDAO = new PersonalActivityDAO();
    	int id;
    	
    	if(type == "Personal") {
    		id = activityDAO.createActivity(activity);
    		return personalActivityDAO.createPersonalActivity(personalActivity, id, userID);
    	}
    	return false;
    }

    public static boolean createActivity(String actName, LocalDate date, LocalTime sHour, LocalTime eHour, java.awt.Color color, String comments, String type, String userID) {
    	long ID = (long) (Math.random()*100+1);
    	Activity activity = new Activity(ID, actName, date, eHour, sHour, comments);
    	PersonalActivity personalActivity = new PersonalActivity(ID, actName, date, eHour, sHour, comments, color);
    	ActivityDAO activityDAO = new ActivityDAO();
    	PersonalActivityDAO personalActivityDAO = new PersonalActivityDAO();
    	
    	int id;
    	
    	if(type == "Personal") {
    		id = activityDAO.createActivity(activity);
    		return personalActivityDAO.createPersonalActivity(personalActivity, id, userID);
    	}
    	return false;
    }
    
    public static boolean createActivity(String actName, LocalDate date, LocalTime sHour, LocalTime eHour, java.awt.Color color, String type, String place, String nameGroup, String userID) {
    	long ID = (long) (Math.random()*100+1);
    	Activity activity = new Activity(ID, actName, date, eHour, sHour, color);
    	Lecture lecture = new Lecture(ID, actName, date, eHour, sHour, color, "1");
    	ActivityDAO activityDAO = new ActivityDAO();
    	LectureDAO lectureDAO = new LectureDAO();
    	
    	int id;
    	
    	if(type == "Lecture") {
    		id = activityDAO.createActivity(activity);
            String grpYsub[] = nameGroup.split(" ");
            String asignatura = grpYsub[0];
            String numero = grpYsub[1];
            return lectureDAO.createActivity(lecture, numero, asignatura, id);
    	}
    	return false;
    }
    
    public static boolean createActivity(String actName, LocalDate date, LocalTime sHour, LocalTime eHour, java.awt.Color color, String type, String comments, String place, String nameGroup, String userID) {
    	long ID = (long) (Math.random()*100+1);
    	Activity activity = new Activity(ID, actName, date, eHour, sHour,comments, color);
    	Lecture lecture = new Lecture(ID, actName, date, eHour, sHour,comments, color, "1");
    	ActivityDAO activityDAO = new ActivityDAO();
    	LectureDAO lectureDAO = new LectureDAO();
    	
    	int id;
    	
    	if(type == "Lecture") {
    
    		id = activityDAO.createActivity(activity);
    		
            String grpYsub[] = nameGroup.split(" ");
            String asignatura = grpYsub[0];
            String numero = grpYsub[1];
            
            return lectureDAO.createActivity(lecture, numero, asignatura, id);
            
    	}
    	return false;
    } 
    
    public static boolean createActivity(String actName, LocalDate date, LocalTime sHour, LocalTime eHour, java.awt.Color color, String type, String place, String name, String userID, int aux) {
    	long ID = (long) (Math.random()*100+1);
    	Activity activity = new Activity(ID, actName, date, eHour, sHour, color);
    	ActivityDAO activityDAO = new ActivityDAO();
    	MeetingDAO meetingDAO = new MeetingDAO();
    	TutorshipDAO tutorshipDAO = new TutorshipDAO();
    	
    	int id;
    	id = activityDAO.createActivity(activity);
    	if(type == "Meeting") {
    		Meeting meeting = new Meeting(ID, actName, date, eHour, sHour, color, place);
    	
    		return meetingDAO.createMeeting(meeting, id, userID, name);
    	}else if(type == "Tutorship") {
    		Tutorship tutorship = new Tutorship(ID, actName, date, eHour, sHour, color, name, userID);
    		return tutorshipDAO.createTutorship(tutorship, name, id, userID);
    	}
    	return false;
    }
    
    public static boolean createActivity(String actName, LocalDate date, LocalTime sHour, LocalTime eHour, java.awt.Color color, String type, String comments, String place, String name, String userID, int aux) {
    	long ID = (long) (Math.random()*100+1);
    	Activity activity = new Activity(ID, actName, date, eHour, sHour,comments, color);
    	ActivityDAO activityDAO = new ActivityDAO();
    	MeetingDAO meetingDAO = new MeetingDAO();
    	TutorshipDAO tutorshipDAO = new TutorshipDAO();
    	
    	int id;
    	id = activityDAO.createActivity(activity);
    	
    	if(type == "Meeting") {
    		Meeting meeting = new Meeting(ID, actName, date, eHour, sHour, comments, color, place);
    		return meetingDAO.createMeeting(meeting, id, userID, name);
    	}else if(type == "Tutorship") {
    		Tutorship tutorship = new Tutorship(ID, actName, date, eHour, sHour,comments, color, name, userID);
    		return tutorshipDAO.createTutorship(tutorship, name, id, userID);
    	}
    	return false;
    }
    

    public static ArrayList<Lecture> listLectures(String userID, LocalDate minD, LocalDate maxD, String type){

    	LectureDAO lectureDAO = new LectureDAO();
    	ArrayList<Lecture> lista =  lectureDAO.listLectures(userID);
        ArrayList<Lecture> lista2 =  new ArrayList<Lecture>();

        
        for(Lecture l:lista){
            if(!(l.getDate().isBefore(minD) || l.getDate().isAfter(maxD)) ){
               lista2.add(l);
            }
        }
        
        return lista2;
    }
}
