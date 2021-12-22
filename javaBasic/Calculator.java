package javaBasic;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1,num2,result;
        char op;
        System.out.println("enter the first number");
        num1 = scan.nextInt();
        System.out.println("enter the second number");
        num2 = scan.nextInt();
        System.out.println("enter an operator (+, -, *, /): ");
        op = scan.next().charAt(0);
        switch(op)
        {
            case '*' :
                result = num1*num2;
                System.out.println("result = "+ result);
                break;
            case '/' :
                result = num1/num2;
                System.out.println("result = "+ result);
                break;
            case '-' :
                result = num1-num2;
                System.out.println("result = "+ result);
                break;
            case '+':
                result = num1+num2;
                System.out.println("result = "+ result);
                break;
            default:
                System.out.println("Incorrect operation");
        }
        scan.close();
    }
}
