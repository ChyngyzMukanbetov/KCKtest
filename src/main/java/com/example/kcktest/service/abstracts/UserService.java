package com.example.kcktest.service.abstracts;

import com.example.kcktest.model.entity.User;

public interface UserService {
    User findUserByLogin(String login);
}
