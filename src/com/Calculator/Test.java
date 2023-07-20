package com.Calculator;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = new ArrayList<>();

        boolean continueInput = true;
        while (continueInput) {
            System.out.print("Enter a number: ");
            double number = scanner.nextDouble();
            numbers.add(number);

            System.out.print("Do you want to enter another number? (y/n): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("y")) {
                continueInput = false;
            }
        }

        System.out.println("Select an operation:");

        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        System.out.print("Enter your choice (1-4): ");
        int operationChoice = scanner.nextInt();

        double result = 0;
        boolean isValidOperation = true;

        switch (operationChoice) {
            case 1:
                result = numbers.stream().reduce(0.0, Double::sum);
                break;
            case 2:
                result = numbers.stream().reduce(0.0, (a, b) -> a - b);
                break;
            case 3:
                result = numbers.stream().reduce(1.0, (a, b) -> a * b);
                break;
            case 4:
                if (numbers.stream().anyMatch(num -> num == 0)) {
                    System.out.println("Error: Cannot divide by zero!");
                    isValidOperation = false;
                } else {
                    result = numbers.stream().reduce((a, b) -> a / b).orElse(0.0);
                }
                break;
            default:
                System.out.println("Invalid choice!");
                isValidOperation = false;
                break;
        }

        if (isValidOperation) {
            System.out.println("Result: " + result);
        }

        scanner.close();
    }
}
