package TryCatchThrow;

import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = 0, b = 0;
        int[] arr = new int[3];
        try {
            b = scan.nextInt();
            arr[4] = 12;  //  ArrayIndexOutOfBoundsException
            a = a/0;  //  ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Zero Error");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array eror");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            System.out.println("Error");
        }finally{
            System.out.println("finally");
        }
        System.out.println(a + b + arr[4]);
        scan.close();
    }
}
