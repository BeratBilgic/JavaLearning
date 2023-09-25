package com.example.controller;

import com.example.model.MyUser;
import com.example.repository.MyUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/myusers")
public class MyUserController {

    private final MyUserRepository myUserRepository;

    public MyUserController(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    @GetMapping
    public List<MyUser> findAll() {
        return myUserRepository.findAll();
    }
}
