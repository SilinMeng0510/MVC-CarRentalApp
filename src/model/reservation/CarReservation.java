package model.reservation;

import model.car.Car;
import model.user.Administer;
import model.user.Customer;

import java.util.Objects;

public class CarReservation implements Comparable<CarReservation>{
    private Car car;
    private Customer customer;
    private Administer administer;
    private int key;

    public CarReservation(Car car, Customer customer, Administer administer) throws Exception{
        this.car = car;
        this.customer = customer;
        this.administer = administer;
        key = Objects.hash(car.hashCode(), customer.getName(), customer.getPhone());
    }

    public Car getCar(){
        return car;
    }

    public Customer getCustomer(){
        return customer;
    }

    public Administer getAdminister(){
        return administer;
    }

    public int getKey(){
        return key;
    }

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