package controller;

import model.reservation.CarReservation;

/**
 * DeleteReservationMessage implements the Message. It has two functions, one is getCarReservation and the other is DeleteRservationMessage.
 */
public class DeleteReservationMessage implements Message{
    CarReservation reservation;

    /**
     * @param reservation
     */
    public DeleteReservationMessage(CarReservation reservation){
        this.reservation = reservation;
    }

    /**
     *
     * @return reservation
     */
    public CarReservation getReservation(){
        return reservation;
    }
}
