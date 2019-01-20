package com.example.demo.controller;

import com.example.demo.Steak;
import com.example.demo.services.SteakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController /*Expect requests */
public class SteakController {
    // We want to use the steak service to get stuff from the steak repo

    @Autowired
    SteakService steakService;

    @GetMapping(path = "steaks/all") /*When we go to localhost:8080/steaks/all, all the steaks come up*/
    public List<Steak> getSteaks() {
        return steakService.findAll();
    }

    @GetMapping("/steak/make/{cheese}")
    public List<Steak> makeMySteak(@PathVariable String cheese) {
        // if we pass in the cheese string, it'll set us up with the cheese variable in the mappingpath
        Steak newSteak = new Steak("cheese");
        steakService.makeSomeSteaks(newSteak);

        return getSteaks();
    }


}
