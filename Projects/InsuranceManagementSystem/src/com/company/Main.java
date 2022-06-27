package com.company;

import com.company.Account.Account;
import com.company.Exception.InvalidAuthenticationException;

public class Main {

    public static void main(String[] args) throws InvalidAuthenticationException {

	    LoginPanel loginPanel = new LoginPanel();
        Account account = loginPanel.runLogin();

        if (account != null){
            Test test = new Test();
            test.runTest(account);
        }
    }
}
