package ua.kharin.jadv.threads.problems.producerconsumer;

public class Consumer extends AbstractThread {

    protected Consumer(String name, Warehouse warehouse) {
        super(name, warehouse);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Consumer " + name + " received item: " + warehouse.get());
        }
    }
}
