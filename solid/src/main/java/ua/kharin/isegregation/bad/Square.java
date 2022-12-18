package ua.kharin.isegregation.bad;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Square implements Shape {
    private double sideLength;

    public double getArea() {
        return 4 * sideLength;
    }

    public double getVolume() {
        throw new UnsupportedOperationException("square don't have volume");
    }
}
