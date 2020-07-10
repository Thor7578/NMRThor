package com.example.demo.models;

public class MaintenanceCrew extends User {


    private MaintenanceToDoList maintenanceToDoList;

    public MaintenanceCrew(String ID, String name, String password) {
        super(ID, name, password);

        maintenanceToDoList = MaintenanceToDoList.getInstance();
    }


    public MaintenanceToDoList getMaintenanceToDoList() {
        return maintenanceToDoList;
    }
}
