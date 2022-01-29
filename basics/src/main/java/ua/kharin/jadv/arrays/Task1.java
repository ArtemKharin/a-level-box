package ua.kharin.jadv.arrays;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    /*    минимальное значение
        максимальное значение
        среднее значение
        значение элемента из середины массива*/
    public static void main(String[] args) throws Exception {
        int[] numbers = new int[10];
        fillArray(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("min element index " + findMinIndex(numbers));
        System.out.println("max element index " + findMaxIndex(numbers));
        System.out.println("avg element index " + findAvgIndex(numbers));
        System.out.println("central element " + findCentralElement(numbers));
    }
    //[1, 2, 3 ,6]
    public static int findMinIndex(int[] numbers) {
        Integer min = null;
        int minIndex = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (min == null || min > numbers[i]) {
                min = numbers[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int findMaxIndex(int[] numbers) {
        Integer max = null;
        int maxIndex = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (max == null || max < numbers[i]) {
                max = numbers[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int findAvgIndex(int[] numbers) throws Exception {
        int[] sorted = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sorted);
        int avgElement = findCentralElement(sorted);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == avgElement) {
                return i;
            }
        }
        return -1;
    }

    public static int findCentralElement(int[] numbers) throws Exception {
        if (numbers.length == 0) {
            throw new Exception("Array must have length > 0");
        }
        return numbers[(numbers.length / 2) - 1];
    }

    public static void fillArray(int[] numbers) {
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000);
        }
    }


}
