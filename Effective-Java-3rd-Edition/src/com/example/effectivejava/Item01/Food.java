package com.example.effectivejava.Item01;

public class Food {
    String name;

    public static Food coldFood(String name){
        return new IceCream();
    }

    public static Food warmFood(String name){
        return new Pizza();
    }
}
