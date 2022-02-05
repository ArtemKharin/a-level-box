package ua.kharin.jadv.threads.stopping;

public class StoppableTaskDemo {
    public static void main(String[] args) throws InterruptedException {
        StoppableNamePrinter task = new StoppableNamePrinter();
        new Thread(task).start();
        Thread.sleep(5000);
        task.stop();
    }
}
