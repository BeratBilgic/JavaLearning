package com.example.effectivejava.Item31;

import java.util.Arrays;
import java.util.List;

//Private helper method for wildcard capture (Page 145)
public class Swap {
    // Two possible declarations for the swap method
    // public static <E> void swap(List<E> list, int i, int j);
    // public static void swap(List<?> list, int i, int j);
    // As a rule, if a type parameter appears only once in a method declaration, replace it with a wildcard.
/*
    public static void swap(List<?> list, int i, int j) {
        list.set(i, list.set(j, list.get(i))); //incompatible types: java.lang.Object cannot be converted to capture#1 of ?
    }
 */

    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    // Private helper method for wildcard capture
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void main(String[] args) {
        // Swap the first and last argument and print the resulting list
        List<Integer> intList =  Arrays.asList(3, 1, 4, 1, 5, 9);;
        swap(intList, 0, intList.size() - 1);
        System.out.println(intList);
    }
}
