package com.example.loginapp.enums;

public enum Member_Type {
    FT("Full-Time"),
    PT("Part-Time");

    private final String name;

    Member_Type(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
