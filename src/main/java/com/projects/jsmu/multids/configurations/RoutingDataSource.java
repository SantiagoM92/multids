package com.projects.jsmu.multids.configurations;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSource extends AbstractRoutingDataSource {


    @Override
    protected Object determineCurrentLookupKey() {

        return CurrentDataBase.getInstance().getLookupName();

    }
}