package com.example.effectivejava.Item02;

// JavaBeans Pattern - allows inconsistency, mandates mutability
// a JavaBean may be in an inconsistent state partway through its construction
// the JavaBeans pattern precludes the possibility of making a class immutable
public class NutritionFacts2 {
    private int servings;     // required
    private int calories;     // optional
    private int fat;          // optional
    private int carbohydrate; // optional

    public NutritionFacts2() {
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}
