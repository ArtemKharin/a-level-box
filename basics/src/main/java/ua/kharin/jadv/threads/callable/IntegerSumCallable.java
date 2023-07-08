package ua.kharin.jadv.threads.callable;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.Callable;

@AllArgsConstructor
public class IntegerSumCallable implements Callable<Long> {
    private List<Integer> numbers;

    @Override
    public Long call() {
        long sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
