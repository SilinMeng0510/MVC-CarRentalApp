package Model.car;

import java.util.ArrayList;
import java.util.Date;

public class Car {
    private String model;
    private int year;
    private ArrayList<Time> schedule;

    public Car(String model, int year, Time time) {
            this.model=model;
            this.year=year;
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
