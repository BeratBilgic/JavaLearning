package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String sendMessage(String param) {
        System.out.println("MessageService sendMessage - " + param);
        return param;
    }
}