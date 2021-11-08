package Model.process;

import Model.car.Time;
import Model.user.Administer;
import Model.car.Car;
import Model.user.Customer;

import java.util.ArrayList;

public class CarReservation {
    private Car car;
    private Time time;
    private Customer customer;
    private Administer administer;

    public CarReservation(Car car, Customer customer, Administer administer, Time time) {
        this.car=car;
        this.customer=customer;
        this.administer=administer;
        this.time=time;
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

    public String getReservationData() {
        return time.toString();
    }

}