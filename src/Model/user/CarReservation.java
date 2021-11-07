package Model.user;

import java.util.ArrayList;

public class CarReservation {
    private Car car;
    private Time time;
    private Customer customer;
    private Administer administer;
    private int reservationID;
    private static int reservationCount;
    private static ArrayList<CarReservation> list;

    public CarReservation(Customer customer, Administer administer, Time time) {

    }

    public boolean checkAvailability(int code) {
        return true;
    }

    public void confirm(Car car) {

    }

    public String getReservationData() {
        return null;
    }

    public void cancel() {

    }
}