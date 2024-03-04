package com.estsoft.hispring.domain;

import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void lombokTest() {
        Person person = new Person();
        person.setAge(50);
        person.setName("하이");

        System.out.println(person.getAge());
        System.out.println(person.getName());
    }
}