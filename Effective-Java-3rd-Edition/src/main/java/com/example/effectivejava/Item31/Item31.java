package com.example.effectivejava.Item31;

import java.util.Arrays;
import java.util.Collection;

public class Item31 {
    public static void main(String[] args) {
        //PECS stands for producer-extends, consumer-super.

        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);;
        //numberStack.pushAllBad(integers); //incompatible types: java.lang.Iterable<java.lang.Integer> cannot be converted to java.lang.Iterable<java.lang.Number>
        numberStack.pushAll(integers);

        Stack<Number> numberStack2 = new Stack<Number>();
        Collection<Object> objects = Arrays.asList(3, 1, 4, 1, 5, 9); ;
        //numberStack2.popAllBad(objects); //incompatible types: java.util.Collection<java.lang.Object> cannot be converted to java.util.Collection<java.lang.Number>
        numberStack2.popAll(objects);

    }
}
