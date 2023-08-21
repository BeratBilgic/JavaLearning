package com.example.consumer;

import com.example.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @RabbitListener(queues = {"${sr.rabbit.queue.name}"})
    public void consume(Notification notification) {
        System.out.println("Message received..");
        System.out.println(notification.toString());
    }
}
