package model.Reservation;

import model.car.Car;

import java.util.TreeMap;
import java.util.TreeSet;

public class ResearvationManager {
    TreeMap<String,CarReservation> carReservations = new TreeMap<>();
    TreeSet<Car> cars = new TreeSet<>();

    private void deleteReservation(String des){
        if (carReservations.containsKey(des)){
            carReservations.remove(carReservations.get(des));
        }
    }

    public void addCars(Car car){
        cars.add(car);
    }
    public boolean addReservation(CarReservation reservation)
    {
        if (!carReservations.containsKey(reservation.getDes()))
        {
            carReservations.put(reservation.getDes(),reservation);
            return true;
        }
        return false;
    }
}
