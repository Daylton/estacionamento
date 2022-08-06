package com.daylton.estacionamento.controller.dto;

public class ParkingCreateDTO {

    private String licensce;
    private String state;
    private String model;
    private String color;

    public String getLicensce() {
        return licensce;
    }

    public void setLicensce(String licensce) {
        this.licensce = licensce;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
