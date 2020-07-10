package com.example.demo.models;

public class Season {
    private int seasonID;
    private String seasonName;
    private double seasonDiscount;
    private Date seasonStartDate;
    private Date seasonEndDate;

    public Season(){}

    public Season(int seasonID, String seasonName, double seasonDiscount, Date seasonStartDate, Date seasonEndDate){
        this.seasonID=seasonID;
        this.seasonName=seasonName;
        this.seasonDiscount=seasonDiscount;
        this.seasonStartDate=seasonStartDate;
        this.seasonEndDate=seasonEndDate;
    }


    public void setSeasonID(int seasonID) {
        this.seasonID = seasonID;
    }

    public int getSeasonID() {
        return seasonID;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonDiscount(double seasonDiscount) {
        this.seasonDiscount = seasonDiscount;
    }

    public void setSeasonStartDate(Date seasonStartDate) {
        this.seasonStartDate = seasonStartDate;
    }

    public void setSeasonEndDate(Date seasonEndDate) {
        this.seasonEndDate = seasonEndDate;
    }

    public double getSeasonDiscount() {
        return seasonDiscount;
    }

    public Date getSeasonStartDate() {
        return seasonStartDate;
    }

    public Date getSeasonEndDate() {
        return seasonEndDate;
    }

    @Override
    public String toString() {
        return seasonName;
    }
}
