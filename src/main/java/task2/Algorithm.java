package task2;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Stack;

    public class Algorithm {
        private static Stack<Double> valueStack = new Stack<>();
    public static Double calculate(String s1) {
        Stack<Character> operatorStack;
        operatorStack = new Stack<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < s1.length() && (Character.isDigit(s1.charAt(i)) || s1.charAt(i) == '.')) {
                    sb.append(s1.charAt(i++));
                }
                valueStack.push(Double.parseDouble(sb.toString()));
                i--;
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (operatorStack.peek() != '(') {
                    valueStack.push(applyOperation(operatorStack.pop(), valueStack.pop(), valueStack.pop()));
                }
                operatorStack.pop();
            } else if (isOperator(c)) {
                while (!operatorStack.empty() && hasPrecedence(c, operatorStack.peek())) {
                    valueStack.push(applyOperation(operatorStack.pop(), valueStack.pop(), valueStack.pop()));
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.empty()) {
            valueStack.push(applyOperation(operatorStack.pop(), valueStack.pop(), valueStack.pop()));
        }

        return valueStack.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^' || c == '√';
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        } else if ((op1 == '*' || op1 == '/' || op1 == '%') && (op2 == '+' || op2 == '-')) {
            return false;
        } else if (op1 == '^' && op2 != '√') {
            return true;
        } else return op2 != '^' || op1 == '√';
    }

    private static double applyOperation(char op, double b, double a) {
        //  Stack<Double> valueStack = new Stack<>();
        /// if (valueStack.empty()) {
        //       throw new UnsupportedOperationException("Invalid expression: stack is empty");
        //   }
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
            case '%':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot perform modulus by zero");
                }
                return a % b;
            case '^':
                return Math.pow(a, b);
            case '√':
                return Math.sqrt(b);
        }
        return 0;
    }

    public static ArrayList<Double> calculateFromFile(String s) {


        return null;
    }
}