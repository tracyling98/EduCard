package com.byteforce_crew.educard.entities;

import androidx.annotation.NonNull;

import com.byteforce_crew.educard.enums.Country;
import com.byteforce_crew.educard.enums.Gender;
import com.byteforce_crew.educard.enums.User_Type;

public class User {

    // -- User Properties --
    protected String username; /* Document ID */
    protected String password;
    protected String firstname;
    protected String lastname;
    protected String contact_number;
    protected User_Type user_type;
    protected Gender gender;
    protected Country nationality;


    // -- Default Constructor --
    public User() {}

    // -- Other Constructors (Overloading) --
    public User(String username, String password, String firstname, String lastname, String contact_number, User_Type user_type, Gender userGender,
                Country nationality){
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.contact_number = contact_number;
        this.user_type = user_type;
        this.gender = userGender;
        this.nationality = nationality;
    }

    public User(User user){
        this(user.username, user.password, user.firstname, user.lastname, user.contact_number,
                user.user_type, user.gender, user.nationality);
    }

    // -- Getters --
    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname(){
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public String getContact_number(){
        return contact_number;
    }

    public User_Type getUserType(){
        return user_type;
    }

    public Gender getUserGender(){
        return gender;
    }

    public Country getNationality(){
        return nationality;
    }

    // -- Setters --
    public void setUsername(String username){

        // -- Include some validation before storing the values --
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public void setContact_number(String contact_number){
        this.contact_number = contact_number;
    }

    public void setUserType(User_Type user_type){
        this.user_type = user_type;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public void setNationality(Country nationality){
        this.nationality = nationality;
    }

    // -- ToString Method --
    @NonNull
    public String toString(){
        return String.format("Username: %s\nFirstname: %s\nLastname: %s\nUser Type: %s\nGender: %s\nNationality: %s\n",
                username, firstname, lastname, user_type, gender, nationality);
    }
}
