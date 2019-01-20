package com.example.demo.services;

import com.example.demo.Steak;
import com.example.demo.repository.SteakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SteakService {

    @Autowired
    SteakRepository steakRepository;

    public List<Steak> findAll() {
        return steakRepository.findAll();
    }

    public void makeSomeSteaks(Steak steak) {
        steakRepository.save(steak);
    }

}
