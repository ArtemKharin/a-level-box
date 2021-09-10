package ua.kharin.jadv.practice3;

//Требуется написать программу, вычисляющую значение какой-либо функции у = f(x).
public class Task1 {
    //у = x – 2, если x > 0,
    //y = 0, если x = 0,
    //y = |x|, если x < 0.
    public static void main(String[] args) {
        double testValuePos = 5;
        double testValueZero = 0;
        double testValueNeg = -3;
        System.out.println("x = " + testValueNeg + " y = " + calcTernary(testValueNeg));
        System.out.println("x = " + testValueZero + " y = " + calc(testValueZero));
        System.out.println("x = " + testValuePos + " y = " + calc(testValuePos));
    }

    private static double calcTernary(double x) {
        return x <= 0 ? Math.abs(x) : x - 2;
    }

    private static double calc(double x) {
        if (x <= 0) {
            return Math.abs(x);
        } else {
            return x - 2;
        }
    }
}
