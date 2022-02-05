package ua.kharin.jadv.threads.printer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class NumberPrinterRunnable implements Runnable {
    private Integer number;

    @Override
    public void run() {
        System.out.println("From runnable: " + number);
    }

}
