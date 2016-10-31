package com.vadimrostov.dao;

import com.vadimrostov.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vad on 31.10.2016.
 */

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public boolean isValid(String login, String password) {
        Query query= sessionFactory.getCurrentSession().createQuery("from User where login =:login AND password=:password");
        query.setParameter("login", login);
        query.setParameter("password", password);

        if(query.uniqueResult()!=null){
            return true;
        }
        else return false;
    }
}
