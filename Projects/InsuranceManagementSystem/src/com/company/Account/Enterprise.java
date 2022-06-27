package com.company.Account;

public class Enterprise extends Account{
    public Enterprise(User user) {
        super(user);
    }

    @Override
    public void addInsurancePolicy() {
        System.out.println("Enterprise Insurance Policy");
    }
}
