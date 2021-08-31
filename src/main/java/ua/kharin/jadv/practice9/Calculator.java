package ua.kharin.jadv.practice9;

public class Calculator {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public int getAndIncrement() {
        return counter++;
    }

    public int sum(int x, int y) {
        return x + y;
    }

    public double divWithoutFraction(int x, int y) {
        return x / y;
    }

}
