package com.example.javajwtdemo.controller;

import com.example.javajwtdemo.dto.UserDto;
import com.example.javajwtdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final UserService userService;

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @GetMapping("/public")
    public String publicEndpoint(){
        return "public";
    }

    @GetMapping("/auth-required")
    public String testEndpoint(){
        return "auth-required";
    }

    //@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin-pre-authorize")
    public String adminPreAuthorize(){
        return "admin-PreAuthorize";
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getMyself(){
        return ResponseEntity.ok(userService.findUserInContext());
    }
}
