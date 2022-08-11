package com.example.webinarpatientapi.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String index() {
        return "Hello World!";
    }
}
