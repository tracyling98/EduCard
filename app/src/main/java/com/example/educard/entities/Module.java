package com.example.educard.entities;

import androidx.annotation.NonNull;

public class Module {

    private String module_code;
    private String module_name;
    private String module_description;

    // Default Constructor
    public Module(){}

    // Overloading Constructor
    public Module(String module_code, String module_name, String module_description){
        this.module_code = module_code;
        this.module_name = module_name;
        this.module_description = module_description;
    }

    public Module(Module module){
        this(module.module_code, module.module_name, module.module_description);
    }

    // Getters and Setters
    public String getModule_code(){
        return module_code;
    }

    public String getModule_name(){
        return module_name;
    }

    public String getModule_description(){
        return module_description;
    }

    public void setModule_code(String module_code){
        this.module_code = module_code;
    }

    public void setModule_name(String module_name){
        this.module_name = module_name;
    }

    public void setModule_description(String module_description){
        this.module_description = module_description;
    }

    @NonNull
    public String toString(){
        return String.format("Module Name: %s\nModule Code: %s\nModule Description: %s\n",
                module_name, module_code, module_description);
    }
}
