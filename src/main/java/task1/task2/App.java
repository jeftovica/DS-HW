package task2;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter expression or read from file? ");
        String input = scanner.nextLine();

        if(input.equals("expression")) {
            System.out.print("Enter an expression: ");
            String expression = scanner.nextLine();

            System.out.print("Result is: ");
            System.out.println(Algorithm.calculate(expression));
        } else if (input.equals("read file")) {
            ArrayList<Double> results = new ArrayList<Double>();
            System.out.print("Enter file name/path: ");
            String fileName = scanner.nextLine();
            results = Algorithm.calculateFromFile(fileName);
            for(Double result: results) {
                System.out.println(result);
            }
        }
        scanner.close();
    }
}
