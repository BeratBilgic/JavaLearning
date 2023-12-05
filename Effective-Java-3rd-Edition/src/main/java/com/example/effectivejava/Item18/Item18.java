package com.example.effectivejava.Item18;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Item18 {
    public static void main(String[] args){
        InstrumentedHashSet<String> si = new InstrumentedHashSet<>();
        si.addAll(List.of("Snap", "Crackle", "Pop"));
        System.out.println(si.getAddCount()); // 6

        Set<String> set = new HashSet<>();
        InstrumentedSet<String> sc = new InstrumentedSet<>(set);
        sc.addAll(List.of("Snap", "Crackle", "Pop"));
        System.out.println(sc.getAddCount()); // 3
    }
}
