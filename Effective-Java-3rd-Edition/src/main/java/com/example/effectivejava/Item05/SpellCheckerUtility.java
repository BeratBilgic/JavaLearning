package com.example.effectivejava.Item05;

// Inappropriate use of static utility - inflexible & untestable!
public class SpellCheckerUtility {
    private static final Lexicon dictionary = new Lexicon("Türkçe");

    private SpellCheckerUtility() { // Noninstantiable
    }

    public static boolean isValid() {
        System.out.println("SpellCheckerUtility - " + dictionary.getLang());
        return true;
    }
}
