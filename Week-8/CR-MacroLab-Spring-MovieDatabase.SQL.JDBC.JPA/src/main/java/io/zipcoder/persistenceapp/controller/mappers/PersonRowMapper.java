package io.zipcoder.persistenceapp.controller.mappers;

import io.zipcoder.persistenceapp.model.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("id"));
        person.setFirstName(rs.getString("first_name"));
        person.setLastName(rs.getString("last_name"));
        person.setMobile(rs.getString("mobile"));
        person.setBirthday(rs.getDate("birthday"));
        person.setHomeId(rs.getInt("home_id"));
        return person;
    }
}