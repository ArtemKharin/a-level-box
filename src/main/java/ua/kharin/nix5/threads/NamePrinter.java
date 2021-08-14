package ua.kharin.nix5.threads;

import java.util.ArrayList;
import java.util.List;

public class NamePrinter extends Thread {

    public NamePrinter(int threadNumber) {
        super(String.valueOf(threadNumber));
    }

    @Override
    public void run() {
        System.out.println("Hello from thread " + this.getName());
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            threads.add(new NamePrinter(i));
        }
        for (int i = threads.size() - 1; i >= 0; i--) {
            threads.get(i).start();
            threads.get(i).join();
        }
    }
}
