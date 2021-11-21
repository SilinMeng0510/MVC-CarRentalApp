package Model.car;

public class Deal implements Item{
    Car car;
    double percentage;

    public Deal(Car car, double percentage) throws Exception{
        this.car = car;
        if (percentage > 1){
            throw new Exception("percentage must be smaller than 1");
        }
        this.percentage = percentage;
    }

    @Override
    public double getPrice() {
        return car.getPrice() * (percentage);
    }
}
