package ua.kharin.jadv.practice3;

//Определить, как часто встречается определенный символ в строке.
public class Task3 {
    public static void main(String[] args) {
        String text = "public static int calcCharFrequency(String text, char symbol){";
        char symbol = 'c';
        System.out.println(calcCharFrequency(text, symbol));
    }

    public static int calcCharFrequency(String text, char symbol) {
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == symbol) {
                counter++;
            }
        }
        return counter;
    }
}
