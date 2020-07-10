package com.example.demo.models;

public class Invoice {
    private Order order;
    private double total;
    private boolean paid;
    private Date payDate;
    private Date dueDate;


    public Invoice(Order order){
        this.order = order;
        this.total = order.getTotalPrice();
        this.dueDate = null;
        this.paid = false;
        this.payDate = null;
    }


    public void sendInvoice(Date dueDate){
        this.dueDate = dueDate;
    }

    //Registers an invoice as paid and the paymentdate.
    public void invoicePaid(int day, int month, int year){
        this.paid = true;
        this.payDate = new Date(day, month, year);
    }
}
