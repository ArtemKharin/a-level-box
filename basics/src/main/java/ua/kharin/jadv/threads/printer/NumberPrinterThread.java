package ua.kharin.jadv.threads.printer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class NumberPrinterThread extends Thread {
    private Integer number;

    @Override
    public void run() {
        System.out.println("From Thread: " + number);
    }

}
