package model.car;

import java.util.Objects;
import java.util.TreeSet;

public class Car implements Comparable<Car>, Item{
    private String model;
    private String company;
    private String year;
    private double price;

    public Car(String model, String company, String year, double price) {
            this.model = model.toUpperCase();
            this.price = price;
            this.company = company.toUpperCase();
            this.year = year;
    }

    public double getPrice(){
        return price;
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
