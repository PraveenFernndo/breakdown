package com.example.androidproject.model;

public class Emergancy {

    private String emergancyTypeName;
    private String availableMechanics;

    public Emergancy(String emergancyTypeName){
        this.emergancyTypeName=emergancyTypeName;
    }

    public String getEmergancyTypeName() {
        return emergancyTypeName;
    }

    public void setEmergancyTypeName(String emergancyTypeName) {
        this.emergancyTypeName = emergancyTypeName;
    }

    public String getAvailableMechanics() {
        return availableMechanics;
    }

    public void setAvailableMechanics(String availableMechanics) {
        this.availableMechanics = availableMechanics;
    }
}
