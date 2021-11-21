package Model.UI;

import Model.car.Car;
import Model.process.CarReservation;
import Model.user.Administer;
import Model.user.Customer;
import Model.car.Time;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Applicaion {

    public static void main(String[] args) throws Exception {
        List<CarReservation> reservations = new LinkedList<>();
        TreeSet<Car> Car_booked=new TreeSet<>();

        Customer customer = new Customer("tester", "619-000-0000");
        Administer administer = new Administer("admin", "619-111-1111");
        Time time = new Time(LocalDate.parse("2021-07-01"), LocalDate.parse("2021-10-01"));
        Car car = new Car("Tesla", "Y", "2021", 64);


        CarReservation reservation = new CarReservation(car, customer, administer, time,Car_booked);
        System.out.println(reservation.getCustomer().getName());

    }
}
