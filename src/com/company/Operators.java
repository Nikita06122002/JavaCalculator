package com.company;

public class Operators {
    String firstArg;
    String secondArg;
    String operator;

    public static Operators fetchAllArguments(String args) {
        Operators operators = new Operators();
        boolean operatorHasFind = false;
        boolean beforeOperator = true;
        boolean afterOperator = false;
        for (int i = 0; i < args.length(); i++) {
            char currentChar = args.charAt(i);
            if (args.charAt(i) == ' ') {
                continue;
            }
            if (CalculatorHelper.isOperator(currentChar) && operatorHasFind) {
                throw new NumberFormatException("Недопустимый оператор или превышено количество операций");
            }
            if (!operatorHasFind) {
                if (CalculatorHelper.isOperator(currentChar)) {
                    operators.operator = String.valueOf(currentChar);
                    operatorHasFind = true;
                } else {
                    if (operators.firstArg == null) {
                        operators.firstArg = String.valueOf(currentChar);
                    } else {
                        operators.firstArg += currentChar;
                    }
                }
            } else {
                if (operators.secondArg == null) {
                    operators.secondArg = String.valueOf(currentChar);
                } else {
                    operators.secondArg += currentChar;
                }
            }
        }
        return operators;
    }
}
