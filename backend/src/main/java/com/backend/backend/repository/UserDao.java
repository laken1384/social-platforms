package com.backend.backend.repository;

import com.backend.backend.domin.User;
import com.backend.backend.domin.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(User pUser){
        jdbcTemplate.update("INSERT INTO user(id, username) "
                + "VALUES (?,?)", pUser.getId(), pUser.getUserName());
    }
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