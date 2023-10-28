package com.example.effectivejava.Item10;

import com.example.effectivejava.Item10.violates_transitivity.ColorPoint;
import com.example.effectivejava.Item10.violates_transitivity.ColorPointInherit;
import com.example.effectivejava.Item10.violates_transitivity.Point;

import java.awt.*;
import java.io.*;

public class Item09 {
    public static void main(String[] args) throws IOException {
/*
The equals method implements an equivalence relation. It has these properties:
• Reflexive:For any non-null reference value x,x.equals(x) must return true.
• Symmetric:For any non-null reference values x and y,x.equals(y) must re-turn true if and only if y.equals(x) returns true.
• Transitive:For any non-null reference values x,y,z,if x.equals(y) returns true and y.equals(z) returns true,
then x.equals(z) must return true.
• Consistent: For any non-null reference values x and y, multiple invocations of x.equals(y) must consistently
return true or consistently return false, provided no information used in equals comparisons is modified.
• For any non-null reference value x,x.equals(null) must return false.
 */

        /*
        //Symmetric
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println(cis.equals(s)); //true
        System.out.println(s.equals(cis)); //false

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);
        System.out.println(list.contains(s)); //false

        CaseInsensitiveString2 cis2 = new CaseInsensitiveString2("turkish");
        String s2 = "turkish";
        System.out.println(cis2.equals(s2)); //false
        System.out.println(s2.equals(cis2)); //false
         */


        /*
        // Broken - violates symmetry!
        Point p = new Point(1, 2);
        ColorPointInherit cp = new ColorPointInherit(1, 2, Color.RED);
        System.out.println(p.equals(cp)); //true
        System.out.println(cp.equals(p)); //false

        // Broken - violates transitivity!
        ColorPointInherit p1 = new ColorPointInherit(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPointInherit p3 = new ColorPointInherit(1, 2, Color.BLUE);
        System.out.println(p1.equals(p2)); //true
        System.out.println(p2.equals(p3)); //true
        System.out.println(p1.equals(p3)); //false


        ColorPoint cp1 = new ColorPoint(1, 2, Color.RED);
        Point point = new Point(1, 2);
        ColorPoint cp3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.println(point.equals(cp1)); //false
        System.out.println(cp1.equals(point)); //false
        System.out.println(point.equals(cp3)); //false
        System.out.println(cp1.equals(cp3)); //false
         */

        TestClass tc1 = new TestClass(1, 2);
        TestClass tc2 = new TestClass(1, 2);
        System.out.println(tc1.equals(tc2)); //false

        TestClassOverride tco1 = new TestClassOverride(1,2);
        TestClassOverride tco2 = new TestClassOverride(1,2);
        System.out.println(tco1 == tco2); //false
        System.out.println(tco1.equals(tco2)); //true
        System.out.println(tco2.equals(tco1)); //true
        System.out.println(tco1.equals(null)); //false
    }
}
