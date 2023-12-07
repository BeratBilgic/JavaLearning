package com.example.effectivejava.Item21;

public class TestClass implements TestInterface {

    @Override
    public void printMe() {
        System.out.println(TestClass.class);
    }
}
