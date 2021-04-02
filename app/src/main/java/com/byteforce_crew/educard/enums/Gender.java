package com.byteforce_crew.educard.enums;

import androidx.annotation.NonNull;

public enum Gender {
    /* Default Genders */
    F("Female"),
    M("Male");

    private final String gender;

    Gender(String gender){
        this.gender = gender;
    }

    @NonNull
    @Override
    public String toString(){
        return gender;
    }
}
