package com.company.Account;

import com.company.Address.Address;
import com.company.Address.BusinessAddress;
import com.company.Address.HomeAddress;
import com.company.Exception.InvalidAuthenticationException;

import java.util.ArrayList;
import java.util.TreeSet;

public class AccountManager {
        TreeSet<Account> accountList = new TreeSet<>();

        public AccountManager() {
                ArrayList<Address> addressList = new ArrayList<>();
                Address homeAddress = new HomeAddress("Home Address");
                Address businessAddressAddress = new BusinessAddress("Business Address");
                addressList.add(homeAddress);
                addressList.add(businessAddressAddress);

                Account account1 = new Individual(new User("name1","surname1","user1email",
                        "1111","occupation1",31,addressList));
                Account account2 = new Enterprise(new User("name2","surname2","user2email",
                        "2222","occupation2",32,addressList));
                Account account3 = new Individual(new User("name3","surname3","user3email",
                        "3333","occupation3",33,addressList));
                Account account4 = new Enterprise(new User("name4","surname4","user4email",
                        "4444","occupation4",34,addressList));
                Account account5 = new Individual(new User("name5","surname5","user5email",
                        "5555","occupation5",35,addressList));

                accountList.add(account1);
                accountList.add(account2);
                accountList.add(account3);
                accountList.add(account4);
                accountList.add(account5);

        }

        public Account login(String email, String password){
                try {
                        for (Account a: accountList){
                                if (a.getUser().getEmail().equals(email) && a.getUser().getPassword().equals(password)){
                                        a.loginStatus(email,password);
                                        return a;
                                }
                        }
                        throw new InvalidAuthenticationException("Access Denied - Email or password is incorrect");
                }catch (InvalidAuthenticationException e){
                        System.out.println(e.getMessage());
                }

                return null;
        }
}
