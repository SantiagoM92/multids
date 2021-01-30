package com.projects.jsmu.multids.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@RequestMapping("/query")
@Slf4j
public class QueryDBController {


    DataSource dataSource;


    @GetMapping("/getDbUser")
    public String getDbUser() {


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        return jdbcTemplate.query("SELECT USER FROM dual", resultSet -> {
            if (resultSet.next()) {
                return resultSet.getString("USER");
            }
            return null;
        });

    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
