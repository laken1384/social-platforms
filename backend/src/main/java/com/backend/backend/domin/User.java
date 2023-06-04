package com.backend.backend.domin;

import org.springframework.cglib.core.Block;
import org.springframework.stereotype.Component;

import java.sql.Blob;

@Component
public class User {
    private String id;
    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
