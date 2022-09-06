package ua.kharin.jadv.practice3;

//Для введённого пользователем с клавиатуры натурального числа посчитайте сумму всех его цифр
public class Task7 {
    public static void main(String[] args) {
        int number = 15354130;
        int result = sumDigits(number);
        System.out.println(number);
        System.out.println("sum of digits: " + result);
    }

    private static int sumDigits(int number) {
        int result = 0;
        while (number > 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

}
