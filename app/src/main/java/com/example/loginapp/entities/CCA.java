package com.example.loginapp.entities;

import com.example.loginapp.enums.CCA_Category;

public class CCA {

    private String name;
    private String description;
    private CCA_Category category;


    // Default Constructor
    public CCA(){}

    // Overloading Constructors
    public CCA(String name, String description){}


    // Getters and Setters
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public CCA_Category getCategory(){
        return category;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setCategory(CCA_Category category){
        this.category = category;
    }


}
