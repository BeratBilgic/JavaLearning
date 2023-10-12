package com.example.effectivejava.Item06;

import java.util.regex.Pattern;

public class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    // Reusing expensive object for improved performance
    public static boolean isRomanNumeral1(String s) {
        return ROMAN.matcher(s).matches();
    }

    // Performance can be greatly improved!
    public static boolean isRomanNumeral2(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }
}
