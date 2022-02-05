package ua.kharin.jadv.threads.printer;

public class NumberPrinter {

    public static void main(String[] args) {
        //using thread
        for (int i = 0; i < 10; i++) {
            new NumberPrinterThread(i).start();
        }

        //using runnable
        for (int i = 0; i < 10; i++) {
            new Thread(new NumberPrinterRunnable(i)).start();
        }
    }
}
