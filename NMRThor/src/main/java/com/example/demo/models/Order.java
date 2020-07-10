package com.example.demo.models;

import java.util.ArrayList;

public class Order {
    private int orderID;
    private Customer customer;
    private Season season;
    private ArrayList<Motorhome> motorhomesInOrder;
    private ArrayList<Extra> extrasList;
    private Location dropOffLocation;
    private double dropOffPrice;
    private double totalPrice;
    private Date startDate;
    private Date endDate;
    private int totalDays;
    private boolean ended;


    public Order(Season season, Customer customer, Date startDate, Date endDate, int orderID, ArrayList<Extra> extrasList, boolean ended) {
        this.season = season;
        this.customer=customer;
        this.motorhomesInOrder = new ArrayList<Motorhome>();
        this.extrasList = extrasList;
        this.dropOffPrice = 0.0;
        this.totalPrice = 0.0;
        this.dropOffLocation = null;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalDays = startDate.dateDayDiff(endDate);
        this.orderID = orderID;
        this.ended = ended;
    }

    public Order(){}

    public void addMotorhomeToOrder (Motorhome motorhome) {

        motorhomesInOrder.add(motorhome);

    }

    //Drop-offs indicate the final step of an order. When this is finalized an invoice is made and queued at the bookkeeper.
    //The dropoff price needs to be calculated externally, e. g. through Google maps or the like.
    /*
    public void externalDropOffLocation(String cityName, String streetName, String streetNo, int ZIPCode, double dropOffPrice) {
        this.dropOffLocation = new Location(cityName, streetName, streetNo, ZIPCode, dropOffPrice);
        setDropOffPrice(dropOffPrice);
    }
    */

    public void internalDropOffLocation(){
        dropOffPrice = 0;
        for (Motorhome m : motorhomesInOrder){
            MaintenanceToDoList.getInstance().addMotorhomeToLists(m);
        }
        makeInvoice();
    }

    private void makeInvoice(){
        Invoice invoice = new Invoice(this);

        BookkeeperToDoList BTDL = BookkeeperToDoList.getInstance();
        BTDL.addToInvoicesToSend(invoice);

        setDropOffPrice(0);
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setDropOffPrice(double dropOffPrice) {
        this.dropOffPrice = dropOffPrice;
    }

    public void calcTotal(){
        for(int i=0; i<motorhomesInOrder.size(); i++){
            totalPrice += motorhomesInOrder.get(i).getPricePerDay() * totalDays;
        }
    }


    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID){
        this.orderID=orderID;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Location getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(Location dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public double getDropOffPrice() {
        return dropOffPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setMotorhomesInOrder(ArrayList<Motorhome> mhinorder){
        this.motorhomesInOrder=mhinorder;
    }

    public ArrayList<Extra> getExtrasList() {
        return extrasList;
    }

    public void setExtrasList(ArrayList<Extra> extrasList) {
        this.extrasList = extrasList;
    }

    public ArrayList<Motorhome> getMotorhomesInOrder(){
        return this.motorhomesInOrder;
    }

    public int getTotalDays(){
        return this.totalDays;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }
}
