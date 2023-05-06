package ua.kharin.jadv.collections;

import java.util.ArrayList;
import java.util.List;

public class ListExamples {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);
        list.add("One");
        list.add("Two");
        list.add(1, "Two22");
        list.add("Three");
        System.out.println(list);
        list.forEach(System.out::println);
        for (int i = 0; i < list.size(); i++) {
            String newValue = list.get(i) + "1";
            list.set(i, newValue);
        }
        System.out.println(list);
    }
}