package ua.kharin.jadv.practice2;

public class TernaryOperator {
    public static void main(String[] args) {
        int number = 15;
        if (number > 15) {
            System.out.println("number is greater than 15");
        } else {
            System.out.println("number is less or equal to 15");
        }

        System.out.println(number > 15 ? "number is greater than 15" : "number is less or equal to 15");

        String message = number > 15 ? "number is greater than 15" : "number is less or equal to 15";
        System.out.println(message);
    }
}
