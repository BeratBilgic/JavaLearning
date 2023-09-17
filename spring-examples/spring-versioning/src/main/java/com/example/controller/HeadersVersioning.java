package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/header")
public class HeadersVersioning {

    //localhost:8080/header/string with a header X-API-VERSION=1
    @GetMapping(value = "/string", headers = "X-API-VERSION=1")
    public String paramV1() {
        return "version 1";
    }

    //localhost:8080/header/string with a header X-API-VERSION=2
    @GetMapping(value = "/string", headers = "X-API-VERSION=2")
    public String paramV2() {
        return "version 2";
    }
}