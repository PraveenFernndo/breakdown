package com.example.androidproject.model;

public class PreviousWork {

    private String vehicalName;
    private String income;
    private String date;
    private String fault;
    public PreviousWork(String vehicalName,String income,String date,String fault){

        this.fault=fault;
        this.date=date;
        this.income=income;
        this.vehicalName=vehicalName;

    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getVehicalName() {
        return vehicalName;
    }

    public void setVehicalName(String vehicalName) {
        this.vehicalName = vehicalName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFault() {
        return fault;
    }

    public void setFault(String fault) {
        this.fault = fault;
    }
}
