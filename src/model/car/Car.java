package model.car;

import java.util.Objects;

/**
 * Declare the class Car. Car has model, company, year and price. It also implements the comparable to comapre two cars.
 */
public class Car implements Comparable<Car>{
    private String model;
    private String company;
    private String year;
    private double price;

    /**
     * constructor.
     * @param model
     * @param company
     * @param year
     * @param price
     */
    public Car(String model, String company, String year, double price) {
            this.model = model.toUpperCase();
            this.price = price;
            this.company = company.toUpperCase();
            this.year = year;
    }

    /**
     * getter function for price
     * @return price
     */
    public double getPrice(){
        return price;
    }

    /**
     * getter function for Model
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * getter function for company.
     * @return company
     */
    public String getCompany(){
        return company;
    }

    /**
     * getter function for year
     * @return year
     */
    public String getYear() {
        return year;
    }


    /**
     * Compare two cars. First compare two cars by model. If it's equal, then compare the companies. If they are from same companies, then compare teh year.C
     * @param o
     * @return int
     */
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

    /**
     * Check if cars are equal.
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return this.compareTo(car) == 0;
    }


    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(model, company, year, price);
    }
}
