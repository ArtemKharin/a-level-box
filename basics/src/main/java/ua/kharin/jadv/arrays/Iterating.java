package ua.kharin.jadv.arrays;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Iterating {
    public static void main(String[] args) {
        boolean[] array = new boolean[10];
        fillArray(array);
        System.out.println(Arrays.toString(array));
        printArrayWithFor(array);
        System.out.println("==================================================================");
        printArrayWithForEach(array);
        System.out.println("==================================================================");
        printArrayWithWhile(array);
        System.out.println("==================================================================");
        printArrayWithDoWhile(array);
    }

    public static void printArrayWithDoWhile(boolean[] booleans) {
        if (booleans.length == 0) {
            return;
        }
        int i = 0;
        do {
            System.out.println(booleans[i++]);
        } while (i < booleans.length);
    }

    public static void printArrayWithWhile(boolean[] booleans) {
        int i = 0;
        while (i < booleans.length) {
            System.out.println(booleans[i++]);
        }
    }

    public static void printArrayWithFor(boolean[] booleans) {
        for (int i = 0; i < booleans.length; i++) {
            System.out.println(booleans[i]);
        }
    }

    public static void printArrayWithForEach(boolean[] booleans) {
        for (boolean value : booleans) {
            System.out.println(value);
        }
    }

    public static void fillArray(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextBoolean();
        }
    }


}
