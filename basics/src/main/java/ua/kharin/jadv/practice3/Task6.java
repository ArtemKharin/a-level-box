package ua.kharin.jadv.practice3;

//Написать программу, подсчитывающую количество четных и нечетных цифр в числе.
public class Task6 {
    public static void main(String[] args) {
        int number = 15354130;
        int[] result = calcEvenAndOddAmount(number);
        System.out.println("Четных: " + result[0]);
        System.out.println("Нечетных: " + result[1]);
    }

    private static int[] calcEvenAndOddAmount(int number) {
        int even = 0;
        int odd = 0;
        while (number > 0) {
            if (number % 2 == 0) {
                even++;
            }
            if (number % 2 == 1) {
                odd++;
            }
            number /= 10;
        }
        int[] array = new int[2];
        array[0] = even;
        array[1] = odd;
        return array;
    }

}
