package com.example.effectivejava.Item05;

import java.util.Objects;

// Dependency injection provides flexibility and testability
public class SpellCheckerDependencyInjection {
    private final Lexicon dictionary;

    public SpellCheckerDependencyInjection(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid() {
        System.out.println("SpellCheckerDependencyInjection - " + dictionary.getLang());
        return true;
    }

}
