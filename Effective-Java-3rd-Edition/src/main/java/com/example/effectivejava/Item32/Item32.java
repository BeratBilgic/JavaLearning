package com.example.effectivejava.Item32;

public class Item32 {
    public static void main(String[] args) {
        sumTest();
        sumTest(1);
        sumTest(3,2,3);
    }

    static void sumTest(int ...v) { // varargs
        System.out.print(v.length + " ");
        if (v.length > 0)
            System.out.print(v[0]);

        System.out.println();
    }

}
