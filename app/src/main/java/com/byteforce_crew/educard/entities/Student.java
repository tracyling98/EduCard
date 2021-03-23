package com.byteforce_crew.educard.entities;

import androidx.annotation.NonNull;

import com.byteforce_crew.educard.enums.Country;
import com.byteforce_crew.educard.enums.Course;
import com.byteforce_crew.educard.enums.Gender;
import com.byteforce_crew.educard.enums.Member_Type;
import com.byteforce_crew.educard.enums.User_Type;

public class Student extends User{

    private Member_Type member_type;
    private Course course;
    private String enrol_date;
//    private Study_Year studyYear;
//    private double attendance_rates;
    private CCA cca;

    // Default Constructor
    public Student(){}

    // Constructor Overloading
    public Student(String username, String password, String firstname, String lastname, User_Type user_type, Gender gender, Country nationality, Member_Type member_type, Course course, String enrol_date, CCA cca){
        super(username, password, firstname,lastname, user_type, gender, nationality, member_type); // Parent Constructor Call
        this.course = course;
        this.enrol_date = enrol_date;
        this.cca = cca;
    }

    public Student(Student student){
        this(student.username, student.password, student.firstname, student.lastname, student.user_type, student.gender,
                student.nationality, student.member_type, student.course, student.enrol_date, student.cca);
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

    @NonNull
    @Override
    public String toString(){
        return String.format("%sCourse: %s\nCCA: %s\nEnrol Date: %s\n", super.toString(), course, cca, enrol_date);
    }


}
