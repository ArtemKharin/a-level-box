package ua.kharin.jadv.threads.problems.producerconsumer;

public class Warehouse {
    private String lastTitle;
    private boolean available;

    public synchronized void put(String title) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        lastTitle = title;
        notifyAll();
        available = true;
    }

    public synchronized String get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll();
        available = false;
        return lastTitle;
    }
}
