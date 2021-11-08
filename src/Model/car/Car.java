package Model.car;

import java.util.ArrayList;
import java.util.Date;

public class Car {
    private String model;
    private int year;
    private ArrayList<Time> schedule;

    public Car(String model, int year, Time time) {

    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<Time> getSchedule(){
        return schedule;
    }

    public boolean checkTime(){
        return false;
    }
}

class Time {
    private Date fromDate;
    private Date toDate;

    public Time(Date fromDate, Date toDate) {

    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public String ToString() {
        return null;
    }
}