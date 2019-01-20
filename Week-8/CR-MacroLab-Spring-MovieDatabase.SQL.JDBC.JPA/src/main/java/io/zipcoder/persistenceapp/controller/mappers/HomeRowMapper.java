package io.zipcoder.persistenceapp.controller.mappers;

import io.zipcoder.persistenceapp.model.Home;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeRowMapper implements RowMapper<Home> {
    @Override
    public Home mapRow(ResultSet rs, int rowNum) throws SQLException {
        Home home = new Home();
        home.setId(rs.getInt("id"));
        home.setAddress(rs.getString("ADDRESS"));
        home.setHomeNumber(rs.getString("HOMENUMBER"));
        return home;
    }
}