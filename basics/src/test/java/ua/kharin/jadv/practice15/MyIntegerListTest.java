package ua.kharin.jadv.practice15;

import org.junit.jupiter.api.Test;
import ua.kharin.jadv.practice15.MyIntegerList;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyIntegerListTest {
    @Test
    void testIteratorOnEmptyList() {
        MyIntegerList input = new MyIntegerList(3);
        Iterator<Integer> iterator = input.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    void testIteratorOnFilledList() {
        MyIntegerList input = new MyIntegerList(3);
        input.add(1);
        input.add(2);
        input.add(3);
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
        MyIntegerList input = new MyIntegerList(3);
        input.add(1);
        input.add(2);
        Iterator<Integer> iterator = input.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertFalse(iterator.hasNext());
    }

}