package arraylistwithiterator;

import java.util.Scanner;

public class ExpressionDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String infixExpression = "(a+b)*(c+d)";
        String postfixExpression = "ac-b^d+";

        while (true) {
            System.out.println("Do you want to compute expressions? (yes/no)");
            String userResponse = scanner.nextLine().toLowerCase();

            if (userResponse.equals("no")) {
                System.out.println("Exiting the program.");
                break;
            } else if (userResponse.equals("yes")) {
                System.out.println("Enter values for identifiers:");
                System.out.print("a = ");
                double a = scanner.nextDouble();
                System.out.print("b = ");
                double b = scanner.nextDouble();
                System.out.print("c = ");
                double c = scanner.nextDouble();
                System.out.print("d = ");
                double d = scanner.nextDouble();

                // Evaluate infix expression
                double infixResult = InfixEvaluator.evaluateInfix(infixExpression, a, b, c, d);
                System.out.println("Value of infix string " + infixExpression +
                                   " with a = " + a + ", b = " + b + ", c = " + c + ", d = " + d +
                                   " is " + infixResult);

                // Evaluate postfix expression
                double postfixResult = PostfixEvaluator.evaluatePostfix(postfixExpression, a, b, c, d);
                System.out.println("Value of postfix string " + postfixExpression +
                                   " with a = " + a + ", b = " + b + ", c = " + c + ", d = " + d +
                                   " is " + postfixResult);

                // Consume the newline character left by nextDouble()
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
        scanner.close();
    }
}
