package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.model.Home;
import io.zipcoder.persistenceapp.model.Person;
import io.zipcoder.persistenceapp.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    private final
    HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @PostMapping(value = "/homes")
    public ResponseEntity<Home> createHome(@RequestBody Home home) {
        homeService.addHome(home);
        return new ResponseEntity<>(home, HttpStatus.CREATED);
    }

    @PutMapping(value= "/homes")
    public ResponseEntity<Home> updateHome(Home h, Integer id) {
        homeService.updateHome(id, h);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/homes")
    public ResponseEntity<Iterable<Home>> getHomes() {
        Iterable<Home> homes = homeService.getAllHomes();
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }

    @GetMapping(value = "/homes/{id}")
    public ResponseEntity<Home> getHomeById(@PathVariable Integer id) {
        Home h = homeService.findHomeById(id);
        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    @GetMapping(value = "/homes/homenumber/{homeNumber}")
    public ResponseEntity<Home> getHomeByHomeNumber(@PathVariable String homeNumber) {
        Home h = homeService.findHomeByHomeNumber(homeNumber);
        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    // Test this
    @GetMapping(value = "/homes/address/{address}")
    public ResponseEntity<Home> getHomeByAddress(@PathVariable String address) {
        Home h = homeService.findHomeByAddress(address);
        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    @GetMapping(value = "/homes/people/{personId}")
    public ResponseEntity<Home> getHomeForPersonId(@PathVariable Integer personId) {
        Home h = homeService.findHomeByPersonId(personId);
        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    @GetMapping(value = "/homes/{homeId}/people")
    public ResponseEntity<Iterable<Person>> getPeopleInHome(@PathVariable Integer homeId){
        Iterable<Person> people = homeService.generatePeopleInHome(homeId);
        return new ResponseEntity<>(people, HttpStatus.OK);
    }
}
