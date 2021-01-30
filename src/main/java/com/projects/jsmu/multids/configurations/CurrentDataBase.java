package com.projects.jsmu.multids.configurations;


import lombok.Data;

@Data
public class CurrentDataBase {

    private static CurrentDataBase instance;
    private String lookupName;


    public static CurrentDataBase getInstance() {
        if (instance == null) {
            instance = new CurrentDataBase();
        }

        return instance;
    }


}
