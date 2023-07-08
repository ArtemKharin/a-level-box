package ua.kharin.jadv.threads.problems.smokers;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Agent extends Thread {
    private Smoker[] smokers = new Smoker[3];
    private Table table;

    public Agent() {
        table = new Table();
        smokers[0] = new Smoker(table, Type.PAPER);
        smokers[1] = new Smoker(table, Type.TOBACCO);
        smokers[2] = new Smoker(table, Type.MATCHES);
    }

    @SneakyThrows
    @Override
    public void run() {
        Arrays.stream(smokers).forEach(Thread::start);
        while (true) {
            table.agentWait();
            putRandom();
        }
    }

    private void putRandom() {
        int random = ThreadLocalRandom.current().nextInt(0, 3);
        switch (random) {
            case 0 -> table.putMatchesAndTobacco();
            case 1 -> table.putPaperAndMatches();
            default -> table.putTobaccoAndPaper();

        }
    }
}
