package ua.kharin.jadv.streams;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvenCounterTest {
    private List<Integer> empty = Collections.emptyList();
    private List<Integer> filled = List.of(1, 2, 3, 4, 56, 7, 8, 9, 0);

    @Test
    void countWithLoopEmptyInput() {
        assertEquals(0, EvenCounter.countWithLoop(empty));
    }

    @Test
    void countWithStreamsEmptyInput() {
        assertEquals(0, EvenCounter.countWithStreams(empty));
    }

    @Test
    void countWithLoopFilledInput() {
        assertEquals(5, EvenCounter.countWithLoop(filled));
    }

    @Test
    void countWithStreamsFilledInput() {
        assertEquals(5, EvenCounter.countWithStreams(filled));
    }
}