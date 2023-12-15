package com.example.effectivejava.Item29;

public class Item29 {
    public static void main(String[] args) {
        // Little program to exercise our generic Stack
        String[] test = {"one", "two", "three"};

        StackGeneric1<String> stack = new StackGeneric1<>();
        for (String arg : test)
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());

        StackGeneric2<String> stack2 = new StackGeneric2<>();
        for (String arg : test)
            stack2.push(arg);
        while (!stack2.isEmpty())
            System.out.println(stack2.pop().toUpperCase());
    }
}
