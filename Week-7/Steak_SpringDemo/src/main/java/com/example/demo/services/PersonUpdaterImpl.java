package com.example.demo.services;

import com.example.demo.repository.PersonUpdater;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PersonUpdaterImpl implements PersonUpdater {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean UpdatePersonName(String name) {
        String update = "UPDATE Persons p SET p.name = " + name;
        entityManager.createQuery(update);
        return false;
    }
}
