package model.Reservation;

import model.car.Car;
import model.car.Time;
import model.user.Administer;
import model.user.Customer;

import java.util.TreeSet;

public class CarReservation {
    private Car car;
    private Time time;
    private Customer customer;
    private Administer administer;
    private String des;

    public CarReservation(Car car, Customer customer, Administer administer, Time time,TreeSet<Car> reservations,String des) throws Exception{
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
        this.des=des;
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

    public String getDes(){return this.des;}

}