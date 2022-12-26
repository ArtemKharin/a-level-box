package ua.kharin.jadv.threads.problems.readwrite;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteRunner {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        List<AbstractThread> threads = List.of(new Reader(lock), new Writer(lock), new Reader(lock), new Writer(lock),
                new Reader(lock), new Writer(lock), new Reader(lock), new Writer(lock),
                new Reader(lock), new Writer(lock), new Reader(lock), new Writer(lock),
                new Reader(lock), new Writer(lock), new Reader(lock), new Writer(lock),
                new Reader(lock), new Writer(lock), new Reader(lock), new Writer(lock),
                new Reader(lock), new Writer(lock), new Reader(lock), new Writer(lock),
                new Reader(lock), new Writer(lock), new Reader(lock), new Writer(lock),
                new Reader(lock), new Writer(lock), new Reader(lock), new Writer(lock),
                new Reader(lock), new Writer(lock), new Reader(lock), new Writer(lock),
                new Reader(lock), new Writer(lock), new Reader(lock), new Writer(lock),
                new Reader(lock), new Writer(lock), new Reader(lock), new Writer(lock),
                new Reader(lock), new Writer(lock), new Reader(lock), new Writer(lock));
        threads.parallelStream().forEach(Thread::start);
    }
}
