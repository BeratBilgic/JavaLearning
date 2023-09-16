package com.example.event.listener;

import com.example.event.CustomEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        try {
            Thread.sleep(3000L);
            System.out.println(LocalDateTime.now() + " EventListener -> " + event.getSource().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
