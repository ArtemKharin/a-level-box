package ua.kharin.jadv.arrays.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] unsorted = {3, 5, 6, 7, 2, -5, 0, 222, -33, 1, 0, 2, 6, 33, 77, 2, 77};
        System.out.println(Arrays.toString(unsorted));
        int[] sorted = arrayCopy(unsorted);
        sort(sorted);
        System.out.println(Arrays.toString(sorted));
    }

    public static void sort(int[] array) {
        boolean isChanged;
        int changeAmount = 0;
        do {
            isChanged = false;
            for (int i = 0; i < array.length - 1 - changeAmount; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isChanged = true;
                }
            }
            changeAmount++;
        } while (isChanged);
    }

    public static int[] arrayCopy(int[] initialArray) {
        return Arrays.copyOf(initialArray, initialArray.length);
    }
}
