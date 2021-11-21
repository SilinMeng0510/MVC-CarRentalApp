package Model.UI;

import Model.car.Car;
import Model.process.CarReservation;

import java.util.TreeMap;
import java.util.TreeSet;

public class ResearvationManager {
    TreeMap<String,CarReservation> carReservations;
    TreeSet<Car> cars;

    private void deleteReservation(String des){
        if(carReservations.containsKey(des)){
            carReservations.remove(carReservations.get(des));
        }
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
