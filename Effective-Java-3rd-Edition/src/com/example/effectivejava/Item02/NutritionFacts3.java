package com.example.effectivejava.Item02;

// Builder Pattern
public class NutritionFacts3 {
    private final int servings;     // required
    private final int calories;     // optional
    private final int fat;          // optional
    private final int carbohydrate; // optional

    public static class Builder{
        // Required parameters
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;

        public Builder(int servings) {
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }
        public Builder fat(int val) {
            fat = val;
            return this;
        }
        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts3 build() {
            return new NutritionFacts3(this);
        }
    }

    public NutritionFacts3(Builder builder) {
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        carbohydrate = builder.carbohydrate;
    }
}
