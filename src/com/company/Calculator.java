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

public static int calculate(String argOne, String argTwo, char operation) {
    return calculate(convertToArabianNumber(argOne), convertToArabianNumber(argTwo), operation);
}

private static int convertToArabianNumber(String number) {
    String normalizedNumber = number.toLowerCase();
    int result = getRomanValue(normalizedNumber.charAt(0));
    int i = 1;
    int length = number.length() - 1;
    while (i <= length) {
        char current = normalizedNumber.charAt(i);
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
}
