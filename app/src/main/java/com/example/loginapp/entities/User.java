package com.example.loginapp.entities;

import com.example.loginapp.enums.Nationality;
import com.example.loginapp.enums.User_Type;
import com.example.loginapp.enums.Gender;

public class User {

    // User Properties
    protected String username;
    protected String firstname;
    protected String lastname;
    protected User_Type user_type;
    protected Gender gender;
    protected Nationality nationality;

    // Default Constructor
    public User() {}

    // Other Constructors (Overloading)
    public User(String username, String firstname, String lastname, User_Type user_type, Gender userGender, Nationality nationality){
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.user_type = user_type;
        this.gender = userGender;
        this.nationality = nationality;
    }

    public User(User user){
        this(user.username, user.firstname, user.lastname, user.user_type, user.gender, user.nationality);
    }

    // Getters and Setters
    public String getUsername(){
        return this.username;
    }

    public User_Type getUserType(){
        return this.user_type;
    }

    public Gender getUserGender(){
        return this.gender;
    }

    public Nationality getNationality(){
        return this.nationality;
    }

    public void setUsername(String username){
        // Include some validation before storing the values
        this.username = username;
    }

    public void setUserType(User_Type user_type){
        this.user_type = user_type;
    }

    public void setUserGender(Gender gender){
        this.gender = gender;
    }
    public void setNationality(Nationality nationality){
        this.nationality = nationality;
    }
}
