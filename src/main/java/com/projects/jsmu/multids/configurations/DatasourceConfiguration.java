package com.projects.jsmu.multids.configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DatabaseConfigurations.class)
public class DatasourceConfiguration {

    DatabaseConfigurations databaseConfigurations;

    @Bean
    public DataSource dataSource() {

        RoutingDataSource dataSource = new RoutingDataSource();
        dataSource.setTargetDataSources(databaseConfigurations.createTargetDataSources());
        return dataSource;

    }

    @Autowired
    public void setDatabaseConfigurations(DatabaseConfigurations databaseConfigurations) {
        this.databaseConfigurations = databaseConfigurations;
    }

}
