package com.example.effectivejava.Item10.violates_transitivity;

import java.awt.*;

public class ColorPointInherit extends Point{
    private final Color color;

    public ColorPointInherit(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    /*
    // Broken - violates symmetry!
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPointInherit))
            return false;
        return super.equals(o) && ((ColorPointInherit) o).color == color;
    }
     */

    // Broken - violates transitivity!
    @Override public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        // If o is a normal Point, do a color-blind comparison
        if (!(o instanceof ColorPointInherit))
            return o.equals(this);
        // o is a ColorPoint; do a full comparison
        return super.equals(o) && ((ColorPointInherit) o).color == color;
    }
}
