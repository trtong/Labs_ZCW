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

import javax.validation.constraints.Null;

@RestController
public class BakerController {

    private final BakerRepository bakerRepository;

    @Autowired
    public BakerController(BakerRepository bakerRepository) {
        this.bakerRepository = bakerRepository;
    }

    @RequestMapping(value = "/bakers", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(this.bakerRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/bakers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Baker> show(@PathVariable Long id) {
        return verfiyBaker(id);
    }

    @RequestMapping(value = "/bakers", method = RequestMethod.POST)
    public ResponseEntity<Baker> create(Baker baker) {
        return new ResponseEntity<>(this.bakerRepository.save(baker), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/bakers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Baker> update(@PathVariable Long id, Baker baker) {

        if (verfiyBaker(id).getStatusCode().value() != HttpStatus.NOT_FOUND.value()) {
            Baker foundBaker = bakerRepository.findById(id).get();
            foundBaker.setName(baker.getName());
            foundBaker.setSpecialty(baker.getSpecialty());

            return new ResponseEntity<>(this.bakerRepository.save(foundBaker), HttpStatus.OK);
        } else {
            return verfiyBaker(id);
        }
    }

    @RequestMapping(value = "/bakers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
//        if (verfiyBaker(id).getStatusCode().value() != HttpStatus.NOT_FOUND.value()) {
            this.bakerRepository.delete(bakerRepository.findById(id).get());
            return new ResponseEntity<>(true, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
//        }
    }

    public ResponseEntity<Baker> verfiyBaker(Long id) {
        try {
            bakerRepository.findById(id).get().getId();
        } catch (NullPointerException npe) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bakerRepository.findById(id).get(), HttpStatus.OK);
    }
}
