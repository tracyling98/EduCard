package com.byteforce_crew.educard.enums;

import androidx.annotation.NonNull;

public enum Grade {
    D("Distinction"),   /* -- [85% - 100%] -- */
    G("Good"),          /* -- [70% -  84%] -- */
    P("Pass"),          /* -- [50% -  69%] -- */
    F("Fail");          /* -- [ 0% -  49%] -- */

    /* -- Grade Parameter(s) -- */
    private String name;

    /* Enum Constructor */
    Grade(String name){
        this.name = name;
    }

    /* -- ToString Method -- */
    @NonNull
    @Override
    public String toString(){
        return name;
    }
}
