package com.example.controller;

import com.example.model.MyUser;
import com.example.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "My User API")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init(){
        MyUser user = new MyUser();
        user.setName("name");
        user.setSurname("surname");
        userRepository.save(user);
    }

    @PostMapping
    @ApiOperation(value = "Save a User")
    public ResponseEntity<MyUser> save(@RequestBody MyUser user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping
    @ApiOperation(value = "Find All User")
    public ResponseEntity<List<MyUser>> findAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
