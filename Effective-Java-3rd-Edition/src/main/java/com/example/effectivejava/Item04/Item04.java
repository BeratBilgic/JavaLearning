package com.example.effectivejava.Item04;

public class Item04 {
    public static void main(String[] args) {
        System.out.println(UtilityClass.string);
        UtilityClass.log();

        /*
        Attempting to enforce noninstantiability by making a class abstract does not work.
        The class can be subclassed and the subclass instantiated. Furthermore,
        it misleads the user into thinking the class was designed for inheritance (Item 19).
        There is, however, a simple idiom to ensure noninstantiability. A default constructor is
        generated only if a class contains no explicit constructors, so a class can be made
        noninstantiable by including a private constructor:
         */
    }
}
