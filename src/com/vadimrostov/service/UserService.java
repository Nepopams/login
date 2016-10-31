package com.vadimrostov.service;

import com.vadimrostov.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vad on 31.10.2016.
 */

@Repository
public interface UserService {


    public List<User> findAll();

    public void save(User user);

    public boolean isValid(String login, String password);
}
