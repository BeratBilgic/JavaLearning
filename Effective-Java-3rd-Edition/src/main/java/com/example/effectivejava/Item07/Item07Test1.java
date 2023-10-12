package com.example.effectivejava.Item07;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@RestController()
public class Item07Test1 {
    private static Random random = new Random();
    public static final ArrayList<Double> list = new ArrayList<Double>(1000000);

    @GetMapping("/item7test1")
    public void hello1() {
        for (int i = 0; i < 1000000; i++)
        {
            list.add(random.nextDouble());
        }
    }
}
