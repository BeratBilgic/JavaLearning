package com.example.kafka.controller;

import com.example.kafka.dto.KafkaMessage;
import com.example.kafka.kafka.KafkaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private final KafkaService kafkaService;

    public KafkaController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping
    public String sendMessage(@RequestBody KafkaMessage message) {
        kafkaService.sendMessage(message);
        return "message sent";
    }
}
