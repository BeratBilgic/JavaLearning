package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uri")
public class URIVersioning {

    //localhost:8080/uri/v1/string
    @GetMapping(value = "/v1/string")
    public String paramV1() {
        return "version 1";
    }

    //localhost:8080/uri/v2/string
    @GetMapping(value = "/v2/string")
    public String paramV2() {
        return "version 2";
    }
}