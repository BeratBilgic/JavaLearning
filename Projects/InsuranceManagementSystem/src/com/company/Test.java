package com.company;

import com.company.Account.Account;
import com.company.Address.HomeAddress;
import com.company.Insurance.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Test {
    public void runTest(Account account){
        System.out.println("\n******************************************");
        System.out.println("*****************TEST*********************");
        System.out.println("******************************************");
        account.removeAddressList(account.getUser().getAddressList().get(0));
        account.addAddressList(new HomeAddress("New Home Address"));
        account.addInsurancePolicy();

        ArrayList<Insurance> insuranceList = new ArrayList<>();
        insuranceList.add(new CarInsurance(1500, LocalDate.now(),LocalDate.now()));
        insuranceList.add(new HealthInsurance(500, LocalDate.now(),LocalDate.now()));
        insuranceList.add(new ResidenceInsurance(2000, LocalDate.now(),LocalDate.now()));
        insuranceList.add(new TravelInsurance(1000, LocalDate.of(2022,03,30), LocalDate.now()));
        account.setInsuranceList(insuranceList);

        account.printInsuranceList(account.getInsuranceList());

        for (int i = 0; i < insuranceList.size(); i++) {
            insuranceList.get(i).calculate();
        }

        account.removeInsuranceList(account.getInsuranceList().get(0));
        account.removeInsuranceList(account.getInsuranceList().get(0));
        account.addInsuranceList(new HealthInsurance(8000, LocalDate.now(),LocalDate.now()));

        account.showUserInfo();
        System.out.println("******************************************");
        System.out.println("******************************************\n");
    }
}
