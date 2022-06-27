package com.company.Account;

import com.company.Address.Address;
import com.company.Insurance.Insurance;
import com.company.Exception.InvalidAuthenticationException;

import java.util.ArrayList;
import java.util.Objects;

import static com.company.Address.AddressManager.addAddress;
import static com.company.Address.AddressManager.removeAddress;

public abstract class Account implements Comparable<Account>{
    private User user;
    private ArrayList<Insurance> insuranceList;
    enum AuthenticationStatus{
        SUCCESS,
        FAIL
    }
    private AuthenticationStatus status;

    public Account(User user) {
        this.user = user;
    }

    public void loginStatus(String email, String password) throws InvalidAuthenticationException {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            status = AuthenticationStatus.SUCCESS;
            return;
        }
        status = AuthenticationStatus.FAIL;
        throw new InvalidAuthenticationException("Access Denied - Email or password is incorrect");
    }

    public final void showUserInfo(){
        System.out.println("\n---User Information---\nName :" + user.getName() + "\nSurname : " + user.getSurname() + "\nEmail : "
                + user.getEmail() + "\nOccupation : " + user.getOccupation() + "\nAge : " + user.getAge()
                + "\nLast login date : " + user.getLastLoginDate());

        printAddressList(user.getAddressList());
        printInsuranceList(insuranceList);

        System.out.println("----------------------");
    }

    public void printAddressList(ArrayList<Address> addressList){
        System.out.println("Address List : ");
        for (Address address : user.getAddressList()){
            System.out.println("-" + address.getAddress());
        }
    }

    public void printInsuranceList(ArrayList<Insurance> insuranceList){
        if (insuranceList != null){
            System.out.println("Insurance List : ");
            for (Insurance insurance : insuranceList){
                System.out.println("-" + insurance.getName() + "\t" + insurance.getPrice() + "\t"
                        + insurance.getStartDateInsurance() + "\t" + insurance.getEndDateInsurance());
            }
        }
    }

        @Override
    public int compareTo(Account o) {
        return this.hashCode() - o.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(user, account.user);
    }

    @Override
    public int hashCode() {
        int hash = 31;
        return hash * (user == null ? 1 : user.hashCode());
    }

    public void addAddressList(Address address){
        addAddress(user.getAddressList(), address);
    }

    public void removeAddressList(Address address){
        removeAddress(user.getAddressList(), address);
    }

    public void addInsuranceList(Insurance insurance){
        insuranceList.add(insurance);
    }

    public void removeInsuranceList(Insurance insurance){
        insuranceList.remove(insurance);
    }

    public abstract void addInsurancePolicy();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(ArrayList<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }

    public AuthenticationStatus getStatus() {
        return status;
    }
}
