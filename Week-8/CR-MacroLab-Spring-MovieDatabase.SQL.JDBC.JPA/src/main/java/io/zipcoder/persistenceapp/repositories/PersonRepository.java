package io.zipcoder.persistenceapp.repositories;

import io.zipcoder.persistenceapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByMobile(String mobile);


    List<Person> findByLastName(String lastName);
}
