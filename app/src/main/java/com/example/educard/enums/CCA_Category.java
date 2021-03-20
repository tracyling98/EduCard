package com.example.educard.enums;


// 4 Main Categories
public enum CCA_Category {
    SPORTS("Physical Sports"),
    P_ARTS("Performing Arts"),
    U_GROUP("Uniformed Groups"),
    CLUBS("Clubs & Societies");

    private String name;

    CCA_Category(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
