package com.example.loginapp.entities;

import com.example.loginapp.enums.Gender;
import com.example.loginapp.enums.Member_Type;
import com.example.loginapp.enums.User_Type;

public class Teacher extends User{

    private String position;
    private Member_Type member_type; // Full time or Part time
    private String join_date;

    // Default Constructor
    public Teacher(){}

    // Overloading Constructor
    public Teacher(String username, User_Type user_type, Gender gender, String position, Member_Type member_type, String join_date){
        super(username, user_type, gender); // Parent Constructor Call
        this.position = position;
        this.member_type = member_type;
        this.join_date = join_date;
    }

    // Getter and Setter
    public String getPosition(){
        return position;
    }

    public Member_Type getMember_type(){
        return member_type;
    }

    public String getJoin_date(){
        return join_date;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public void setJoin_date(Member_Type member_type){
        this.member_type = member_type;
    }
    public void setJoin_date(String join_date){
        this.join_date = join_date;
    }
}
