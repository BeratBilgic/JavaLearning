package com.example.effectivejava.Item26;

import java.util.*;

public class Item26 {
    public static void main(String[] args) {
        /*
        // Raw collection type - don't do this!
        // My ints collection. Contains only Integer instances.
        final Collection ints = new ArrayList();

        // Erroneous insertion of String into ints collection
        ints.add(new String()); // Emits "unchecked call" warning

        // Raw iterator type - don't do this!
        for (Iterator i = ints.iterator(); i.hasNext();){
            Integer stamp = (Integer) i.next(); // Throws ClassCastException
        }



        // Parameterized collection type - typesafe
        final Collection<Integer> ints2 = new ArrayList<Integer>();
        ints2.add(new String()); // error: incompatible types: String cannot be converted to Integer
         */









        // Fails at runtime - unsafeAdd method uses a raw type (List)!
        List<String> strings = new ArrayList<>();
        unsafeAdd1(strings, Integer.valueOf(42));
        String s = strings.get(0); // Has compiler-generated cast // Throws ClassCastException

        //unsafeAdd2(strings, Integer.valueOf(42)); //error: incompatible types: List<String> cannot be converted to List<Object>
    }

    private static void unsafeAdd1(List list, Object o) {
        list.add(o);
    }

    private static void unsafeAdd2(List<Object> list, Object o) {
        list.add(o);
    }








    // Use of raw type for unknown element type - don't do this!
    static int numElementsInCommon1(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }

    // Uses unbounded wildcard type - typesafe and flexible
    static int numElementsInCommon2(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }







    // Legitimate use of raw type - instanceof operator
    static Set<?> convertSet(Object o){
        if (o instanceof Set) {     // Raw type
            Set<?> s = (Set<?>) o;  // Wildcard type
            return s;
        }

        return null;
    }
}
