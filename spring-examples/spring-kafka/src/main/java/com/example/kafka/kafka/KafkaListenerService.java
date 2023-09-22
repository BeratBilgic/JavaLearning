package com.example.kafka.kafka;

import com.example.kafka.dto.KafkaMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {

    @KafkaListener(
            topics = "${spring.kafka.topic}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(KafkaMessage message){
        System.out.println("Message received.. MessageID : " + message.getId()
                + " Message: " + message.getMessage()
                + " Date : " + message.getMessageDate());
    }
}
