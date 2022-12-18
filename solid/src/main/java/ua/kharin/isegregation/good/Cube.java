package ua.kharin.isegregation.good;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Cube implements SolidShape {
    private double sideLength;

    public double getArea() {
        return 6 * sideLength;
    }

    public double getVolume() {
        return Math.pow(sideLength, 3);
    }
}
