// VANSHIKA TYAGI
// 22070126128
// AIML B-3


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Input input = new Input();
        double[] numbers;
        double firstNumber, secondNumber;
        Scanner scn = new Scanner(System.in);

        try {
            // Get input numbers from the user
            numbers = input.inputNumbers();
            firstNumber = numbers[0];
            secondNumber = numbers[1];
        } catch (InputMismatchException e) {
            System.out.println("Error: InputMismatchException - Please enter valid numbers.");
            return;
        }

        // Main program loop
        while (true) {
            System.out.println("Enter Operation");
            System.out.println("+ for Addition Operation");
            System.out.println("- for Subtraction Operation");
            System.out.println("* for Multiplication Operation");
            System.out.println("/ for Division Operation");
            System.out.println("A for Array Operation");
            System.out.println("E for Exit");

            char operator;

            try {
                // Get the operation choice from the user
                operator = scn.next().charAt(0);
            } catch (InputMismatchException e) {
                System.out.println("Error: InputMismatchException - Please enter a valid operation character.");
                continue;
            }

            switch (operator) {
                case '+':
                    // Addition operation
                    System.out.println("The Addition of " + firstNumber + " and " +
                            secondNumber + " is " + calculator.addition(firstNumber, secondNumber));
                    break;
                case '-':
                    // Subtraction operation
                    System.out.println("The Subtraction of " + firstNumber + " and " +
                            secondNumber + " is " + calculator.subtraction(firstNumber, secondNumber));
                    break;
                case '*':
                    // Multiplication operation
                    System.out.println("The Multiplication of " + firstNumber + " and " +
                            secondNumber + " is " + calculator.multiplication(firstNumber, secondNumber));
                    break;
                case '/':
                    // Division operation
                    System.out.println("The Division of " + firstNumber + " and " + secondNumber
                            + " is " + calculator.division(firstNumber, secondNumber));
                    break;
                case 'A':
                    // Array operations
                    double[] arr = input.getArrayInput();
                    System.out.println("var for variance Operation");
                    System.out.println("std for Standard Deviation Operation");
                    System.out.println("avg for Average Operation");
                    String arrayOperation = scn.next();
                    try {
                        switch (arrayOperation) {
                            case "var":
                                // Variance operation
                                System.out.println("Variance: " + calculator.varianceOfArray(arr));
                                break;
                            case "std":
                                // Standard deviation operation
                                System.out.println("Standard Deviation: " + calculator.standardDeviationOfArray(arr));
                                break;
                            case "avg":
                                // Average operation
                                System.out.println("Average: " + calculator.calculateMean(arr));
                                break;
                            default:
                                System.out.println("Invalid array operation");
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Error: ArrayIndexOutOfBoundsException - Invalid array operation.");
                    }
                    break;
                case 'E':
                    // Exit the program
                    System.out.println("Exiting the program...");
                    scn.close(); // Close the scanner
                    return;
                default:
                    System.out.println("Invalid operation");
                    break;
            }
        }
    }
}
