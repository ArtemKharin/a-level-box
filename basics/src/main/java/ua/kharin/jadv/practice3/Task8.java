package ua.kharin.jadv.practice3;

//Простейший калькулятор
//        Написать программу, в которой вводятся два числа-операнда x и y и знак арифметической операции (+, –, /, *).
//        Вычислить результат в зависимости от знака.
//        Предусмотреть реакции на возможный неверный знак операции, а также на ввод y=0 при делении.
//        Организовать возможность многократных вычислений без перезагрузки программы (то есть построить цикл).
//        В качестве символа прекращения вычислений принять '0'.

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String operation = getOperation(scanner);
            if (operation.equals("0")) {
                break;
            }
            if (isValidOperation(operation)) {
                int firstNumber = getFirstNumber(scanner);
                int secondNumber = getSecondNumber(scanner, operation);
                calculateAndPrintSwitch(operation, firstNumber, secondNumber);
            } else {
                System.out.println("Wrong input");
                scanner.close();
            }
        }
    }

    private static String getOperation(Scanner scanner) {
        System.out.println("Choose operation ( +, -, /, * ) or 0 to exit");
        return scanner.nextLine();
    }

    private static boolean isValidOperation(String operation) {
        return operation.equals("+") || operation.equals("-") || operation.equals("/")
                || operation.equals("*");
    }

    private static int getFirstNumber(Scanner scanner) {
        System.out.println("Enter first number");
        return scanner.nextInt();
    }

    private static int getSecondNumber(Scanner scanner, String operation) {
        System.out.println("Enter second number");
        int secondNumber = scanner.nextInt();
        while (secondNumber == 0 && operation.equals("/")) {
            System.out.println("Enter second number again, prohibited division by zero");
            secondNumber = scanner.nextInt();
        }
        return secondNumber;
    }

    private static void calculateAndPrint(String operation, int firstNumber, int secondNumber) {
        if ("/".equals(operation)) {
            System.out.println((double) firstNumber / secondNumber);
        } else if ("*".equals(operation)) {
            System.out.println(firstNumber * secondNumber);
        } else if ("+".equals(operation)) {
            System.out.println(firstNumber + secondNumber);
        } else {
            System.out.println(firstNumber - secondNumber);
        }
    }

    private static void calculateAndPrintSwitch(String operation, int firstNumber, int secondNumber) {
        double result = switch (operation) {
            case "/":
                yield (double) firstNumber / secondNumber;
            case "*":
                yield firstNumber * secondNumber;
            case "+":
                yield firstNumber + secondNumber;
            default:
                yield firstNumber - secondNumber;
        };
        System.out.println(result);
    }
}
