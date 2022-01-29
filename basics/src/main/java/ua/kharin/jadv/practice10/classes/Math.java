package ua.kharin.jadv.practice10.classes;

public class Math {

    public static Factorial getFactorial(int x) {

        int result = 1;
        for (int i = 1; i <= x; i++) {

            result *= i;
        }
        return new Factorial(result, x);
    }

    public static class Factorial {

        private int result;
        private int key;

        public Factorial(int number, int x) {

            result = number;
            key = x;
        }

        public int getResult() {
            return result;
        }

        public int getKey() {
            return key;
        }
    }

    public static void main(String[] args) {
        Math.Factorial fact = Math.getFactorial(6);
        System.out.printf("Факториал числа %d равен %d \n", fact.getKey(), fact.getResult());
    }
}