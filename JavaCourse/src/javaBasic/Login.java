package javaBasic;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username,passworld;
        System.out.println("enter username");
        username = scan.next();
        System.out.println("enter your password");
        passworld = scan.next();
        if(username.equals("java") && passworld.equals("1234"))
        {
            System.out.println("Signed in");
        }
        else
        {
            System.out.println("sign in failed");
        }
        scan.close();
    }
}
