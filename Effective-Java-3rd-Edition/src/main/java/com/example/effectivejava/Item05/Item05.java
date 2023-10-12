package com.example.effectivejava.Item05;

public class Item05 {
    public static void main(String[] args) {
        SpellCheckerUtility.isValid();

        SpellCheckerSingleton.INSTANCE.isValid();

        final Lexicon dictionary = new Lexicon("Türkçe");
        SpellCheckerDependencyInjection spellCheckerDI = new SpellCheckerDependencyInjection(dictionary);
        spellCheckerDI.isValid();

        final Lexicon dictionary2 = new Lexicon("İngilizce");
        SpellCheckerDependencyInjection spellCheckerDI2 = new SpellCheckerDependencyInjection(dictionary2);
        spellCheckerDI2.isValid();
    }
}
