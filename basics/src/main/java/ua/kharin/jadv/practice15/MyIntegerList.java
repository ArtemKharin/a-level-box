package ua.kharin.jadv.practice15;

import java.util.Arrays;
import java.util.Iterator;

public class MyIntegerList implements Iterable<Integer> {
    private int[] array;
    private int lastElementIndex = -1;

    public MyIntegerList(int size) {
        this.array = new int[size];
    }

    public void add(int value) {
        if (lastElementIndex < array.length - 1) {
            array[++lastElementIndex] = value;
        } else {
            throw new IllegalStateException("List is full");
        }
    }

    public void removeLast() {
        array[lastElementIndex--] = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIntegerIterator();
    }

    private class MyIntegerIterator implements Iterator<Integer> {
        private int index = -1;

        @Override
        public boolean hasNext() {
            return index < lastElementIndex;
        }

        @Override
        public Integer next() {
            return array[++index];
        }
    }
}
