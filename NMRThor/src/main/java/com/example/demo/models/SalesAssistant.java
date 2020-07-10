package com.example.demo.models;

public class SalesAssistant extends User {
    private UserType userType;


    public SalesAssistant(String ID, String name, String password) {

        super(ID, name, password);
        this.userType = UserType.SALESASSISTANT;

    }
}
