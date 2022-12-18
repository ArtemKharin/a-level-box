package ua.kharin.liskov.bad;

public class Train extends Vehicle {
    @Override
    public void turn(double angle) {
        throw new UnsupportedOperationException("train can't turn");
    }
}
