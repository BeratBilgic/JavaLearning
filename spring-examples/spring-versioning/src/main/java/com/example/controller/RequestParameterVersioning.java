package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
public class RequestParameterVersioning {

    //localhost:8080/request/string?version=1
    @GetMapping(value = "/string", params = "version=1")
    public String paramV1() {
        return "version 1";
    }

    //localhost:8080/request/string?version=2
    @GetMapping(value = "/string", params = "version=2")
    public String paramV2() {
        return "version 2";
    }
}
