package com.example.aeon.config;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseChecker {
    private final JdbcTemplate jdbcTemplate;

    public DatabaseChecker(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void check() {
        Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
        System.out.println("Query result: " + result);
    }
}
