package com.projects.jsmu.multids.configurations;

import com.projects.jsmu.multids.models.Database;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "databases")
public class DatabaseConfigurations {

    private Map<String, Database> configurations = new HashMap<>();
    private String defaultDB;


    public Map<Object, Object> createTargetDataSources() {

        CurrentDataBase.getInstance().setLookupName(defaultDB);

        Map<Object, Object> result = new HashMap<>();
        configurations.forEach((key, value) -> result.put(key, value.createDataSource()));
        return result;
    }


}
