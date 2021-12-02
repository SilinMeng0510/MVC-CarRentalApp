package controller;

import model.reservation.CarReservation;

/**
 * CreateReservationMessage contains CarReservation as variable. It has two functions: one is create reservation message and the other is getReservation
 */
public class CreateReservationMessage implements Message{
    CarReservation reservation;

    /**
     * createReservatonMessage
     * @param reservation
     */
    public CreateReservationMessage(CarReservation reservation){
        this.reservation = reservation;
    }

    /**
     * getter funtion for the reservation.
     * @return CarReservation
     */
    public CarReservation getReservation(){
        return reservation;
    }
}
