package com.example.event.publisher;

import com.example.dto.CustomEventRequest;
import com.example.event.CustomEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public CustomEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishCustomEvent(CustomEventRequest customEventRequest) {
        System.out.println(LocalDateTime.now() + " Publishing custom event.");
        CustomEvent customEvent = new CustomEvent(customEventRequest);
        applicationEventPublisher.publishEvent(customEvent);
    }
}