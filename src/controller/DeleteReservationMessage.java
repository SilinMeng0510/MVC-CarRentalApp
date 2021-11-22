package controller;

import model.reservation.CarReservation;

public class DeleteReservationMessage implements Message{
    CarReservation reservation;

    public DeleteReservationMessage(CarReservation reservation){
        this.reservation = reservation;
    }

    public CarReservation getReservation(){
        return reservation;
    }
}
