package javaMethod;

public class MethodTest1 {
    public static void main(String[] args) {

        System.out.println(power(2,4));
        System.out.println(add(9,9));
        System.out.println(add(9,9,9));
        System.out.println(add(9,1.0,9));
        System.out.println(add(9,9,2.0));
    }
    static int power (int num , int num1)
    {
        int result = 1;
        for (int i = 0 ; i < num1 ; i++ )
        {
            result*=num;
        }
        return result;
    }
    static int add (int num1 , int num2)
    {
        System.out.println("1.method");
        return num1 + num2;
    }
    static int add (int num1 , int num2, int num3)
    {
        System.out.println("2.method");
        return num1 + num2 + num3;
    }
    static double add (int num1 , double num2, int num3)
    {
        System.out.println("3.method");
        return num1 + num2 + num3;
    }
    static double add (int num1 , int num2, double num3)
    {
        System.out.println("4.method");
        return num1 + num2 + num3;
    }
}