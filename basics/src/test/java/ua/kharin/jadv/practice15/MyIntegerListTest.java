package ua.kharin.jadv.practice15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyIntegerListTest {
    MyIntegerList input;

    @BeforeEach
    void setup() {
        input = new MyIntegerList(3);
    }

    @Test
    void testIteratorOnEmptyList() {
        Iterator<Integer> iterator = input.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    void testIteratorOnFilledList() {
        addToList(1, 2, 3);
        Iterator<Integer> iterator = input.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testIteratorOnPartiallyFilledList() {
        addToList(1, 2);
        Iterator<Integer> iterator = input.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testSize() {
        assertEquals(0, input.size());
        addToList(1);
        assertEquals(1, input.size());
        input.removeLast();
        assertEquals(0, input.size());
    }

    @Test
    void testToString() {
        addToList(1, 2, 3);
        assertEquals("[1, 2, 3]", input.toString());
    }

    private void addToList(int... numbers) {
        for (int number : numbers) {
            input.add(number);
        }
    }
}