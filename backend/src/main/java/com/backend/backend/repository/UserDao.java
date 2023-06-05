package com.backend.backend.repository;

import com.backend.backend.domin.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void addUsers(Users pUser){
        String procedureCall = "{CALL InsertUser(?, ?, ?, ?)}";
        jdbcTemplate.update(procedureCall, pUser.getUserID(), pUser.getUserName(), pUser.getEmail(), pUser.getPassword());
    }

    public String account_login(Users pUser){
        String procedureCall = "{CALL GetUserPassword(?, ?)}";
        String token = jdbcTemplate.queryForObject(procedureCall, String.class, pUser.getUserName(), pUser.getPassword());
        return token;
    }
}