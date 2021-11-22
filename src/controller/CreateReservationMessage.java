package controller;

import model.car.Car;
import model.reservation.CarReservation;

public class CreateReservationMessage implements Message{
    CarReservation reservation;

    public CreateReservationMessage(CarReservation reservation){
        this.reservation = reservation;
    }

    public CarReservation getReservation(){
        return reservation;
    }
}
