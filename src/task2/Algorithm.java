package task2;
import task1.Stack;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Algorithm {
    public static Stack<String> operatorStack = new Stack<String>();
    public static Stack<Double> valueStack = new Stack<Double>();
    public static ArrayList<String> supportedOperators = new ArrayList<String>() {{
        add("+");
        add("-");
        add("*");
        add("/");
        add("%");
        add("^");
        add("√");
    }};

    public static Double calculate(String s1) {
        String[] string1 = s1.split(" ");
        for(int i = 0; i < string1.length; i++) {
            if(string1[i].equals("(")) {
                continue;
            } else if(string1[i].equals(")")) {
                Double operand1 = null;
                Double operand2 = null;
                String operator;

                operand1 = valueStack.pop();
                operator = operatorStack.pop();

                if(operator.equals("√") == false) {
                    operand2 = valueStack.pop();
                }

                switch(operator) {
                    case "+":
                        valueStack.push(operand2 + operand1);
                        break;
                    case "-":
                       valueStack.push(operand2 - operand1);
                        break;
                    case "*":
                       valueStack.push(operand2 * operand1);
                        break;
                    case "/":
                        valueStack.push(operand2 / operand1);
                        break;
                    case "%":
                        valueStack.push(operand2 % operand1);
                        break;
                    case "^":
                        valueStack.push(Math.pow(operand2, operand1));
                        break;
                    case "√":
                        valueStack.push(Math.sqrt(operand1));
                        break;
                }
            } else if(supportedOperators.contains(string1[i]))
            {
                operatorStack.push(string1[i]);
            } else {
                valueStack.push(Double.parseDouble(string1[i]));
            }
        }
        return valueStack.pop();
    }

    public static ArrayList<Double> calculateFromFile(String fileName) throws FileNotFoundException {
        ArrayList<Double> results = new ArrayList<Double>();
        ArrayList<String> lines  = FileUtils.readFile("task_2/" + fileName);

        for(String line: lines) {
            results.add(calculate(line));
        }

        return results;
    }
}
