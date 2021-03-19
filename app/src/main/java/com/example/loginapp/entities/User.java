package com.example.loginapp.entities;

import androidx.annotation.NonNull;

import com.example.loginapp.enums.Member_Type;
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
    protected Member_Type member_type; // Full time or Part time

    // Default Constructor
    public User() {}

    // Other Constructors (Overloading)
    public User(String username, String firstname, String lastname, User_Type user_type, Gender userGender,
                Nationality nationality, Member_Type member_type){
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.user_type = user_type;
        this.gender = userGender;
        this.nationality = nationality;
        this.member_type = member_type;
    }

    public User(User user){
        this(user.username, user.firstname, user.lastname, user.user_type, user.gender, user.nationality, user.member_type);
    }

    // Getters and Setters
    public String getUsername(){
        return username;
    }

    public String getFirstname(){
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public User_Type getUserType(){
        return user_type;
    }

    public Gender getUserGender(){
        return gender;
    }

    public Nationality getNationality(){
        return nationality;
    }

    public Member_Type getMember_type(){
        return member_type;
    }

    public void setUsername(String username){
        // Include some validation before storing the values
        this.username = username;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public void setUserType(User_Type user_type){
        this.user_type = user_type;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public void setNationality(Nationality nationality){
        this.nationality = nationality;
    }

    public void setJoin_date(Member_Type member_type){
        this.member_type = member_type;
    }

    @NonNull
    public String toString(){
        return String.format("Username: %s\nFirstname: %s\nLastname: %s\nUser Type: %s\nGender: %s\nNationality: %s\nMember Type: %s\n",
                username, firstname, lastname, user_type, gender, nationality, member_type);
    }
}
