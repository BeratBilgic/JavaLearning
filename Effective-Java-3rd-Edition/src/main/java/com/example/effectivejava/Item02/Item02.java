package com.example.effectivejava.Item02;

import com.example.effectivejava.Item02.hierarchies.Calzone;
import com.example.effectivejava.Item02.hierarchies.NyPizza;

import static com.example.effectivejava.Item02.hierarchies.NyPizza.Size;
import static com.example.effectivejava.Item02.hierarchies.Pizza.Topping;

public class Item02 {
    public static void main(String[] args) {
        /*
        In summary, the Builder pattern is a good choice when designing classes
        whose constructors or static factories would have more than a handful of
        parameters, especially if many of the parameters are optional or of identical type.
        Client code is much easier to read and write with builders than with telescoping
        constructors, and builders are much safer than JavaBeans.
         */


        NutritionFacts1 cocaCola1 =
                new NutritionFacts1(8, 100, 0, 27);

        NutritionFacts2 cocaCola2 = new NutritionFacts2();
        cocaCola2.setServings(8);
        cocaCola2.setCalories(100);
        cocaCola2.setCarbohydrate(27);

        NutritionFacts3 cocaCola3 = new NutritionFacts3.Builder(240)
                .calories(100).carbohydrate(27).build();

        NyPizza pizza = new NyPizza.Builder(Size.SMALL)
                .addTopping(Topping.SAUSAGE).addTopping(Topping.ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(Topping.HAM).sauceInside().build();
    }
}
