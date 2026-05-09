package com.example.androidproject.model;

public class User {

    private String name;
    private String mobile;
    private String email;
    private String password;
    private String nic;
    private String img_path;
    private String status;
    private String type;
    private String date;

    public User(){}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User(String name, String mobile, String email, String password, String nic, String imgPath, String date, String status, String type){

        this.name=name;
        this.mobile=mobile;
        this.email=email;
        this.password=password;
        this.nic=nic;
        this.img_path=imgPath;
        this.status=status;
        this.type=type;
        this.date=date;

    }

}
