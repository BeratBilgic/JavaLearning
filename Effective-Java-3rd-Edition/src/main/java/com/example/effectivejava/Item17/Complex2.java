package com.example.effectivejava.Item17;

// Immutable class with static factories instead of constructors
public class Complex2 {
    private final double re;
    private final double im;

    private Complex2(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) { return new Complex(re, im);
    }

    // Remainder unchanged
}
