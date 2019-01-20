package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.repositories.PersonRepository;
import io.zipcoder.persistenceapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaPersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public void add(Person p) {
        personRepository.save(p);
    }

    @Override
    public void update(Person p) {
        personRepository.save(p);

    }

    @Override
    public void remove(Integer id) {
        personRepository.delete(id);
    }

    @Override
    public Person findPersonById(Integer id) {
        return personRepository.findOne(id);
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> findPeopleByMobile(String mobile) {
        return personRepository.findByMobile(mobile);
    }

    @Override
    public List<Person> findPeopleByLastName(String lastName) {
        return personRepository.findByLastName(lastName);
    }
}
