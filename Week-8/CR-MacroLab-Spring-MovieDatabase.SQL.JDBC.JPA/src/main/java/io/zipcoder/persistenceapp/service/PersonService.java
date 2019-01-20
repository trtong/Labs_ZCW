package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.model.Person;

import java.util.List;

public interface PersonService {

    void add(Person p);
    void update(Person p);
    void remove (Integer id);
    Person findPersonById(Integer id);
    List<Person> getAllPeople();
    List<Person> findPeopleByMobile(String mobile);
    List<Person> findPeopleByLastName(String lastName);
}
