package com.example.kcktest.service.impl;

import com.example.kcktest.dao.UserDao;
import com.example.kcktest.model.entity.User;
import com.example.kcktest.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public User findUserByLogin(String login) {
        return userDao.findUserByLogin(login);
    }
}
