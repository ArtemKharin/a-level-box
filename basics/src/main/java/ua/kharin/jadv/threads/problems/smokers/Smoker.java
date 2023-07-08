package ua.kharin.jadv.threads.problems.smokers;

import lombok.SneakyThrows;

import static ua.kharin.jadv.threads.problems.smokers.Type.MATCHES;
import static ua.kharin.jadv.threads.problems.smokers.Type.PAPER;

public class Smoker extends Thread {
    private Type ownType;
    private Table table;

    public Smoker(Table table, Type ownType) {
        this.ownType = ownType;
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            getRequiredResources();
            smoke();
            table.notifyAgent();
        }
    }

    private void getRequiredResources() {
        if (PAPER == ownType) {
            table.getMatchesAndTobacco();
        } else if (MATCHES == ownType) {
            table.getTobaccoAndPaper();
        } else {
            table.getPaperAndMatches();
        }
    }

    @SneakyThrows
    private void smoke() {
        System.out.println("Smoker " + Thread.currentThread().getName() + " is smoking");
        Thread.sleep(2000);
    }
}
