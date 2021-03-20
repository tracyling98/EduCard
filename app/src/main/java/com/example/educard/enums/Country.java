package com.example.educard.enums;

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

    public String getCountry(){
        return country;
    }

}
