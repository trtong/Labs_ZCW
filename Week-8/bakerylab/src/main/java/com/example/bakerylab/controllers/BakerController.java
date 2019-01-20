package com.example.bakerylab.controllers;

import com.example.bakerylab.models.Baker;
import com.example.bakerylab.repositories.BakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BakerController {

    @Autowired
    private BakerRepository bakerRepository;

    @RequestMapping(value = "/bakers", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(this.bakerRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/bakers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Baker> show(@PathVariable Long id) {
        return new ResponseEntity<>(this.bakerRepository.findById(id).get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/bakers", method = RequestMethod.POST)
    public ResponseEntity<Baker> create(Baker baker) {
        return new ResponseEntity<>(this.bakerRepository.save(baker), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/bakers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Baker> update(@PathVariable Long id, Baker baker) {
        Baker foundBaker = bakerRepository.findById(id).get();

        foundBaker.setName(baker.getName());
        foundBaker.setSpecialty(baker.getSpecialty());

        return new ResponseEntity<>(this.bakerRepository.save(foundBaker), HttpStatus.OK);
    }

    @RequestMapping(value = "/bakers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        this.bakerRepository.delete(bakerRepository.findById(id).get());
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
