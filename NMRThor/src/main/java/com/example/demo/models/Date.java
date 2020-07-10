package com.example.demo.models;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date (int year, int month, int day) throws IllegalArgumentException {
        if(!checkIfValid(day,month,year)){
            throw new IllegalArgumentException();
        }
        this.year = year;
        this.month = month;
        this.day = day;

    }

    public Date(){};

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(checkIfValid(1,month,2000)){
            this.month = month;
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(checkIfValid(day, 1, 2000)){
            this.day = day;
        }
    }

    public boolean checkIfValid(int day, int month, int year){
        int monthdays = 0;
        if((day < 1) || (day > 31)){
            return false;
        }

        if((month < 1) || (month > 12)){
            return false;
        }

        monthdays = daysInMonth(month);

        if(day > monthdays){
            return false;
        }

        return true;
    }

    private boolean leapYearCheck(int year){
        if((year%4)==0){
            if((year%400)==0){
                return true;
            } else if((year%100)==0) {
                return false;
            }
            return true;
        }
        return false;
    }


    public int daysInMonth(int month){
        switch(month){
            case 1:
                return 31;
            case 2:
                if(leapYearCheck(year)){
                    return 29;
                } else {
                    return 28;
                }
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 0;
        }
    }


    //This method compares start date to end date and computes the total amount of days.
    //This is done by firstly deducting years into months and then months into days.
    //It accounts for number of days in a year (changes during leap years) and different number of days during a month
    public int dateDayDiff(Date endDate){
        //24 dec 2020-10 jan 2021
        //15 nov 2020-10 sep 2022

        //2021-2020=1
        //2022-2020=2
        int yearDiff = endDate.year - year;

        //1*12-1=11
        //2*12-9=15
        int monthMente = 0;//yearDiff*12-month;

        //1-12=-11
        //9-11=-2
        int monthDiff = endDate.month - month;

        //yearDiff=2
        if(yearDiff > 1){
            //1*12=12
            monthMente += (yearDiff-1)*12;
        }

        //12-11=1
        monthMente += 12-month;

        //9
        monthMente += endDate.month;

        int numberOfDays = 0;
        //-5
        int dayDiffs = endDate.day-day;


        if(dayDiffs < 0){
            //newMonthMente=21
            monthMente--;
            //dayDiffs = 25
            dayDiffs += daysInMonth(month);
            //=25
            numberOfDays += dayDiffs;
        }

        //monthMente=21
        for(int i=0; i>monthMente; i++){
            int monthModulo = (month+i)%12;
            if(monthModulo==0){
                monthModulo = 12;
            }
            numberOfDays += daysInMonth(monthModulo);
        }

        return numberOfDays;
    }


    @Override
    public String toString() {
        return ""+day+"/"+month+"/"+year;
    }
}


