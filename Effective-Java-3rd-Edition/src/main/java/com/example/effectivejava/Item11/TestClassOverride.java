package com.example.effectivejava.Item11;

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

    @Override
    public int hashCode() {
        int result = Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(y);
        return result;
    }

    /*
    // One-line hashCode method - mediocre performance
    @Override
	public int hashCode() {
	    return Objects.hash(x, y);
	}
     */

    /*
   // hashCode method with lazily initialized cached hash code
   private int hashCode; // Automatically initialized to 0

   @Override
   public int hashCode() {
       int result = hashCode;
       if (result == 0) {
           result = Integer.hashCode(x);
           result = 31 * result + Integer.hashCode(y);
           hashCode = result;
        }
       return result;
   }
    */
}
