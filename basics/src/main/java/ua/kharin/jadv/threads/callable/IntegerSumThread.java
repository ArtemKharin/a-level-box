package ua.kharin.jadv.threads.callable;

import java.util.List;

class IntegerSumThread extends Thread {
    private List<Integer> numbers;
    private long sum;

    public IntegerSumThread(List<Integer> numbers) {
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
