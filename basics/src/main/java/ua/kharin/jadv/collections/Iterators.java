package ua.kharin.jadv.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Iterators {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.addAll(Arrays.asList("four", "five"));
        System.out.println(list.size());
        System.out.println(list);
        list.set(3, "replaced");
        System.out.println(list);

        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("==========================");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
        System.out.println("==========================");
        //создаем новый итератор с курсором указывающим на последний элемент
        iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}