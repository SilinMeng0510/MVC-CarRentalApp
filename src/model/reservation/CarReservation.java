package model.reservation;

import model.car.Car;
import model.user.Administer;
import model.user.Customer;

import java.util.Objects;

/**
 * Each reservation has a car, a customer, an admin ad an int. This class implements comparable.
 */
public class CarReservation implements Comparable<CarReservation>{
    private Car car;
    private Customer customer;
    private Administer administer;
    private int key;

    /**
     * Constructor to create a reservation.
     * @param car
     * @param customer
     * @param administer
     */
    public CarReservation(Car car, Customer customer, Administer administer) {
        this.car = car;
        this.customer = customer;
        this.administer = administer;
        key = Objects.hash(car.hashCode(), customer.getName(), customer.getPhone());
    }

    /**
     * getter function to access car
     * @return Car
     */
    public Car getCar(){
        return car;
    }

    /**
     * getter function to access customer
     * @return Customer
     */
    public Customer getCustomer(){
        return customer;
    }

    /**
     * getter function to access administer
     * @return Administer
     */
    public Administer getAdminister(){
        return administer;
    }

    /**
     * getter function to access key
     * @return key
     */
    public int getKey(){
        return key;
    }

    /**
     * Compare two reservations by car, if it's equal, then compare them by admin. Lastly, it compares the customer if the other varibales are equal.
     * @param o
     * @return int
     */
    @Override
    public int compareTo(CarReservation o) {
        if (car.compareTo(o.car) != 0){
            return car.compareTo(o.car);
        }
        else if (administer.getID().compareTo(o.administer.getID()) != 0){
            return administer.getID().compareTo(o.administer.getID());
        }
        return customer.getPhone().compareTo(o.customer.getPhone());
    }
}