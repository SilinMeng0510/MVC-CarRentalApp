package controller;

import model.car.Car;

public class DeleteCarMessage implements Message {
    Car car;

    public DeleteCarMessage(Car car){
        this.car = car;
    }

    public Car getCar(){
        return car;
    }
}
