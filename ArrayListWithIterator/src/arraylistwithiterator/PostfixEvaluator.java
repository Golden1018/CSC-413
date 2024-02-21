package arraylistwithiterator;

import java.util.Stack;

public class PostfixEvaluator {

    public static double evaluatePostfix(String postfixExpression, double a, double b, double c, double d) {
        Stack<Double> stack = new Stack<>();

        for (char ch : postfixExpression.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push((double) (ch - '0'));
            } else if (ch == 'a') {
                stack.push(a);
            } else if (ch == 'b') {
                stack.push(b);
            } else if (ch == 'c') {
                stack.push(c);
            } else if (ch == 'd') {
                stack.push(d);
            } else {
                // Operator encountered, pop two operands from stack
                if (!stack.isEmpty()) {
                    double operand2 = stack.pop();
                    if (!stack.isEmpty()) {
                        double operand1 = stack.pop();
                        double result = applyOperator(operand1, operand2, ch);
                        stack.push(result);
                    } else {
                        // Handle the case where there's not enough operands
                        return Double.NaN; // or throw an exception
                    }
                } else {
                    // Handle the case where there's not enough operands
                    return Double.NaN; // or throw an exception
                }
            }
        }

        // The final result should be at the top of the stack
        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            // Handle the case where the stack is empty at the end
            return Double.NaN; // or throw an exception
        }
    }

    private static double applyOperator(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            case '^':
                return Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
