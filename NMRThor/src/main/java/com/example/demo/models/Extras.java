package com.example.demo.models;

public class Extras {

    private int bikeRack;
    private int bedLinen;
    private int childSeat;
    private int picnicTable;
    private int chair;

    public Extras(int bikeRack, int bedLinen, int childSeat, int picnicTable, int chair){

        this.bikeRack = bikeRack;
        this.bedLinen = bedLinen;
        this.childSeat = childSeat;
        this.picnicTable = picnicTable;
        this.chair = chair;
}

    public void setBikeRack(int  newBikeRack){

        bikeRack = newBikeRack;

    }

    public void setBedLinen(int bedLinen) {
        this.bedLinen = bedLinen;
    }

    public void setChildSeat(int childSeat) {
        this.childSeat = childSeat;
    }

    public void setPicnicTable(int picnicTable) {
        this.picnicTable = picnicTable;
    }

    public void setChair(int chair) {
        this.chair = chair;
    }


}
