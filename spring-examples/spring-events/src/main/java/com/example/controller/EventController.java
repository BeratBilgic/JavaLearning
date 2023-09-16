package com.example.controller;

import com.example.dto.CustomEventRequest;
import com.example.event.publisher.CustomEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/event")
public class EventController {

    private final CustomEventPublisher customEventPublisher;

    public EventController(CustomEventPublisher customEventPublisher) {
        this.customEventPublisher = customEventPublisher;
    }

    @PostMapping
    public String bookHotel(@RequestBody CustomEventRequest customEventRequest){
        customEventPublisher.publishCustomEvent(customEventRequest);
        String message = LocalDateTime.now() + " The user's request has been processed. :" + customEventRequest;
        System.out.println(message);
        return message;
    }
}
