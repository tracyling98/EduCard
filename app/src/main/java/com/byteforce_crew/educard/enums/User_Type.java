package com.byteforce_crew.educard.enums;

import androidx.annotation.NonNull;

import com.google.firebase.firestore.Exclude;


public enum User_Type {
    /* User Privilege */
    STUDENT("Student"),
    TEACHER("Teacher"),
    ADMIN("Administrator"); // For app staff

    private final String type;

    User_Type(String type){
        this.type = type;
    }

    @NonNull
    @Override
    public String toString(){
        return type;
    }
}



