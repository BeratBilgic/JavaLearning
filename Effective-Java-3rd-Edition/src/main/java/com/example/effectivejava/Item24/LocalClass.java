package com.example.effectivejava.Item24;

public class LocalClass {

    public void printSomething(){
        class LocalClassInner{

        }

        LocalClassInner localClassInner = new LocalClassInner();

        System.out.println(localClassInner.getClass());
    }
}
