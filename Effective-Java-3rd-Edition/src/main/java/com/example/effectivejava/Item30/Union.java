package com.example.effectivejava.Item30;

import java.util.HashSet;
import java.util.Set;

public class Union {
    // Uses raw types - unacceptable! (Item 26)
    public static Set unionBad(Set s1, Set s2) {
        Set result = new HashSet(s1); // warning: [unchecked] unchecked call to HashSet(Collection<? extends E>) as a member of raw type HashSet
        result.addAll(s2); // warning: [unchecked] unchecked call to addAll(Collection<? extends E>) as a member of raw type Set
        return result;
    }

    // Generic method
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // Simple program to exercise generic method
    public static void main(String[] args) {
        Set<String> guys = Set.of("Tom", "Dick", "Harry");
        Set<String> stooges = Set.of("Larry", "Moe", "Curly");
        Set<String> aflCio = union(guys, stooges);
        System.out.println(aflCio);
    }
}
