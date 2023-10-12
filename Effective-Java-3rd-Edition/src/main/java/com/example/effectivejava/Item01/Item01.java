package com.example.effectivejava.Item01;

public class Item01 {
    public static void main(String[] args) {
        /*
        Item 1: Consider static factory methods instead of constructors

        One advantage of static factory methods is that, unlike constructors, they have names.
        A second advantage of static factory methods is that, unlike constructors,
            they are not required to create a new object each time they’re invoked.
        A third advantage of static factory methods is that, unlike constructors,
            they can return an object of any subtype of their return type.
        A fourth advantage of static factories is that the class of the returned
            object can vary from call to call as a function of the input parameters.
        A fifth advantage of static factories is that the class of the returned
            object need not exist when the class containing the method is written.


        The main limitation of providing only static factory methods is that classes without public or
            protected constructors cannot be subclassed.
        A second shortcoming of static factory methods is that they are hard for programmers to find.
         */
    }
}
