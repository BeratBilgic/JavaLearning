package com.example.effectivejava.Item31;

import java.util.Arrays;
import java.util.List;

public class RecursiveTypeBound {
    public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
        if (list.isEmpty())
            throw new IllegalArgumentException("Empty list");

        E result = null;
        for (E e : list)
            if (result == null || e.compareTo(result) > 0)
                result = e;

        return result;
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(3, 1, 4, 1, 5, 9);;
        System.out.println(max(intList));

    }
}
