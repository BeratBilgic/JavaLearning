package com.example.effectivejava.Item24;

public class Item24 {
    public static void main(String[] args) {
        // Static Nested
        StaticNested.StaticNestedClass staticNestedClass = new StaticNested.StaticNestedClass();

        // Non Static Nested
        // Open for a memory leak
        NonStaticNested nonStaticNested = new NonStaticNested();
        NonStaticNested.NonStaticNestedClass staticNestedClass1 = nonStaticNested.new NonStaticNestedClass();

        // Local classes
        LocalClass lc = new LocalClass();

        //Anonymous classes
        AnonymousClass anonymousClass = new AnonymousClass(){
            @Override
            public void printMe() {
                System.out.println("Anonymous class");
            }
        };
        anonymousClass.printMe();//Anonymous class

        AnonymousClassInterface anonymousClassInterface = new AnonymousClassInterface() {
            @Override
            public void printMe() {
                System.out.println("Anonymous class");
            }
        };
        anonymousClassInterface.printMe();//Anonymous class


        /*
        To recap, there are four different kinds of nested classes, and each has its place.
        If a nested class needs to be visible outside of a single method or is too long to fit
        comfortably inside a method, use a member class. If each instance of a member class needs
        a reference to its enclosing instance, make it nonstatic; otherwise, make it static.
        Assuming the class belongs inside a method, if you need to create instances from
        only one location and there is a preexisting type that characterizes the class,
        make it an anonymous class; otherwise, make it a local class.
         */
    }
}
