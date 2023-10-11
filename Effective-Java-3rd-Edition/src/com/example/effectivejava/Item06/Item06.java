package com.example.effectivejava.Item06;

import java.util.ArrayList;

public class Item06 {
    public static void main(String[] args) {
        String s1 = new String("bikini"); // DON'T DO THIS!
        String s2 = "bikini";
        String s3 = "bikini";

        System.out.println(s1 == s2);   //false
        System.out.println(s2 == s3);   //true




        // The lesson is clear: prefer primitives to boxed primitives, and watch out for unintentional autoboxing.
        long startTime1 = System.currentTimeMillis();
        sum1();
        long endTime1   = System.currentTimeMillis();
        long totalTime1 = endTime1 - startTime1;
        System.out.println("Wrapper class - " + totalTime1); // 2631

        long startTime2 = System.currentTimeMillis();
        sum2();
        long endTime2   = System.currentTimeMillis();
        long totalTime2 = endTime2 - startTime2;
        System.out.println("primitive - " + totalTime2); // 689




        ArrayList<Integer> integer = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            integer.add(i); // i = Integer.valueOf(i);
        }

        ArrayList<Integer> li = new ArrayList<>();
        int sum = 0;
        for (Integer i : li) {
            if (i % 2 == 0) // i.intValue()
                sum += i;
        }
    }

    private static long sum1() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    private static long sum2() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }
}
