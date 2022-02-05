package ua.kharin.jadv.threads.stopping;

public class StoppableNamePrinter implements Runnable, Stoppable {

    private volatile boolean running = true;

    @Override
    public synchronized void stop() {
        System.out.println("Stopping execution");
        running = false;
        notify();
    }

    @Override
    public synchronized void run() {
        while (running) {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                wait(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Execution stopped");
    }
}
