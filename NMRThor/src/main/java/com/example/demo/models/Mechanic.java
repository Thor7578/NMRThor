package com.example.demo.models;

public class Mechanic extends MaintenanceCrew {
    private UserType userType;

    public Mechanic(String ID, String name, String password) {
        super(ID, name, password);
        userType = UserType.MECHANIC;


    }

    public void repairDone() {
        getMaintenanceToDoList().markFirstElementRepaired();

    }

    public Motorhome inspectFirstRepair() {
        return getMaintenanceToDoList().inspectFirstMechElementOnList();
    }

}
