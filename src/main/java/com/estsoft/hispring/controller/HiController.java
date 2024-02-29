package com.estsoft.hispring.controller;

import com.estsoft.hispring.domain.Person;
import com.estsoft.hispring.service.HiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HiController {
    HiService service;
    @GetMapping("/hi")    // GET localhost:8080/hi?name=queryparameter
    public String test(@RequestParam(value = "name", defaultValue = "world!") String name) {
        return String.format("Hello %s", name);
    }

    @PostMapping("/hi")
    public String testPost(@RequestBody String value) {
        service.parseProfile(value);
        return value;
    }
}
