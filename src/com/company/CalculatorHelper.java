package com.company;

public class CalculatorHelper {
    public static boolean checkCorrectInputs(String firstArg, String secondArg, String operator) {
        if (operator.length() > 1) {
            System.out.println("Оператором является один из этих символов: / * + -");
            return false;
        }
        if (firstArg.isEmpty() || secondArg.isEmpty() || !isOperator(operator.charAt(0))) {
            System.out.println("Строка не является математической операцией");
            return false;
        }
        if ((isNumeric(firstArg) && !isNumeric(secondArg)) || (!isNumeric(firstArg) && isNumeric(secondArg))) {
            System.out.println("Введены числа из разных систем счислений");
            return false;
        }
        return true;
    }

    public static boolean isOperator(char operator) {
        switch (operator) {
            case '-':
            case '+':
            case '/':
            case '*':
                return true;
            default:
                return false;
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int convertStringToInt(String arg) {
        try {
            return Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: строка не может быть преобразована в целое число");
            return 0;
        }
    }
}
