package com.example.service;

import com.example.annotation.CustomAnnotation;
import org.springframework.stereotype.Service;

@Service
public class SecondMessageService {

    @CustomAnnotation
    public void message(String param) {
        System.out.println("SecondMessageService message - " + param);
    }
}
