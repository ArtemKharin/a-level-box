package ua.kharin.jadv.practice3;

//Написать метод, который возводит число в степень.
//P.S. Не использовать класс Math.
public class Task5 {
    public static void main(String[] args) {
        System.out.println(power(2, 0));
        System.out.println(power(2, 1));
        System.out.println(power(2, 3));
    }

    public static int power(int number, int power) {
        int result = 1;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }
        return result;
    }
}
