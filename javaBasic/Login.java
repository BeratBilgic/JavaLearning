package javaBasic;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username,passworld;
        System.out.println("kullanici adini giriniz");
        username = scan.next();
        System.out.println("şifrenizi giriniz");
        passworld = scan.next();
        if(username.equals("java") && passworld.equals("1234"))
        {
            System.out.println("Giriş yapildi");
        }
        else
        {
            System.out.println("giriş başarisiz");
        }
        scan.close();
    }
}
