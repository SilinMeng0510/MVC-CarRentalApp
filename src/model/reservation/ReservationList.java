package model.reservation;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * A ReservationList contains a TreeMap of cars.
 */
public class ReservationList {
    TreeMap<Integer, CarReservation> cars;

    /**
     * initiate the cars
     */
    public ReservationList(){
        cars = new TreeMap<>();
    }

    /**
     * add car reservation to list.
     * @param reservation
     */
    public void add(CarReservation reservation) {
        cars.put(reservation.getKey(), reservation);
    }

    /**
     * delete reservation from car reservation
     * @param reservation
     */
    public void delete(CarReservation reservation){
        cars.remove(reservation.getKey());
    }

    /**
     * getter function to access all reservations
     * @return
     */
    public TreeSet<CarReservation> getSet(){
        TreeSet<CarReservation> set = new TreeSet<>();
        for (Integer i : cars.keySet()){
            set.add(cars.get(i));
        }
        return set;
    }

}
