package javaBasic;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str,str1;
        int num ;
        double dnum;
        str1 = input.nextLine();
        System.out.println(str1);
        str = input.next();
        System.out.println(str);
        num = input.nextInt();
        System.out.println(num);
        dnum = input.nextDouble();
        System.out.println(dnum);
        input.close();
    }
}
