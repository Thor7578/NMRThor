package com.example.demo.models;

public class Motorhome {
    private String licensePlate;
    private String model;
    private int ID;
    private int beds;
    private double pricePerDay;
    private boolean cleaned;
    private boolean repaired;
    private boolean active;

    public Motorhome(String licensePlate, String model, int beds, int pricePerDay, int ID, boolean cleaned, boolean repaired, Status status){
        this.licensePlate = licensePlate;
        this.model = model;
        this.beds = beds;
        this.pricePerDay = pricePerDay;
        this.cleaned = cleaned;
        this.repaired = repaired;
        this.active = true;
        this.ID = ID;
    }

    public Motorhome(){

    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getID() {
        return ID;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void setCleaned(boolean cleaned) {
        this.cleaned = cleaned;
    }

    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean getCleaned() {
        return cleaned;
    }

    public boolean getRepaired() {
        return repaired;
    }


    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive() {
        return active;
    }

}