package com.example.effectivejava.Item04;

// Non-instantiable utility class
public class UtilityClass {
    public static final String string = "String";

    // Suppress default constructor for noninstantiability
    /*
    Because the explicit constructor is private, it is inaccessible outside the class.
    The AssertionError isn’t strictly required,
    but it provides insurance in case the constructor is accidentally invoked from within the class
     */
    private UtilityClass() {
        throw new AssertionError();
    }

    public static void log(){
        System.out.println("UtilityClass log");
    }
}
