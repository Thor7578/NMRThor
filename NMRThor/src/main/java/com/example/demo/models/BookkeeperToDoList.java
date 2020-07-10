package com.example.demo.models;

import java.util.LinkedList;

public class BookkeeperToDoList {
    private static BookkeeperToDoList bookKeeperToDoList = null;

    private LinkedList<Invoice> invoicesToSend;
    private LinkedList<Invoice> remindersToSend;

    private BookkeeperToDoList(){

    }

    public static BookkeeperToDoList getInstance(){
        if(bookKeeperToDoList==null){
            bookKeeperToDoList = new BookkeeperToDoList();
        }
        return bookKeeperToDoList;
    }

    public void addToInvoicesToSend(Invoice invoice){
        invoicesToSend.add(invoice);
    }

    public void addRemindersToSend(Invoice invoice){
        remindersToSend.add(invoice);
    }

    public void sendFirstElementInvoices(Date dueDate){
        Invoice inv = invoicesToSend.pop();
        inv.sendInvoice(dueDate);
    }

    public void rmvFirstElementReminders(){
        remindersToSend.remove();
    }


}
