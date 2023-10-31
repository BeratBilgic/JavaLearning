package com.example.effectivejava.Item13;

public class Item13 {
    public static void main(String[] args){
        /*
        // Shallow Copy
        Stack st = new Stack();
        Stack st1 = st;

        System.out.println(st == st1); //true


        // Deep Copy
        Stack stc = new Stack();
        stc.stackName = "stack";

        Stack stc2 = new Stack();
        stc2.stackName = stc.stackName;
         */

        Stack stack = new Stack();

        String[] numbers = {"1", "2", "3", "4"};
        for (String arg : numbers)
            stack.push(arg);

        Stack copy = stack.clone();


        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");

        System.out.println();

        while (!copy.isEmpty())
            System.out.print(copy.pop() + " ");

        /*
        ----RESULT----
        without override
        4 3 2 1
        null null null null

        with override
        4 3 2 1
        4 3 2 1
         */
    }
}
