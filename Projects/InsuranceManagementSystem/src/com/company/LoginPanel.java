package com.company;

import com.company.Account.Account;
import com.company.Account.AccountManager;
import com.company.Address.HomeAddress;
import com.company.Exception.InvalidAuthenticationException;

import java.util.Scanner;

public class LoginPanel {
    public Account runLogin() throws InvalidAuthenticationException {
        AccountManager acctMan = new AccountManager();
        Scanner scan = new Scanner(System.in);
        String email, password;

        System.out.println("--- INSURANCE MANAGEMENT SYSTEM LOGIN PANEL ---");
        System.out.print("Email : ");
        email = scan.nextLine();
        System.out.print("Pasword : ");
        password = scan.nextLine();

        Account account = acctMan.login(email, password);

        if (account != null) {
            account.showUserInfo();
            return account;
        }
        return null;
    }
}
