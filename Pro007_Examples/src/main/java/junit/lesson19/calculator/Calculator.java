package junit.lesson19.calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalcCPU.parseExpression(scanner.nextLine());
        System.out.println(CalcCPU.result());
    }
}
