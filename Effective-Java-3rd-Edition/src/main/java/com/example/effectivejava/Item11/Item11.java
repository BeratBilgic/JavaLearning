package com.example.effectivejava.Item11;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Item11 {
    public static void main(String[] args) throws IOException {
        TestClass tc1 = new TestClass(1,2);
        TestClass tc2 = new TestClass(1,2);
        System.out.println(tc1.hashCode());//1452126962
        System.out.println(tc2.hashCode());//931919113

        TestClassOverride tco1 = new TestClassOverride(1,2);
        TestClassOverride tco2 = new TestClassOverride(1,2);
        System.out.println(tco1.hashCode());//33
        System.out.println(tco2.hashCode());//33


        Map<TestClass, String> mtc = new HashMap<>();
        mtc.put(new TestClass(1, 2), "first");
        System.out.println(mtc.get(new TestClass(1, 2)));//null

        Map<TestClassOverride, String> mtco = new HashMap<>();
        mtco.put(new TestClassOverride(1, 2), "first");
		System.out.println(mtco.get(new TestClassOverride(1, 2)));//first
    }
}
