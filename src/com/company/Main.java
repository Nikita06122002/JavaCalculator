package com.company;

import com.company.Calculator;

public class Main {

    public static void main(String[] args) {
	System.out.println("Hello world");
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(2, 5, '*'));
        System.out.println(calculator.calculate("IV", "IX", '-'));
    }
}
