package ua.kharin.jadv.threads.problems.v2.producerconsumer;

public class ProducerConsumerRunner {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Consumer consumer = new Consumer("cons1", warehouse);
        Consumer consumer1 = new Consumer("cons2", warehouse);
        Producer producer = new Producer("prod1", warehouse);
        consumer.start();
        consumer1.start();
        producer.start();
    }
}
