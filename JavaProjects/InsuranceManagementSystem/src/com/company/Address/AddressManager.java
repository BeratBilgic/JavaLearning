package com.company.Address;

import java.util.ArrayList;

public class AddressManager {

    public static void addAddress(ArrayList<Address> addressList, Address address){
        addressList.add(address);
    }

    public static void removeAddress(ArrayList<Address> addressList, Address address){
        addressList.remove(address);
    }
}
