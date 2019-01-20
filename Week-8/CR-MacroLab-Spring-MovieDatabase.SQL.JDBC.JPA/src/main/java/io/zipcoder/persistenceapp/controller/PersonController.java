package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.model.Person;
import io.zipcoder.persistenceapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    private final
    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/people")
    public ResponseEntity<Iterable<Person>> getPeople() {
        Iterable<Person> people = personService.getAllPeople();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping(value = "/people/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Integer id) {
        Person p = personService.findPersonById(id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping(value = "/people/{id}")
    public ResponseEntity<Person> updatePersonById(@PathVariable Integer id, Person p) {
        personService.update(p);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
    This isn't working in postman?
     */
    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person p) {
        personService.add(p);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable Integer id) {
        personService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/people/reverseLookup/{mobilenumber}")
    public ResponseEntity<Iterable<Person>> lookupByMobile(@PathVariable String mobile) {
        Iterable<Person> p = personService.findPeopleByMobile(mobile);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
    @GetMapping("/people/surname/{lastname}")
    public ResponseEntity<Iterable<Person>> getByLastName(@PathVariable String lastName) {
        Iterable<Person> p = personService.findPeopleByLastName(lastName);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
//    @GetMapping("/people/surname")
//    public ResponseEntity<Iterable<Person>> getSurnames(String lastName) {
//        Iterable<Person> p = personService.generateSurnameMap(lastName);
//        return new ResponseEntity<>(p, HttpStatus.OK);
//    }
//    @GetMapping("/people/firstname/stats")
//
}
