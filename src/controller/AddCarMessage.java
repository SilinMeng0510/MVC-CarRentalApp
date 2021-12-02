package controller;

import model.car.Car;


/**
 * AddCarMessage implements Message.
 */
public class AddCarMessage implements Message{
    Car car;

    /**
     * addCar
     * @param car
     */
    public AddCarMessage(Car car){
        this.car = car;
    }

    /**
     *
     * @return car
     */
    public Car getCar(){
        return car;
    }
}
