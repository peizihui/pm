package com.pm.dao.factory;

import com.pm.dao.datasource.User;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class UserDAO {
    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public User queryUserByID(int id){
        return session.get(User.class, id);
    }

    public User userLogin(String name, String pwd){

        Query query = session.createQuery("from User where userName= ?1  and userPwd= ?2");
        query.setParameter(1, name);
        query.setParameter(2, pwd);
        User user = (User) query.uniqueResult();

        return user;

    }
}
