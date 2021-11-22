package model.reservation;

import java.util.TreeMap;
import java.util.TreeSet;

public class ReservationList {
    TreeMap<Integer, CarReservation> cars;

    public ReservationList(){
        cars = new TreeMap<>();
    }

    public void add(CarReservation reservation){
        cars.put(reservation.getKey(), reservation);
    }

    public void delete(CarReservation reservation){
        cars.remove(reservation.getKey());
    }

    public TreeSet<CarReservation> getSet(){
        TreeSet<CarReservation> set = new TreeSet<>();
        for (Integer i : cars.keySet()){
            set.add(cars.get(i));
        }
        return set;
    }

}
