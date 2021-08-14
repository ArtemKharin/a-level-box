package ua.kharin.nix5.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class PrimeNumbersCalculator implements Callable<Long> {
    private final List<Integer> numbers;

    public PrimeNumbersCalculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Long call() {
        return numbers.stream().filter(this::isPrime).count();
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) { // number is perfectly divisible - no prime
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }
        System.out.println("init data " + numbers);

        Callable<Long> firstThread = new PrimeNumbersCalculator(numbers.subList(0, numbers.size() / 2));
        FutureTask<Long> firstHalfTask = new FutureTask<>(firstThread);
        Callable<Long> secondThread = new PrimeNumbersCalculator(numbers.subList(numbers.size() / 2, numbers.size()));
        FutureTask<Long> secondHalfTask = new FutureTask<>(secondThread);

        new Thread(firstHalfTask).start();
        new Thread(secondHalfTask).start();

        System.out.println("Total prime numbers amount " + (firstHalfTask.get() + secondHalfTask.get()));

    }
}
