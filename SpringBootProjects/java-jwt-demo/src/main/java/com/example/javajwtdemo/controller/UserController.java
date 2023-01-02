package com.example.javajwtdemo.controller;

import com.example.javajwtdemo.dto.UserDto;
import com.example.javajwtdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getMyselfById(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.getMyselfById(id));
    }
}
