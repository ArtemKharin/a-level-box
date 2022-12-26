package ua.kharin.jadv.threads.problems.v2.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Warehouse {
    private final BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

    public void put(String title) throws InterruptedException {
        queue.put(title);
    }

    public String get() throws InterruptedException {
        return queue.take();
    }
}
