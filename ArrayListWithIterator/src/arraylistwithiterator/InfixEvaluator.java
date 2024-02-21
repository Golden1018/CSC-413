package arraylistwithiterator;

import java.util.Stack;

public class InfixEvaluator {

    public static double evaluateInfix(String infixExpression, double a, double b, double c, double d) {
        Stack<Double> valueStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        // Iterate through each character in the infix expression
        for (char ch : infixExpression.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                continue; // Skip whitespaces
            } else if (Character.isDigit(ch)) {
                // If the character is a digit, extract the entire number
                StringBuilder operand = new StringBuilder();
                operand.append(ch);

                while (Character.isDigit(peekNextChar(infixExpression))) {
                    operand.append(peekNextChar(infixExpression));
                }

                valueStack.push(Double.parseDouble(operand.toString()));
            } else if (ch == 'a') {
                valueStack.push(a);
            } else if (ch == 'b') {
                valueStack.push(b);
            } else if (ch == 'c') {
                valueStack.push(c);
            } else if (ch == 'd') {
                valueStack.push(d);
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    performOperation(valueStack, operatorStack);
                }
                operatorStack.pop(); // Discard the '('
            } else {
                // Operator encountered
                while (!operatorStack.isEmpty() && getPrecedence(operatorStack.peek()) >= getPrecedence(ch)) {
                    performOperation(valueStack, operatorStack);
                }
                operatorStack.push(ch);
            }
        }

        // Process any remaining operators in the stacks
        while (!operatorStack.isEmpty()) {
            performOperation(valueStack, operatorStack);
        }

        // The result should be at the top of the value stack
        return valueStack.pop();
    }

    private static char peekNextChar(String expression) {
        // Helper method to peek at the next character in the expression
        // without consuming it
        return expression.isEmpty() ? '\0' : expression.charAt(0);
    }

    private static int getPrecedence(char operator) {
        // Helper method to get the precedence of an operator
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private static void performOperation(Stack<Double> valueStack, Stack<Character> operatorStack) {
        // Helper method to perform an operation and push the result onto the value stack
        char operator = operatorStack.pop();
        double operand2 = valueStack.pop();
        double operand1 = valueStack.pop();

        switch (operator) {
            case '+':
                valueStack.push(operand1 + operand2);
                break;
            case '-':
                valueStack.push(operand1 - operand2);
                break;
            case '*':
                valueStack.push(operand1 * operand2);
                break;
            case '/':
                valueStack.push(operand1 / operand2);
                break;
        }
    }
}
