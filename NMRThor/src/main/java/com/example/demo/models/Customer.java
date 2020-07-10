package com.example.demo.models;

public class Customer {
    private String CPR;
    private String name;
    private String driverLicensID;
    private String creditCardNo;

    public Customer(){}

    public Customer(String CPR, String name, String getDriverLicensID, String creditCardNo){
        this.CPR=CPR;
        this.name=name;
        this.driverLicensID=getDriverLicensID;
        this.creditCardNo=creditCardNo;
    };

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriverLicensID() {
        return driverLicensID;
    }

    public void setDriverLicensID(String driverLicensID) {
        this.driverLicensID = driverLicensID;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    @Override
    public String toString() {
        return name;
    }
}
