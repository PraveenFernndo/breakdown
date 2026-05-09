package com.example.androidproject.controller;

public class Mechanic {

    private String service;
    private String line01;
    private String line02;
    private String city;
    private String userId;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getLine01() {
        return line01;
    }

    public void setLine01(String line01) {
        this.line01 = line01;
    }

    public String getLine02() {
        return line02;
    }

    public void setLine02(String line02) {
        this.line02 = line02;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Mechanic(String service, String line01, String line02, String city,String userId){
        this.city=city;
        this.line01=line01;
        this.line02=line02;
        this.service=service;
        this.userId=userId;

    }

}
