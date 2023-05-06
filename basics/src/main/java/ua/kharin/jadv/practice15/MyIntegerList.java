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
        if (lastElementIndex >= array.length - 1) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[++lastElementIndex] = value;
    }

    public void removeLast() {
        lastElementIndex--;
    }

    public int size() {
        return lastElementIndex + 1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i <= lastElementIndex; i++) {
            result.append(array[i]).append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
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

    public static void main(String[] args) {
        MyIntegerList list = new MyIntegerList(3);
        list.add(0);
        list.add(0);
        list.add(0);
        System.out.println(list);
        list.add(0);
        list.add(0);
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
    }
}
