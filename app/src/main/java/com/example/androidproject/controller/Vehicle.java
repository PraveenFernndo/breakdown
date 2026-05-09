package com.example.androidproject.controller;

public class Vehicle {

    private String img_path;
    private String manufactured_year;
    private String model;
    private String name;
    private String type;
    private String user_id;
    private String vehicle_number;

    public Vehicle(String name,String number, String type,String model,String img_path, String year,String user_id){
        this.img_path=img_path;
        this.name=name;
        this.model=model;
        this.type=type;
        this.user_id=user_id;
        this.manufactured_year=year;
        this.vehicle_number=number;
    }


    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getManufactured_year() {
        return manufactured_year;
    }

    public void setManufactured_year(String manufactured_year) {
        this.manufactured_year = manufactured_year;
    }

    public String getModel_id() {
        return model;
    }

    public void setModel_id(String model_id) {
        this.model = model_id;
    }

    public String getType_id() {
        return type;
    }

    public void setType_id(String type_id) {
        this.type = type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }
}
