package com.example.androidproject.model;

public class AvailableMechanics {

    private String location;
    private String service;
    private String img_path;
    private String name;
    private String mobile;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public AvailableMechanics(String name, String location, String img_path, String mobile, String service ){
        this.img_path=img_path;
        this.location=location;
        this.name=name;
        this.mobile=mobile;
        this.service=service;
    }


}
