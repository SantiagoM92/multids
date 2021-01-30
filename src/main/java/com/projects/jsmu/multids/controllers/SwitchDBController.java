package com.projects.jsmu.multids.controllers;

import com.projects.jsmu.multids.configurations.CurrentDataBase;
import com.projects.jsmu.multids.configurations.DatabaseConfigurations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/switch")
@Slf4j
public class SwitchDBController {


    DatabaseConfigurations databaseConfigurations;


    @GetMapping("/db/{dbName}")
    public String getDB(@PathVariable String dbName) {

        String msg;

        if (databaseConfigurations.getConfigurations().containsKey(dbName)) {
            CurrentDataBase.getInstance().setLookupName(dbName);
            msg = "DB Switched!";
        } else {
            msg = "Ups Couldn't Switch DB!";
        }

        return msg;

    }

    @Autowired
    public void setDatabaseConfigurations(DatabaseConfigurations databaseConfigurations) {
        this.databaseConfigurations = databaseConfigurations;
    }
}
