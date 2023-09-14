package com.example.controller;

import com.example.dto.Message;
import com.example.dto.OutputMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@CrossOrigin
public class MessageHandlingController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(final Message message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }

    /*
    @MessageMapping("/chat")
    public void chatEndpoint(@Payload Message message) {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        messagingTemplate.convertAndSend("/topic/messages", new OutputMessage(message.getFrom(), message.getText(), time));
    }
     */
}
