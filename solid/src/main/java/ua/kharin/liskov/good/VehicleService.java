package ua.kharin.liskov.good;

public class VehicleService {
    public void moveWithTurn(FreeDirectionalVehicle vehicle) {
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

    public void moveStraight(BiDirectionalVehicle vehicle) {
        //move straight
        vehicle.accelerate();
        vehicle.accelerate();
        //slow down
        vehicle.slowDown();
        //move straight
        vehicle.accelerate();
        vehicle.accelerate();
        //stop
        vehicle.slowDown();
        vehicle.slowDown();
        vehicle.slowDown();
    }
}
