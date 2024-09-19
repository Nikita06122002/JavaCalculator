package com.company;

public class Calculator {
public static int calculate(int argOne, int argTwo, char operation) {
    switch (operation) {
        case '+':
            return argOne + argTwo;
        case '-':
            return argOne - argTwo;
        case '*':
            return argOne * argTwo;
        case '/':
            return argOne / argTwo;
    }
    return 0;
}

public static String calculate(String argOne, String argTwo, char operation) {
    int firstArg = convertToArabianNumber(argOne);
    int secondArg = convertToArabianNumber(argTwo);
    if (firstArg < secondArg && operation == '-') {
        throw new NumberFormatException("в римской системе нет отрицательных чисел");
    }

    int result = calculate(convertToArabianNumber(argOne), convertToArabianNumber(argTwo), operation);
    return getRomeValue(result);
}

private static int convertToArabianNumber(String number) {
    String normalizedNumber = number.toLowerCase();
    int result = getRomanValue(normalizedNumber.charAt(0));
    int i = 1;
    int length = number.length() - 1;
    while (i <= length) {
            if (getRomanValue(normalizedNumber.charAt(i)) > getRomanValue(normalizedNumber.charAt(i - 1))) {
                result -= getRomanValue(normalizedNumber.charAt(i - 1));
                result += getRomanValue(normalizedNumber.charAt(i)) - getRomanValue(normalizedNumber.charAt(i - 1));
            } else {
                result += getRomanValue(normalizedNumber.charAt(i));
            }
            i++;
    }
    return result;
}

    private static int getRomanValue(char romanChar) {
        switch (romanChar) {
            case 'i': return 1;
            case 'v': return 5;
            case 'x': return 10;
            case 'l': return 50;
            case 'c': return 100;
            case 'd': return 500;
            case 'm': return 1000;
            default: throw new IllegalArgumentException("Некорректная римская цифра: " + romanChar);
        }
    }

    private static String getRomeValue(int value) {
    if (value > 3999) {
        throw new NumberFormatException("стандартная римская система не поддерживает такие значения");
        }
        int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < arabicValues.length; i++) {
            while (value >= arabicValues[i]) {
                roman.append(romanSymbols[i]);
                value -= arabicValues[i];
            }
        }
        return roman.toString();
    }
}
