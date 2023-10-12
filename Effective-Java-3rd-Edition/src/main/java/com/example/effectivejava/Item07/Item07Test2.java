package com.example.effectivejava.Item07;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@RestController()
public class Item07Test2 {
    private static Random random = new Random();

    @GetMapping("item7test2")
    public void hello2() {
        ArrayList<Double> list = new ArrayList<Double>(1000000);
        for (int i = 0; i < 1000000; i++)
        {
            list.add(random.nextDouble());
        }
    }
}
