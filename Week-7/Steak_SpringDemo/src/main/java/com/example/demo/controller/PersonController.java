package com.example.demo.controller;

import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/make-person/{name}")
    public String makePersonByName(@PathVariable String name) {
        personService.makePerson(name);
        return "hey " + name;

    }

}
