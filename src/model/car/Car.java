package model.car;

import java.util.Objects;
import java.util.TreeSet;

public class Car implements Comparable<Car>, Item{
    private String model;
    private String company;
    private String year;
    private double price;
    private TreeSet<Time> schedule;

    public Car(String model, String company, String year, double price) {
            if(schedule==null){
                schedule=new TreeSet<>();
            }
            this.model = model.toUpperCase();
            this.price = price;
            this.company = company.toUpperCase();
            this.year = year;
    }

    public double getPrice(){
        return price;
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
        if(schedule!=null){
            for(Time t:schedule){
                if(time.getToDate().isAfter(t.getFromDate())&&time.getFromDate().isBefore(t.getToDate())){
                    System.out.print("time is invalid");
                    return false;
                }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return this.compareTo(car) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, company, year, price);
    }
}
