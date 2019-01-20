package com.example.bakerylab.controllers;

import com.example.bakerylab.models.Muffin;
import com.example.bakerylab.repositories.MuffinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MuffinController {

    private final MuffinRepository muffinRepository;

    @Autowired
    public MuffinController(MuffinRepository muffinRepository) {
        this.muffinRepository = muffinRepository;
    }

    @RequestMapping(value = "/muffins", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(this.muffinRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/muffins/{id}", method = RequestMethod.GET)
    public ResponseEntity<Muffin> show(@PathVariable Long id) {
        return new ResponseEntity<>(this.muffinRepository.findById(id).get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/muffins", method = RequestMethod.POST)
    public ResponseEntity<Muffin> create(Muffin muffin) {
        return new ResponseEntity<>(this.muffinRepository.save(muffin), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/muffins/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Muffin> update(@PathVariable Long id, Muffin muffin) {
        Muffin foundMuffin = muffinRepository.findById(id).get();
        foundMuffin.setFlavor(muffin.getFlavor());

        return new ResponseEntity<>(this.muffinRepository.save(foundMuffin), HttpStatus.OK);
    }

    @RequestMapping(value = "muffins/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        this.muffinRepository.delete(muffinRepository.findById(id).get());
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
