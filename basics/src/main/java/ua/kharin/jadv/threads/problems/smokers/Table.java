package ua.kharin.jadv.threads.problems.smokers;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class Table {
    private Semaphore paperAndMatches = new Semaphore(1);
    private Semaphore matchesAndTobacco = new Semaphore(1);
    private Semaphore tobaccoAndPaper = new Semaphore(1);
    private Semaphore agent = new Semaphore(1);

    @SneakyThrows
    public Table() {
        paperAndMatches.acquire();
        matchesAndTobacco.acquire();
        tobaccoAndPaper.acquire();
    }

    @SneakyThrows
    public void getPaperAndMatches() {
        paperAndMatches.acquire();
    }

    @SneakyThrows
    public void getMatchesAndTobacco() {
        matchesAndTobacco.acquire();
    }

    @SneakyThrows
    public void getTobaccoAndPaper() {
        tobaccoAndPaper.acquire();
    }

    public void putPaperAndMatches() {
        System.out.println("put paper and matches");
        paperAndMatches.release();
    }

    public void putMatchesAndTobacco() {
        System.out.println("put matches and tobacco");
        matchesAndTobacco.release();
    }

    public void putTobaccoAndPaper() {
        System.out.println("put tobacco and paper");
        tobaccoAndPaper.release();
    }

    public void notifyAgent() {
        System.out.println("agent notified");
        agent.release();
    }

    @SneakyThrows
    public void agentWait() {
        System.out.println("agent awaiting");
        agent.acquire();
    }
}
