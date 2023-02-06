package ua.kharin.springdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class NumberService {
    private final Logger log = LoggerFactory.getLogger(NumberService.class);
    public int getRandom(int from, int to) {
        log.info("Generating random number from {} to {}", from, to);
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    public void validateInputForRandom(int from, int to) {
        if (from < 0 || to < 0) {
            RuntimeException exception = new IllegalArgumentException("Wrong input [negative values]: from " + from + " to " + to);
            log.error("Wrong input", exception);
            throw exception;
        } else if (from >= to) {
            RuntimeException exception = new IllegalArgumentException("Wrong input [from>to]: from " + from + " to " + to);
            log.error("Wrong input", exception);
            throw exception;
        }
    }
}
