package ua.kharin.isegregation.good;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Square implements Shape {
    private double sideLength;

    public double getArea() {
        return 4 * sideLength;
    }
}
