package com.example.educard.enums;

public enum Course {
    CS_CyberSec("Computer Science (Cyber Security)"),
    CS_DSS("Computer Science (Digital System Security)"),
    CS_DATA("Computer Science (Big Data)"),
    CS_GAME("Computer Science (Game and Mobile Development");


    private String courseName;

    // Constructor
    Course(String courseName){
        this.courseName = courseName;
    }

    // Getter
    public String getCourseName(){
        return courseName;
    }
}
