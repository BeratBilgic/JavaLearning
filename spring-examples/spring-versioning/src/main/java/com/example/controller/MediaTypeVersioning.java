package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mediaType")
public class MediaTypeVersioning {

    //localhost:8080/mediaType/string with a header Accept=application/vnd.company.app-v1+json
    @GetMapping(value = "/string", produces = "application/vnd.company.app-v1+json")
    public String paramV1() {
        return "version 1";
    }
    //localhost:8080/mediaType/string with a header Accept=application/vnd.company.app-v2+json
    @GetMapping(value = "/string", produces = "application/vnd.company.app-v2+json")
    public String paramV2() {
        return "version 2";
    }
}