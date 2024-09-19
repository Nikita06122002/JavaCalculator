package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первый аргумент");
        String firstArg = scanner.nextLine();
        System.out.println("Введено " + firstArg);
        System.out.println("Введите второй аргумент");
        String secondArg = scanner.nextLine();
        System.out.println("Введено " + secondArg);
        System.out.println("Введите желаемый оператор: + - / *");
        String operator = scanner.nextLine();
        calculate(firstArg, secondArg, operator);
    }

    private static void calculate(String firstArg, String secondArg, String operator) {

        if (CalculatorHelper.checkCorrectInputs(firstArg, secondArg, operator)) {
            if (CalculatorHelper.isNumeric(firstArg) && CalculatorHelper.isNumeric(secondArg)) {
                System.out.println("Результат " +
                        Calculator.calculate(CalculatorHelper.convertStringToInt(firstArg),
                        CalculatorHelper.convertStringToInt(secondArg), operator.charAt(0)));
            } else {
                System.out.println("Результат " + Calculator.calculate(firstArg, secondArg, operator.charAt(0)));
            }
        }
    }
}
