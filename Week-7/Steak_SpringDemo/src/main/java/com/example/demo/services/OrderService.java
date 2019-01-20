package com.example.demo.services;

import com.example.demo.Order;
import com.example.demo.Person;
import com.example.demo.Steak;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.SteakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    SteakRepository steakRepository;


    public void makeOrderByCustomerIdAndSteakId(Long customerId, Long steakId) {
        List<Steak> steaks = steakRepository.findAllById(steakId);

        Person customer =  personRepository.getOne(customerId);
        Order order = new Order(customer, steaks);

        orderRepository.save(order);
    }
}
