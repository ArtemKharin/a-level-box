package ua.kharin.jadv.practice21;

import org.junit.jupiter.api.Test;
import ua.kharin.jadv.practice21.model.Color;
import ua.kharin.jadv.practice21.model.Toy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ua.kharin.jadv.practice21.ToyService.validateToy;

class ToyServiceTest {
    @Test
    void validateToyValidTest() {
        Toy toy = new Toy(Color.GREEN, 15, "tester");
        validateToy(toy);
    }

    @Test
    void validateToyHeightInvalidTest() {
        Toy toy = new Toy(Color.GREEN, 1, "tester");
        ValidationException exception = assertThrows(ValidationException.class, () -> validateToy(toy));
        assertEquals("Wrong value, minimum: 10", exception.getMessage());
    }

    @Test
    void validateToyColorInvalidTest() {
        Toy toy = new Toy(Color.BLUE, 15, "tester");
        ValidationException exception = assertThrows(ValidationException.class, () -> validateToy(toy));
        assertEquals("Wrong color, valid values: [GREEN, RED]", exception.getMessage());
    }

    @Test
    void validateToyColorAndHeightInvalidTest() {
        Toy toy = new Toy(Color.BLUE, 1, "tester");
        assertThrows(ValidationException.class, () -> validateToy(toy));
    }
}