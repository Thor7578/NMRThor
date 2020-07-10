package com.example.demo.models;

public class Chef extends User {
    private UserType userType;

    public Chef(String ID, String name, String password) {
        super(ID, name, password);
        userType = UserType.CHEF;
    }

}
