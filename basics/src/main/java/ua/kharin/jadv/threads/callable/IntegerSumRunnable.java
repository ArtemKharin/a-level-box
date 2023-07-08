package ua.kharin.jadv.threads.callable;

import lombok.AllArgsConstructor;

import java.util.List;

class IntegerSumRunnable implements Runnable {
    private List<Integer> numbers;
    private long sum;

    public IntegerSumRunnable(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        numbers.forEach(it -> sum += it);
    }

    public long getResult() {
        return sum;
    }
}
