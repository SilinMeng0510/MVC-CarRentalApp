package model.car;

import java.util.TreeSet;

public class CarStorage {
    TreeSet<Car> cars;

    public CarStorage(){
        cars = new TreeSet<>();
    }

    public void add(Car car){
        cars.add(car);
    }

    public TreeSet<Car> getCars(){
        return (TreeSet<Car>) cars.clone();
    }
}
