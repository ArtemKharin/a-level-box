package ua.kharin.jadv.threads.problems.readwrite;

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReadWriteLock;

public class Reader extends AbstractThread {

    public Reader(ReadWriteLock lock) {
        super(lock);
    }

    @SneakyThrows
    @Override
    public void run() {
        lock.readLock().lock();
        System.out.println("Thread " + Thread.currentThread().getName() + " READING");
        Thread.sleep(500);
        System.out.println("Thread " + Thread.currentThread().getName() + " finished READING");
        lock.readLock().unlock();
    }
}
