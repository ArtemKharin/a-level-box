package ua.kharin.jadv.streams;

import java.util.List;

public class EvenCounter {
    public static int countWithLoop(List<Integer> numbers) {
        int count = 0;
        for (int number : numbers) {
            if (isEven(number)) {
                count++;
            }
        }
        return count;
    }

    public static int countWithStreams(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(EvenCounter::isEven)
                .count();
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
