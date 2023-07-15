package ua.kharin.jadv.practice2;

public class StringExample {
    public static void main(String[] args) {
        String someValue = "value";
        String anotherValue = new String("value");
        String equalString = someValue;
        String someValue1 = "value";

        System.out.println(someValue == anotherValue);
        System.out.println(someValue == equalString);
        System.out.println(someValue == someValue1);

        System.out.println(System.lineSeparator() + someValue.equals(anotherValue));
        System.out.println(someValue.equals(equalString));
        System.out.println(someValue.equals(someValue1));
    }
}
