import java.util.Scanner;
import java.util.Stack;

// Class for evaluating infix expressions
class InfixEvaluator {
    // Method to evaluate infix expression with given variable values a, b, c, d
    public static int evaluateInfix(String str, int a, int b, int c, int d) {
        // Stacks to hold values and operators during evaluation
        Stack<Integer> valueStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        // Iterate through each character in the infix expression
        for (char ch : str.toCharArray()) {
            // If the character is a letter (variable), push its corresponding value onto the value stack
            if (Character.isLetter(ch)) {
                switch (ch) {
                    case 'a':
                        valueStack.push(a);
                        break;
                    case 'b':
                        valueStack.push(b);
                        break;
                    case 'c':
                        valueStack.push(c);
                        break;
                    case 'd':
                        valueStack.push(d);
                        break;
                }
            }
            // If the character is an operator (+, -, *, /), handle operator precedence and perform calculations
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(ch)) {
                    int operand2 = valueStack.pop();
                    int operand1 = valueStack.pop();
                    char operator = operatorStack.pop();
                    valueStack.push(applyOperator(operand1, operand2, operator));
                }
                operatorStack.push(ch);
            }
        }

        // Process remaining operators and operands in the stacks
        while (!operatorStack.isEmpty()) {
            int operand2 = valueStack.pop();
            int operand1 = valueStack.pop();
            char operator = operatorStack.pop();
            valueStack.push(applyOperator(operand1, operand2, operator));
        }

        // The final result is left on the value stack
        return valueStack.pop();
    }

    // Helper method to determine operator precedence
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    // Helper method to apply the given operator to two operands
    private static int applyOperator(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
        }
        return 0;
    }
}

// Class for evaluating postfix expressions
class PostfixEvaluator {
    // Method to evaluate postfix expression with given variable values a, b, c, d
    public static int evaluatePostfix(String str, int a, int b, int c, int d) {
        // Stack to hold values during evaluation
        Stack<Integer> stack = new Stack<>();

        // Iterate through each character in the postfix expression
        for (char ch : str.toCharArray()) {
            // If the character is a letter (variable), push its corresponding value onto the stack
            if (Character.isLetter(ch)) {
                switch (ch) {
                    case 'a':
                        stack.push(a);
                        break;
                    case 'b':
                        stack.push(b);
                        break;
                    case 'c':
                        stack.push(c);
                        break;
                    case 'd':
                        stack.push(d);
                        break;
                }
            }
            // If the character is an operator (+, -, *, /), perform calculations using the top two values on the stack
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(applyOperator(operand1, operand2, ch));
            }
        }

        // The final result is left on the stack
        return stack.pop();
    }

    // Helper method to apply the given operator to two operands
    private static int applyOperator(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
        }
        return 0;
    }
}

// Class for driving the expression evaluation
class ExpressionDriver {
    // Infix and postfix expressions to be evaluated
    private static final String INFIX_EXPRESSION = "(a+b)*(c+d)";
    private static final String POSTFIX_EXPRESSION = "ac-b^d+";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Loop for user input and expression evaluation
        while (true) {
            System.out.println("Enter values for identifiers a, b, c, d:");

            // Read user input for variable values
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            // Evaluate infix and postfix expressions with the provided variable values
            int infixResult = InfixEvaluator.evaluateInfix(INFIX_EXPRESSION, a, b, c, d);
            int postfixResult = PostfixEvaluator.evaluatePostfix(POSTFIX_EXPRESSION, a, b, c, d);

            // Display results to the user
            System.out.println("Value of infix string " + INFIX_EXPRESSION +
                    " with a = " + a + ", b = " + b + ", c = " + c + ", d = " + d +
                    " is " + infixResult);

            System.out.println("Value of postfix string " + POSTFIX_EXPRESSION +
                    " with a = " + a + ", b = " + b + ", c = " + c + ", d = " + d +
                    " is " + postfixResult);

            // Ask the user if they want to compute again
            System.out.println("Do you want to compute again? (yes/no)");
            String response = scanner.next();

            // If the user responds with "no," exit the loop
            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }

        // Display a message indicating the end of the program
        System.out.println("Program ended.");
    }
}
