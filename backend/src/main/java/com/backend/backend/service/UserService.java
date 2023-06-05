package com.backend.backend.service;

import com.backend.backend.domin.Users;
import com.backend.backend.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public void addUsers(Users pUser){
        userDao.addUsers(pUser);
    }
    public String account_login(Users pUser) {
        return userDao.account_login(pUser);
    }
}