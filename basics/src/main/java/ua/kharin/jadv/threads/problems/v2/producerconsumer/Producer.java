package ua.kharin.jadv.threads.problems.v2.producerconsumer;

import lombok.SneakyThrows;

public class Producer extends AbstractThread {

    protected Producer(String name, Warehouse warehouse) {
        super(name, warehouse);
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Producer " + name + " delivered item: " + i);
            warehouse.put(String.valueOf(i));
            Thread.sleep(1000);
        }
    }
}
