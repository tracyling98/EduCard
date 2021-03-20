package com.example.educard.testinfo;

// Credentials Class (Without Database Comparison) -- For Testing
public class Credentials {

    // Admin
    private final String adminUser = "Admin";
    private final String adminPassword = "1234";

    // Lecturer
    private final String teacherUser = "Teacher";
    private final String teacherPassword = "1234";

    // Student 01
    private final String std01 = "Std01";
    private final String std01Password = "1234";

    // Student 02
    private final String std02 = "Std02";
    private final String std02Password = "1234";


    // Default Constructor
    public Credentials(){}

    // Getters
    public String adminUser(){
        return adminUser;
    }

    public String adminPassword(){
        return adminPassword;
    }

    public String teacherUser(){
        return teacherUser;
    }

    public String teacherPassword(){
        return teacherPassword;
    }

    public String std01(){
        return std01;
    }

    public String std01Password(){
        return std01Password;
    }

    public String std02(){
        return std02;
    }

    public String std02Password(){
        return std02Password;
    }

}

