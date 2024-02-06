package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test1")
    public String test(@RequestParam(value = "name", defaultValue = "Мир!") String name) {
        return String.format("Hello, %s!", name);
    }
}
