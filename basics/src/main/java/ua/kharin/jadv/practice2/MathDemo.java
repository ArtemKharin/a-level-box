package ua.kharin.jadv.practice2;

public class MathDemo {
    public static void main(String[] args) {
        int x = 5;
        int y = 7;
        System.out.println(x + y);
        System.out.println(x - y);
        System.out.println(x * y);
        System.out.println(x / (double) y);

        System.out.println("sqrt of 5 = " + Math.sqrt(5));
        double sqrt = Math.sqrt(7);
        System.out.println("sqrt of 7 = " + sqrt);

        long sqrtRounded = Math.round(sqrt);
        System.out.println("sqrt rounded = " + sqrtRounded);

        System.out.println("cos(3) = " + Math.cos(3));
    }
}
