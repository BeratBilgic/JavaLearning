package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init(){
        User user =new User();
        user.setName("ali");
        user.setSurname("baba");
        user.setAddress("test");
        user.setBirthDate(Calendar.getInstance().getTime());
        user.setId("K0001");
        userRepository.save(user);
    }

    @GetMapping("/1/{search}")
    public ResponseEntity<List<User>> getUser1(@PathVariable String search) {
        List<User> kisiler = userRepository.getByCustomQuery(search);
        return ResponseEntity.ok(kisiler);
    }

    @GetMapping("/2/{search}")
    public ResponseEntity<List<User>> getUser2(@PathVariable String search) {
        List<User> kisiler = userRepository.findByNameLikeOrSurnameLike(search, search);
        return ResponseEntity.ok(kisiler);
    }
}
