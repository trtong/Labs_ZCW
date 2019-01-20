package com.example.demo.services;

import com.example.demo.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public void makePerson(String name) {
        Person person = new Person(name);
        personRepository.save(person);
    }
}
