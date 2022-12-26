package ua.kharin.jadv.threads.problems.readwrite;

import java.util.concurrent.locks.ReadWriteLock;

public abstract class AbstractThread extends Thread {
    protected final ReadWriteLock lock;

    protected AbstractThread(ReadWriteLock lock) {
        this.lock = lock;
    }

    @Override
    public abstract void run();
}
