package com.example.effectivejava.Item10;

import java.util.Objects;

public class TestClassOverride {
    private int x,y;

    public TestClassOverride(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Always override hash Code when you override equals
    @Override
    public boolean equals(Object o) {
        //Use the == operator to check if the argument is a reference to this object.
        if (this == o)
            return true;

        //Use the instanceof operator to check if the argument has the correct type.
        //"null instanceof [type]" also returns false
        if (!(o instanceof TestClassOverride))
            return false;

        //Cast the argument to the correct type.
        TestClassOverride that = (TestClassOverride) o;

        //For each “significant” field in the class,
        //check if that field of the argument matches the corresponding field of this object.
        return x == that.x && y == that.y;
    }
}
