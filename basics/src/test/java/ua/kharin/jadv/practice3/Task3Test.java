package ua.kharin.jadv.practice3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task3Test {
    @ParameterizedTest
    @ValueSource(strings = {"aaa", "bababaa", "5623623aaa", "   3 65e y7ret a u534yhr a ht u4a"})
    void calcSymbolAInTextTest(String text) {
        assertEquals(3, Task3.calcCharFrequency(text, 'a'));
    }

    @ParameterizedTest
    @CsvSource(value = {"aaa:3", "bababaa:4", "5623623aaa:3", "   3 65e y7ret a u534yhr a ht u4a:3"},
            delimiterString = ":")
    void calcSymbolAInTextCSVSourceTest(String input, Integer expectedResult) {
        assertEquals(expectedResult, Task3.calcCharFrequency(input, 'a'));
    }
}