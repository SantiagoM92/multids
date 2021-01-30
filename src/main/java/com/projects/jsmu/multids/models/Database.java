package com.projects.jsmu.multids.models;

import lombok.Data;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Data
public class Database {

    private String url;
    private String driver;
    private String username;
    private String password;

    public DataSource createDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }


}
