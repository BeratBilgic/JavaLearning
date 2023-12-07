package com.example.effectivejava.Item21;

public interface TestInterface {

    void printMe();

    //The implemented class is not obligated to override, and it allows us to write the body inside the function.
    default void printDefault(){
        System.out.println("default");
    }
}

