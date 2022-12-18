package ua.kharin.liskov.bad;

public class VehicleService {
    public void move(Vehicle vehicle) {
        //move straight
        vehicle.accelerate();
        vehicle.accelerate();
        //turn
        vehicle.slowDown();
        vehicle.turn(90);
        vehicle.accelerate();
        //move straight
        vehicle.accelerate();
        //stop
        vehicle.slowDown();
        vehicle.slowDown();
        vehicle.slowDown();
    }
}
