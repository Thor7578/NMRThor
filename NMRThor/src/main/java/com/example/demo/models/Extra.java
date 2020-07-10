package com.example.demo.models;

public class Extra {
    private int extraID;
    private String extraName;
    private double extraPrice;

    public Extra(String extraName, double extraPrice, int extraID){
        this.extraName = extraName;
        this.extraPrice = extraPrice;
        this.extraID = extraID;
    }

    public Extra(){}

    public String getExtraName() {
        return extraName;
    }

    public void setExtraName(String extraName) {
        this.extraName = extraName;
    }

    public double getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(double extraPrice) {
        this.extraPrice = extraPrice;
    }

    public int getExtraID() {
        return extraID;
    }

    public void setExtraID(int extraID) {
        this.extraID = extraID;
    }
}
