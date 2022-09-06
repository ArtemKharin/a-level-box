package ua.kharin.jadv.practice2;

public class BitCalculator {
    public static void main(String[] args) {
        shiftToRight();
        //shiftToRightAlt();
        //shiftToLeft();
        //shiftToLeftAlt();
    }

    private static void shiftToRight() {
        int number = 64;
        //1000000
        System.out.println(number);
        //0100000
        System.out.println(number >> 1);
        //0010000
        System.out.println(number >> 2);
        //0001000
        System.out.println(number >> 3);
    }

    private static void shiftToRightAlt() {
        //1000011
        int number = 67;
        System.out.println(number);
        //0100001
        System.out.println(number >> 1);
        //0010000
        System.out.println(number >> 2);
        //0001000
        System.out.println(number >> 3);
    }

    private static void shiftToLeft() {
        //1000
        int number = 8;
        System.out.println(number);
        //10000
        System.out.println(number << 1);
        //100000
        System.out.println(number << 2);
        //1000000
        System.out.println(number << 3);
    }

    private static void shiftToLeftAlt() {
        //1011
        int number = 11;
        System.out.println(number);
        //10110
        System.out.println(number << 1);
        //101100
        System.out.println(number << 2);
        //1011000
        System.out.println(number << 3);
    }
}
