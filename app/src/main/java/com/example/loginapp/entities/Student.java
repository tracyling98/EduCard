package com.example.loginapp.entities;

import com.example.loginapp.enums.Course;
import com.example.loginapp.enums.Gender;
import com.example.loginapp.enums.Nationality;
import com.example.loginapp.enums.Study_Year;
import com.example.loginapp.enums.User_Type;

public class Student extends User{

    private Course course;
    private String enrol_date;
//    private Study_Year studyYear;
//    private double attendance_rates;
    private CCA cca;

    // Default Constructor
    public Student(){}

    // Constructor Overloading
    public Student(String username, String firstname, String lastname, User_Type user_type, Gender gender, Nationality nationality, Course course, String enrol_date, CCA cca){
        super(username, firstname,lastname, user_type, gender, nationality); // Parent Constructor Call
        this.course = course;
        this.enrol_date = enrol_date;
        this.cca = cca;
    }

    public Student(Student student){
        this(student.username, student.firstname, student.lastname, student.user_type, student.gender, student.nationality, student.course, student.enrol_date, student.cca);
    }


    // Getter and Setter
    public Course getCourse(){
        return course;
    }

//    public Study_Year getStudyYear(){
//        return studyYear;
//    }

    public CCA getCCA(){
        return cca; // This is a CCA object
    }

    public void setCourse(Course course){
        this.course = course;
    }

//    public void setStudyYear(Study_Year studyYear){
//        this.studyYear = studyYear;
//    }

    public void setCCA(CCA cca){
        this.cca = cca;
    }



}
