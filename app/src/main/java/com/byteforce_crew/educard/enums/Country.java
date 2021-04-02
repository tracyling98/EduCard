package com.byteforce_crew.educard.enums;

import androidx.annotation.NonNull;

/* Will need to double check and add more Countries */
public enum Country {
    SG("Singapore"),
    MY("Malaysia"),
    AU("Australia"),
    US("United States of America"),
    KR("Korea"),
    CN("China"),
    HK("Hong Kong"),
    TW("Taiwan"),
    TH("Thailand"),
    UK("United Kingdom"),
    IN("India"),
    ID("Indonesia"),
    MM("Myanmar"),
    NZ("New Zealand"),
    PH("Philippines"),
    RU("Russia");

    private final String country;

    Country(String country){
        this.country = country;
    }

    @NonNull
    @Override
    public String toString(){
        return country;
    }

}
