package com.example.effectivejava.Item02;

// Telescoping constructor pattern - does not scale well!
/*  the telescoping constructor pattern works, but it is hard to write client code when
there are many parameters, and harder still to read it
 */
public class NutritionFacts1 {
    private final int servings;     // required
    private final int calories;     // optional
    private final int fat;          // optional
    private final int carbohydrate; // optional

    public NutritionFacts1(int servings) {
        this(servings, 0);
    }

    public NutritionFacts1(int servings, int calories) {
        this(servings, calories, 0);
    }

    public NutritionFacts1(int servings, int calories, int fat) {
        this(servings, calories, fat, 0);
    }

    public NutritionFacts1(int servings, int calories, int fat, int carbohydrate) {
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
    }
}
