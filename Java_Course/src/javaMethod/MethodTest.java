package javaMethod;

public class MethodTest {
    public static void main(String[] args) {
        hello();
        power(2,4);
    }
    static void hello()
    {
        System.out.println("HELLO");
    }
    static void power (int num , int num1)
    {
        int result = 1;
        for (int i = 0 ; i < num1 ; i++ )
        {
            result*=num;
        }
        System.out.println("result is " + result);
    }
}
