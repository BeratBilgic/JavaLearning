package com.company.Account;

public class Individual extends Account{
    public Individual(User user) {
        super(user);
    }

    @Override
    public void addInsurancePolicy() {
        System.out.println("Individual Insurance Policy");
    }
}
