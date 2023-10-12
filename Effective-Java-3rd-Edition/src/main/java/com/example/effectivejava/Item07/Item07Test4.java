package com.example.effectivejava.Item07;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class Item07Test4 {

    @GetMapping("item7test4")
    public void hello4() {
        Stack stack = new Stack();

        for (int i = 1; i < 10000000; i++)
        {
            stack.push(i);
        }

        for (int i = 1; i < 10000000; i++)
        {
            stack.popAndClean();
        }
    }
}
