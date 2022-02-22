package com.challenge.LuizaLabs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(path = "/api/test")
    public String check(){
        return "API is running!";
    }
}
