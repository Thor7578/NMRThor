package com.example.demo.models;

public class CleaningStaff extends MaintenanceCrew{
    private UserType userType;

    public CleaningStaff(String ID, String name, String password) {
        super(ID, name, password);
        userType = UserType.CLEANING;
    }

    public void cleaningDone() {
        getMaintenanceToDoList().markFirstElementCleaned();

    }

    public Motorhome inspectFirstElement() {
        return getMaintenanceToDoList().inspectFirstCleanElementOnList();

    }

}
