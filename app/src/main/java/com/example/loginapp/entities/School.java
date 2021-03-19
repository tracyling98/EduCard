package com.example.loginapp.entities;

import androidx.annotation.NonNull;

import com.example.loginapp.enums.Country;

public class School {

    protected String name;
    protected String description;
    protected Country country;
    protected String build_year;

    // Default Constructor
    public School(){}

    // Overloading Constructor
    public School(String name, String description, Country country,String build_year){
        this.name = name;
        this.description = description;
        this.country = country;
        this.build_year = build_year;
    }

    public School(School school){
        this(school.name, school.description, school.country, school.build_year);
    }

    // Getters and Setters
    public String getName(){
        return name;
    }

    public Country getCountry(){
        return country;
    }

    public String getBuild_year(){
        return build_year;
    }

    public String getDescription(){
        return description;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCountry(Country country){
        this.country = country;
    }

    public void setBuild_year(String build_year){
        this.build_year = build_year;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @NonNull
    public String toString(){
        return String.format("School Name: %s\nDescription: %s\nCountry: %s\nBuild Year: %s\n",
                name, description, country, build_year);
    }

}
