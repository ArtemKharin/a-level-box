package ua.kharin.jadv.threads.problems.readwrite;

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReadWriteLock;

public class Writer extends AbstractThread {

    public Writer(ReadWriteLock lock) {
        super(lock);
    }

    @SneakyThrows
    @Override
    public void run() {
        lock.writeLock().lock();
        System.out.println("Thread " + Thread.currentThread().getName() + " WRITING");
        Thread.sleep(500);
        System.out.println("Thread " + Thread.currentThread().getName() + " finished WRITING");
        lock.writeLock().unlock();
    }
}
