package com.company;

public class CalculatorHelper {
    public static boolean checkCorrectInputs(String firstArg, String secondArg, String operator) {
        if (operator.length() > 1) {
            throw new NumberFormatException("Оператором является один из этих символов: / * + -");
        }
        if (firstArg.isEmpty() || secondArg.isEmpty() || !isOperator(operator.charAt(0))) {
            throw new NumberFormatException("Строка не является математической операцией:" + operator);
        }
        if ((isNumeric(firstArg) && !isNumeric(secondArg)) || (!isNumeric(firstArg) && isNumeric(secondArg))) {
            throw new NumberFormatException("Введены числа из разных систем счислений");
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
            throw new NumberFormatException("Ошибка: строка не может быть преобразована в целое число");
        }
    }

    public static boolean checkCorrect(String arg, ArgType type) {
        switch (type) {
            case NUMBER:
                if (arg.contains("+") || arg.contains("-") || arg.contains("*") || arg.contains("/")) {
                    return false;
                }
            case OP:
                String input = "-+/*";
                if (input.matches(".*[a-zA-Z0-9].*")) {
                    return false;
                }
        }
        return true;
    }

    enum ArgType {
        NUMBER, OP;
    }
}