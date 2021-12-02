package model.car;

import java.util.TreeSet;

/**
 * Declare CarStorage, which contains a Treeset of cars.
 */
public class CarStorage {
    TreeSet<Car> cars;

    /**
     * initial the TreeSet
     */
    public CarStorage(){
        cars = new TreeSet<>();
    }

    /**
     * add a car to the storage
     * @param car
     */
    public void add(Car car){
        cars.add(car);
    }

    /**
     * delete a car from the storage
     * @param car
     */
    public void delete(Car car){
        for (Car c : cars){
            if (c.hashCode() == car.hashCode()){
                cars.remove(c);
            }
        }
    }

    /***
     * getter function to access cars.
     * @return TreeSet<Car>
     */
    public TreeSet<Car> getCars(){
        return (TreeSet<Car>) cars.clone();
    }

}
