package com.maar.bookstore.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!  how are you guys doing i am fine ";
    }
}