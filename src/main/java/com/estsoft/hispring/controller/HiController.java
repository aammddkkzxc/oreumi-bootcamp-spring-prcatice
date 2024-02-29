package com.estsoft.hispring.controller;

import com.estsoft.hispring.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HiController {
    @GetMapping("/hi")    // GET localhost:8080/hi?name=queryparameter
    public String test(@RequestParam(value = "name", defaultValue = "world!") String name) {
        return String.format("Hello %s", name);
    }

    @PostMapping("/hi")
    public String testPost(@RequestBody String value) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Person deserializedPerson = objectMapper.readValue(value, Person.class);
            System.out.println(deserializedPerson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("value" + value);
        return value;
    }
}
