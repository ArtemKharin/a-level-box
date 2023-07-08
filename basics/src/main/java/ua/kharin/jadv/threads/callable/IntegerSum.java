package ua.kharin.jadv.threads.callable;

import java.util.List;
import java.util.concurrent.*;

public class IntegerSum {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        IntegerSumRunnable runnable = new IntegerSumRunnable(integers);
        Thread sumCounterThread = new Thread(runnable);
        sumCounterThread.start();
        sumCounterThread.join();
        System.out.println("From runnable: " + runnable.getResult());

        sumCounterThread = new IntegerSumThread(integers);
        sumCounterThread.start();
        sumCounterThread.join();
        System.out.println("From thread: " + ((IntegerSumThread) sumCounterThread).getResult());

        Callable<Long> sumCounterCallable = new IntegerSumCallable(integers);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Long> sumFuture = executorService.submit(sumCounterCallable);
        System.out.println("From callable: " + sumFuture.get());
        executorService.shutdown();
    }
}
