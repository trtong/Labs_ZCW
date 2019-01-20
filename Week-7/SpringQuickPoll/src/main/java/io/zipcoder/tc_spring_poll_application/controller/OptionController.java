package io.zipcoder.tc_spring_poll_application.controller;

import io.zipcoder.tc_spring_poll_application.domain.Option;
import io.zipcoder.tc_spring_poll_application.repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OptionController {

    private OptionRepository optionRepository;

    @Autowired
    public OptionController(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @RequestMapping(value="/options", method= RequestMethod.GET)
    public ResponseEntity<?> returnAllOptions() {
        Iterable<Option> options = optionRepository.getAllOptions();
        options.forEach(opt -> System.out.println(opt.toString()));
        return new ResponseEntity<>(options, HttpStatus.OK);
    }
}
