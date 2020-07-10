package com.example.demo.models;

public class Location {
    private int locationID;
    private String cityName;
    private String streetName;
    private String streetNo;
    private int ZIPCode;

    public Location (String cityName, String streetName, String streetNo, int ZIPCode, int locationID){
        this.cityName = cityName;
        this.streetName = streetName;
        this.streetNo = streetNo;
        this.ZIPCode = ZIPCode;
        this.locationID = locationID;
    }

    public Location(){};

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public int getZIPCode() {
        return ZIPCode;
    }

    public void setZIPCode(int ZIPCode) {
        this.ZIPCode = ZIPCode;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    @Override
    public String toString() {
        return cityName+ ", " + streetName + ", " + streetNo;
    }
}
