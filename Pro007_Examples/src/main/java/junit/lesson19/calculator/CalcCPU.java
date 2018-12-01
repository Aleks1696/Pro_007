package junit.lesson19.calculator;

import java.util.Scanner;

public class CalcCPU {

    public static Integer first;
    public static Integer second;
    public static String operation;
    public static String exp;

    public static void parseExpression(String expression) {
        Scanner scanExp = new Scanner(expression);
        first = scanExp.nextInt();
        operation = scanExp.next();
        second = scanExp.nextInt();
        exp = expression;
    }

    public static String result() {
        return exp + " = " + Integer.toString(calc(first, operation, second));
    }

    public static Integer calc(
            Integer first, String operation, Integer second) {
        switch (operation) {
            case "+": return first + second;
            case "-": return first - second;
            case "*": return first * second;
            case "/": return first / second;

            default: return null;
        }
    }
}
