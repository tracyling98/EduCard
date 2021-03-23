package com.byteforce_crew.educard.entities;

import androidx.annotation.NonNull;

import com.byteforce_crew.educard.enums.Country;
import com.byteforce_crew.educard.enums.Gender;
import com.byteforce_crew.educard.enums.Member_Type;
import com.byteforce_crew.educard.enums.User_Type;

public class Teacher extends User{

    private String position;
    private String join_date;

    // Default Constructor
    public Teacher(){}

    // Overloading Constructor
    public Teacher(String username, String password, String firstname, String lastname, User_Type user_type, Gender gender,
                   Country nationality, Member_Type member_type, String position, String join_date){

        super(username, password, firstname, lastname, user_type, gender, nationality, member_type); // Parent Constructor Call
        this.position = position;
        this.join_date = join_date;
    }

    public Teacher(Teacher teacher){
        this(teacher.username, teacher.password, teacher.firstname, teacher.lastname, teacher.user_type,
                teacher.gender, teacher.nationality, teacher.member_type, teacher.position, teacher.join_date);

    }

    // Getter and Setter
    public String getPosition(){
        return position;
    }

    public String getJoin_date(){
        return join_date;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public void setJoin_date(String join_date){
        this.join_date = join_date;
    }

    @NonNull
    @Override
    public String toString(){
        return String.format("%sPosition: %s\nJoined Date: %s\n", super.toString(), position, join_date);
    }
}
