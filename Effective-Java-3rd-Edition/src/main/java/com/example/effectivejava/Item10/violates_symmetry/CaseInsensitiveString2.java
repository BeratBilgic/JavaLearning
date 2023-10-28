package com.example.effectivejava.Item10.violates_symmetry;

import java.util.Objects;

public class CaseInsensitiveString2 {
    private final String s;

    public CaseInsensitiveString2(String s) {
        this.s = Objects.requireNonNull(s);
    }

    /*Once you’ve violated the equals contract,
    you simply don’t know how other objects will behave when confronted with your object.
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString2 &&
                ((CaseInsensitiveString2) o).s.equalsIgnoreCase(s);
    }
}
