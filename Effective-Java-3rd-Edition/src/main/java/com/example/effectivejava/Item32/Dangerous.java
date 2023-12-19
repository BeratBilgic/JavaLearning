package com.example.effectivejava.Item32;

import java.util.List;

public class Dangerous {
    // Mixing generics and varargs can violate type safety!
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList; // Heap pollution
        String s = stringLists[0].get(0); // ClassCastException
    }

    public static void main(String[] args)
    {
        //it is unsafe to store a value in a generic varargs array parameter.
        dangerous(List.of("test"));
    }
}
