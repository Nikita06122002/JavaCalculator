package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите два числа и оператор в формате a (+,-,/,*) b");
            String arguments = scanner.nextLine();
            System.out.println(arguments);
            Operators operators = Operators.fetchAllArguments(arguments);
            if (!CalculatorHelper.checkCorrect(operators.firstArg, CalculatorHelper.ArgType.NUMBER)) {
                throw new NumberFormatException("Аргумент должен содержать только арабские или римские цифры!");
            } else if (!CalculatorHelper.checkCorrect(operators.secondArg, CalculatorHelper.ArgType.NUMBER)) {
                throw new NumberFormatException("Аргумент должен содержать только арабские или римские цифры!");
            } else if (!CalculatorHelper.checkCorrect(operators.firstArg, CalculatorHelper.ArgType.OP)) {
                throw new NumberFormatException("Недопустимый оператор!");
            }
            calculate(operators.firstArg, operators.secondArg, operators.operator);
        }
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
