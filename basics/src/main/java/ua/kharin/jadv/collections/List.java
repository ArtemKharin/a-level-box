package ua.kharin.jadv.collections;

import java.util.ArrayList;

public class List {
    public static void main(String[] args) {
        java.util.List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        for (int i = 0; i < list.size(); i++) {
            String newValue = list.get(i) + "1";
            list.set(i, newValue);
        }
        System.out.println(list);
    }
}