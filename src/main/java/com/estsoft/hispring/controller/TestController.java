package com.estsoft.hispring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/spring")
    public String spring() {
        return "hello";
    }
}
