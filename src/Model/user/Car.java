package Model.user;

import java.util.ArrayList;

public class Car {
    private String model;
    private int year;
    private int code;
    private ArrayList<Time> schedule;

    public Car(String model, int year, int code) {

    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getCode() {
        return code;
    }

    public void addTime(Time time) {

    }

    public void cancelTime(Time time) {

    }
}