package controller;

import model.car.Car;

public class AddCarMessage implements Message{
    Car car;

    public AddCarMessage(Car car){
        this.car = car;
    }

    public Car getCar(){
        return car;
    }
}
