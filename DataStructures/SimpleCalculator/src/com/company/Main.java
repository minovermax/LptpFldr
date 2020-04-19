package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main test = new Main();
        String[] strArr;

        System.out.println("Welcome to InfixCalculator!\n");

        boolean balanceCheck;
        do {
            Scanner user = new Scanner(System.in);
            System.out.print("Enter your infix expression: ");
            String userInput = user.nextLine();
            strArr = userInput.split("((?<=[\\+\\-\\*\\/\\(\\)\\{\\}\\[\\]])|(?=[\\+\\-\\*\\/\\(\\)\\{\\}\\[\\]]))");

            // checking the balance of parentheses
            balanceCheck = test.checkParentheses(strArr);

            if (!balanceCheck) {
                System.out.println("Your expression's parentheses are not balanced. Please enter a balanced infix expression.\n");
            } else {
                System.out.println("Your expression's parentheses are balanced.");
            }
        } while (!balanceCheck);

        System.out.println("\nCalculating ...\n");


        DecimalFormat df = new DecimalFormat("###.####");

        System.out.println("Your final result is: " + df.format(test.evaluate(strArr)));
        System.out.println("\nExiting InfixCalculator ...");

    }


    public double evaluate(String[] parsedArray) {

        ArrayStack<String> operators = new ArrayStack<>();
        ArrayStack<Double> operands = new ArrayStack<>();

        // default settings
        boolean priorityTrigger = false;
        int termCounter = 0;
        for (String element : parsedArray) {
            switch (element) {
                case "(":
                case " ":
                    break;

                case ")":
                    // calculating terms based on the termCounter (termCounter-1, because e.g. for 3 terms 2 calculations are needed)
                    for (int i2 = 0; i2 < termCounter - 1; ++i2) {
                        double laterValue = operands.pop();
                        double earlierValue = operands.pop();
                        String operator = operators.pop();
                        double value = calculate(earlierValue, laterValue, operator);
                        operands.push(value);
                    }
                    // resetting term counter
                    termCounter = 0;
                    break;

                case "*":
                case "/":
                    // triggering priority calculation for multiplication and division
                    priorityTrigger = true;
                    operators.push(element);
                    break;

                case "+":
                case "-":
                    operators.push(element);
                    break;

                default:
                    // pushing operands
                    operands.push(Double.parseDouble(element));

                    // calculating multiplications / divisions before pushing
                    if (priorityTrigger) {
                        double laterValue = operands.pop();
                        double earlierValue = operands.pop();
                        double valuePri = calculate(earlierValue, laterValue, operators.pop());
                        operands.push(valuePri);
                        priorityTrigger = false;

                        // decreasing counter because e.g. 2*3 turns into 6 (2 numbers in the stack turn into 1 number)
                        --termCounter;
                    }

                    // incrementing counter to keep track of the number of terms
                    ++termCounter;
                    break;
            }
        }

        // if there are any remaining terms
        if (termCounter != 1) {
            for (int i = 0; i < termCounter - 1; ++i) {
                double laterValue = operands.pop();
                double earlierValue = operands.pop();
                String operator = operators.pop();
                double value = calculate(earlierValue, laterValue, operator);
                operands.push(value);
            }
            termCounter = 0;
        }
        // return final value

        return operands.pop();
    }

    private double calculate(double earlierValue, double laterValue, String operator) {
        double value = 0;

        switch (operator) {
            case("+"):
                value = earlierValue + laterValue;
                break;
            case("-"):
                value = earlierValue - laterValue;
                break;
            case("*"):
                value = earlierValue * laterValue;
                break;
            case("/"):
                value = earlierValue / laterValue;
                break;
        }

        return value;
    }

    private boolean checkParentheses(String[] userArray) {
        int leftParCounter = 0;
        int rightParCounter = 0;

        for (String element : userArray) {
            if (element.equals("(")) {
                ++leftParCounter;
            } else if (element.equals(")")) {
                ++rightParCounter;
            }
        }

        return leftParCounter == rightParCounter;
    }
}
