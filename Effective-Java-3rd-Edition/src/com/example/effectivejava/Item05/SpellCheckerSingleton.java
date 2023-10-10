package com.example.effectivejava.Item05;

// Inappropriate use of singleton - inflexible & untestable!
public class SpellCheckerSingleton {
    private static final Lexicon dictionary = new Lexicon("Türkçe");

    public static SpellCheckerSingleton INSTANCE = new SpellCheckerSingleton();

    private SpellCheckerSingleton() {
    }

    public boolean isValid() {
        System.out.println("SpellCheckerSingleton - " + dictionary.getLang());
        return true;
    }

}
