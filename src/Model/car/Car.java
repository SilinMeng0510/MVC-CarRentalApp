package Model.car;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

public class Car implements Comparable<Car>{
    private String model;
    private String company;
    private String year;
    private TreeSet<Time> schedule;

    public Car(String model, String company, String year) {
            this.model = model.toUpperCase();
            this.company = company.toUpperCase();
            this.year = year;
    }

    public void addTime(Time t){
        schedule.add(t);
    }

    public String getModel() {
        return model;
    }

    public String getCompany(){
        return company;
    }

    public String getYear() {
        return year;
    }

    public TreeSet<Time> getSchedule(){
        return schedule;
    }

    public boolean checkTime(Time time){
        for (Time t : schedule){
            if (t.compareTo(time) == 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(Car o) {
        if (model.compareTo(o.model) != 0){
            return model.compareTo(o.model);
        }
        else if (company.compareTo(o.company) != 0){
            return company.compareTo(o.company);
        }
        return year.compareTo(o.year);
    }
}
