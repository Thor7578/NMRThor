package com.example.demo.models;

import java.util.LinkedList;

public class MaintenanceToDoList {
    private static MaintenanceToDoList toDoInstance = null;

    private LinkedList<Motorhome>mechanicToDoList;
    private LinkedList<Motorhome>cleaningToDoList;


    private MaintenanceToDoList() {
        this.mechanicToDoList = new LinkedList<Motorhome>();
        this.cleaningToDoList = new LinkedList<Motorhome>();

    }

    public static MaintenanceToDoList getInstance(){
        if (toDoInstance == null){
            toDoInstance = new MaintenanceToDoList();
        }
        return toDoInstance;
    }

    public void addMotorhomeToLists(Motorhome motorhome){
        mechanicToDoList.add(motorhome);
        cleaningToDoList.add(motorhome);

    }

    public void addMotorhomeToMechList(Motorhome motorhome){
        mechanicToDoList.add(motorhome);

    }

    public void addMotorhomeToCleanList(Motorhome motorhome){
        cleaningToDoList.add(motorhome);

    }

    public Motorhome inspectFirstMechElementOnList(){

        return mechanicToDoList.getFirst();

    }

    public Motorhome inspectFirstCleanElementOnList(){

        return cleaningToDoList.getFirst();
    }

    public void markFirstElementRepaired() {
        Motorhome motorhome = mechanicToDoList.pop();
        motorhome.setRepaired(true);

    }

    public void markFirstElementCleaned() {
        Motorhome motorhome = cleaningToDoList.pop();
        motorhome.setCleaned(true);

    }
}
