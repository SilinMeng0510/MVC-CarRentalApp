package Model.process;

import Model.car.Time;
import Model.user.Administer;
import Model.car.Car;
import Model.user.Customer;

import java.util.ArrayList;
import java.util.TreeSet;

public class CarReservation {
    private Car car;
    private Time time;
    private Customer customer;
    private Administer administer;

    public CarReservation(Car car, Customer customer, Administer administer, Time time,TreeSet<Car> reservations) throws Exception{
        for (Car c : reservations){
            if (c.compareTo(car) == 0){
                car = c;
                break;
            }
        }
        this.car = car;
        if (!car.checkTime(time)){
            throw new Exception("Invalid Date");
        }
        car.addTime(time);
        reservations.add(car);
        this.customer = customer;
        this.administer = administer;
        this.time = time;
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

    public String getReservationDate() {
        return time.toString();
    }

}