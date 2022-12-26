package ua.kharin.jadv.threads.problems.v2.producerconsumer;

public abstract class AbstractThread extends Thread {
    protected String name;
    protected Warehouse warehouse;

    protected AbstractThread(String name, Warehouse warehouse) {
        this.name = name;
        this.warehouse = warehouse;
    }

    @Override
    public abstract void run();
}
