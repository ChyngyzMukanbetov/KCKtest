package com.example.kcktest.dao;

import com.example.kcktest.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findUserByLogin(String login);
    boolean existsByLogin(String login);
}
