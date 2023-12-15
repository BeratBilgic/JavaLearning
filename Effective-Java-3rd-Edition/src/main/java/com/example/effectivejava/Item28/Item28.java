package com.example.effectivejava.Item28;

import java.util.ArrayList;
import java.util.List;

public class Item28 {
    public static void main(String[] args) {
        /*
        // Fails at runtime!
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in"; // Throws ArrayStoreException
         */

        /*
        // Won't compile!
        List<Object> ol = new ArrayList<Long>(); // Incompatible types ol.add("I don't fit in");
         */

        /*
        // Why generic array creation is illegal - won't compile!
        List<String>[] stringLists = new List<String>[1];
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList;
        String s = stringLists[0].get(0);
         */



    }
}
