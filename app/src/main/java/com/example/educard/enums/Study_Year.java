package com.example.educard.enums;

/* Only year 1 - 3 for this case */
public enum Study_Year {
    Year1(1),
    Year2(2),
    Year3(3);

    private final int yearName;

    Study_Year(int yearName){
        this.yearName = yearName;
    }

    public int getYearName(){
        return yearName;
    }
}
