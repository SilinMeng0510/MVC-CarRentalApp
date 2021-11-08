package Model.UI;

import Model.car.Car;
import Model.process.CarReservation;
import Model.user.Administer;
import Model.user.Customer;
import Model.car.Time;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Applicaion {

    public static void main(String[] args) {
        List<CarReservation> reservations = new LinkedList<>();
        Customer customer = new Customer("tester", "619-000-0000");
        Administer administer = new Administer("admin", "619-111-1111");
        Time time = new Time(LocalDate.parse("2021-07-01"), LocalDate.parse("2021-10-01"));
        Car car = new Car("Tesla", 2021, time);

        CarReservation reservation = new CarReservation(car, customer, administer, time);
        System.out.println(reservation.getCustomer().getName());

    }
}
