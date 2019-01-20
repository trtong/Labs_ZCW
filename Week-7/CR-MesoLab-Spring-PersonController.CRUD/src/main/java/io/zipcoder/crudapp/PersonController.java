package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public ResponseEntity<?> createPerson(@RequestBody Person p) {
        Person p1 = personRepository.save(p);
        return new ResponseEntity<>(p1, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPerson(@PathVariable int id) {
        Person p1 = personRepository.findOne(id);
        if (p1 != null) {
            return new ResponseEntity<>(p1, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public ResponseEntity<?> getPersonList() {
        List<Person> people = new ArrayList<>();
        personRepository.findAll().forEach(people::add);
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePerson(Person p) {
        if (getPerson(p.getId())!= null) {
            p = personRepository.save(p);
            return new ResponseEntity<>(p, HttpStatus.OK);
        } else {
            createPerson(p);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePerson(int id) {
        personRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
