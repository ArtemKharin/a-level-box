package ua.kharin.jadv.practice14;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> list;

    public Box(List<T> list) {
        this.list = list;
    }

    public T get(int index) {
        return list.get(index);
    }

    public void add(T object) {
        list.add(object);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>(new ArrayList<>());
        System.out.println(integerBox);
        integerBox.add(15);
        System.out.println(integerBox);
        System.out.println(integerBox.get(0));

        Box<String> stringBox = new Box<>(new ArrayList<>());
        System.out.println(stringBox);
        stringBox.add("hello");
        System.out.println(stringBox);
        System.out.println(stringBox.get(0));
    }
}