package com.example.controller;

import com.example.service.RedisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> cacheTest() throws InterruptedException {
        return ResponseEntity.ok(redisService.cacheTest());
    }

    @GetMapping("/test/{num}")
    public ResponseEntity<String> cacheTestKey(@PathVariable int num) throws InterruptedException {
        return ResponseEntity.ok(redisService.cacheTestKey(num));
    }

    @PutMapping("/test/{num}")
    public ResponseEntity<String> cacheTestPut(@PathVariable int num) throws InterruptedException {
        return ResponseEntity.ok(redisService.cacheTestPut(num));
    }

    @DeleteMapping("/test/{num}")
    public ResponseEntity<String> cacheTestEvict(@PathVariable int num) throws InterruptedException {
        return ResponseEntity.ok(redisService.cacheTestEvict(num));
    }

    @DeleteMapping("/test/evictAll")
    public ResponseEntity<String> cacheTestEvict() throws InterruptedException {
        return ResponseEntity.ok(redisService.cacheTestEvictAllEntries());
    }
}
