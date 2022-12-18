package ua.kharin.isegregation.bad;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Cube implements Shape {
    private double sideLength;

    public double getArea() {
        return 6 * sideLength;
    }

    public double getVolume() {
        return Math.pow(sideLength, 3);
    }
}
