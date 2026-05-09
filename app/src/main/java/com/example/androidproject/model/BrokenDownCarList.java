package com.example.androidproject.model;

public class BrokenDownCarList {

    private String name;
    private String fault;
    private String details;

    public BrokenDownCarList(String name,String fault,String details){
        this.name=name;
        this.fault=fault;
        this.details=details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFault() {
        return fault;
    }

    public void setFault(String fault) {
        this.fault = fault;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
