package ua.kharin.jadv.arrays;

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    /*    проверка на дубликаты*/
    public static void main(String[] args) throws Exception {
        int[] numbers = new int[10];
        fillArray(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("All elements unique: " + isAllUnique(numbers));
    }

    public static boolean isAllUnique(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void fillArray(int[] numbers) {
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
        }
    }
}
