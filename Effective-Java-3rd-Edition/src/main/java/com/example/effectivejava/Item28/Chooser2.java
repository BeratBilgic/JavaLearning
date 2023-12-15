package com.example.effectivejava.Item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// A first cut at making Chooser generic - won't compile
public class Chooser2<T> {
    /*
    private final T[] choiceArray;

    public Chooser2(Collection<T> choices) {
        choiceArray = choices.toArray(); // error: incompatible types: Object[] cannot be converted to T[]
    }


    // No big deal, you say, I’ll cast the Object array to a T array:
    //       choiceArray = (T[]) choices.toArray();

    // This gets rid of the error, but instead you get a warning:
    // Chooser.java:12: warning: Unchecked cast: 'java.lang.Object[]' to 'T[]'
    //       choiceArray = (T[]) choices.toArray();

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
     */
}
