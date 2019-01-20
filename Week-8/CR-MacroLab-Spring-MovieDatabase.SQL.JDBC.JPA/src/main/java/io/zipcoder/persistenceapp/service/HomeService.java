package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.controller.mappers.HomeRowMapper;
import io.zipcoder.persistenceapp.controller.mappers.PersonRowMapper;
import io.zipcoder.persistenceapp.model.Home;
import io.zipcoder.persistenceapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    private final
    JdbcTemplate jdbcTemplate;

    @Autowired
    public HomeService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addHome(Home home) {
        Object[] info = {home.getAddress(), home.getHomeNumber()};
        jdbcTemplate.update(
                "INSERT INTO home(address, homenumber)" +
                        "VALUES(?,?)", info);
    }

    // Test this one
    public void addPersonToHome(Person p, Home home) {
        jdbcTemplate.update(
                "UPDATE person SET home_id = ?" +
                        "VALUE(?) WHERE id = ?",
                home.getId(), p.getId());
    }

    public void updateHome(Integer id, Home home) {
        jdbcTemplate.update(
                "UPDATE home set address = ?, homenumber = ?" +
                        "VALUES(?, ?)", home.getAddress(), home.getHomeNumber());
    }

    public List<Home> getAllHomes() {
        return jdbcTemplate.query("SELECT * FROM HOME", new HomeRowMapper());
    }

    public void remove(Integer id) {
        jdbcTemplate.update(
                "DELETE FROM home WHERE id = ?", id);
    }

    public void removeHomes(Iterable<Home> homes) {
        homes.forEach(home -> remove(home.getId()));
    }

    public Home findHomeById(Integer id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM home WHERE ID = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Home.class));
    }

    public Home findHomeByHomeNumber(String homeNumber) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM HOME WHERE homenumber = ?",
                new Object[]{homeNumber}, new BeanPropertyRowMapper<>(Home.class));
    }

    public Home findHomeByAddress(String address) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM HOME WHERE address = ?",
                new Object[]{address}, new BeanPropertyRowMapper<>(Home.class));
    }

    public Home findHomeByPersonId(Integer id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM home INNER JOIN person on home.id = person.home_id WHERE person.id = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Home.class));
    }

    public List<Person> generatePeopleInHome(Integer id) {
        return jdbcTemplate.query(
                "SELECT * FROM person INNER JOIN home on person.home_id = home.id WHERE home.id = ?",
                new Object[]{id}, new PersonRowMapper());
    }
}
