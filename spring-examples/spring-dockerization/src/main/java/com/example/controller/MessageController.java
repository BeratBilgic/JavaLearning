package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @PostMapping
    public ResponseEntity<String> message(){
        System.out.println("MessageController - Hello from Docker!");

        return ResponseEntity.ok("MessageController - Hello from Docker!");
    }
}
