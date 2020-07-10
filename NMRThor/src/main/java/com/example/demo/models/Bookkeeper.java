package com.example.demo.models;

public class Bookkeeper extends User {
    private UserType userType;

    public Bookkeeper(String ID, String name, String password) {

        super(ID, name, password);
        this.userType = UserType.BOOKKEEPER;
    }
}
