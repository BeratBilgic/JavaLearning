package com.example.controller;

import com.example.service.MessageService;
import com.example.service.SecondMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private SecondMessageService secondMessageService;

    @PostMapping("/{message}")
    public ResponseEntity<String> message(@PathVariable String message) throws Exception {
        secondMessageService.message(message);
        String msg = messageService.sendMessage(message);

        if (msg.equals("exception")){
            throw new Exception("Test Exception");
        }

        return ResponseEntity.ok(msg);
    }
}
