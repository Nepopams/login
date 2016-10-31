package com.vadimrostov.service;

import com.vadimrostov.dao.UserDAO;
import com.vadimrostov.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vad on 31.10.2016.
 */

@Repository
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDAO userDAO;


    @Transactional
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Transactional
    @Override
    public void save(User user) {
            userDAO.save(user);
    }

    @Transactional
    public boolean isValid(String login, String password) {
        return userDAO.isValid(login, password);
    }
}
