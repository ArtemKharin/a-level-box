package ua.kharin.jadv.practice3;

//Из двух переданных чисел вывести нечетное. Считать пользователя умным, и что передаст правильные параметры.
public class Task2 {
    public static void main(String[] args) {
        printOddNumber(-1, 4);
        printOddNumber(2, 5);
        printOddNumber(0, 5);
    }

    public static void printOddNumber(int firstNumber, int secondNumber) {
        System.out.println(firstNumber % 2 == 0 ? secondNumber : firstNumber);
    }

}
