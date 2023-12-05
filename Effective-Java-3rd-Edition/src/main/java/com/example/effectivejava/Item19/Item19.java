package com.example.effectivejava.Item19;

public class Item19 {
    public static void main(String[] args){
        //Constructors must not invoke overridable methods
        Sub sub = new Sub(); //null
        sub.overrideMe(); //2023-12-05T19:43:10.975625Z
    }

    /*
    The best solution to this problem is to prohibit subclassing in classes that are not designed and
    documented to be safely subclassed. There are two ways to prohibit subclassing.
    The easier of the two is to declare the class final. The alternative is to make all the constructors private or
    package-private and to add public static factories in place of the constructors. This alternative,
    which provides the flexibility to use subclasses internally, is discussed in Item 17. Either approach is acceptable.
     */
}
