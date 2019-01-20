package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.controller.mappers.PersonRowMapper;
import io.zipcoder.persistenceapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.JDBCType;
import java.util.List;

@Service
@Primary
public class JdbcPersonServiceImpl implements PersonService {

    private final JDBCType[] types = {JDBCType.VARCHAR, JDBCType.VARCHAR, JDBCType.VARCHAR, JDBCType.DATE, JDBCType.SMALLINT };

    private final
    JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcPersonServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(Person p) {
        Object[] info = {p.getFirstName(), p.getLastName(), p.getMobile(), p.getBirthday(), p.getHomeId()};
        jdbcTemplate.update(
                "INSERT INTO person(first_name, last_name, mobile, birthday, home_ID)" +
                        "VALUES (?, ?, ?, ?, ?)", info);
    }

    // Test this one
    public void update(Person p) {
        jdbcTemplate.update(
                "UPDATE person set first_name = ?, last_name ?, mobile = ?, birthday = ?, home_ID = ?" +
                        "VALUES (?, ?, ?, ?, ?) WHERE id = ?",
                p.getFirstName(), p.getLastName(), p.getMobile(), p.getBirthday(), p.getHomeId(), p.getId());
    }

    public void remove(Integer id) {
        jdbcTemplate.update("DELETE FROM person WHERE id = ?", id);
    }

    public void removePeople(Iterable<Person> p) {
        p.forEach(person -> remove(person.getId()));
    }

    public Person findPersonById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM PERSON WHERE ID=?", new Object[] {id},
                new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Person> getAllPeople() {
        return jdbcTemplate.query("SELECT * FROM PERSON", new PersonRowMapper());
    }

    public List<Person> findPeopleByMobile(String mobile) {
        return jdbcTemplate.query("SELECT * FROM PERSON WHERE MOBILE=?", new Object[] {mobile},
                new PersonRowMapper());
    }

    public List<Person> findPeopleByLastName(String lastName) {
        return jdbcTemplate.query("SELECT * FROM PERSON WHERE LAST_NAME=?", new Object[] {lastName},
                new PersonRowMapper());
    }

// public List<Person> generateSurnameMap(String lastName) {
//        return jdbcTemplate.query("SELECT * FROM PERSON WHERE LAST_NAME=?", new Object[] {lastName},
//                new PersonRowMapper());
//    }

/*
implement the count for people with selected first name
 */
}


