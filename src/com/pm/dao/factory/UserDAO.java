package com.pm.dao.factory;

import com.pm.dao.datasource.User;
import org.hibernate.Session;

public class UserDAO {
    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public User queryUserByID(int id){
        return session.get(User.class, id);
    }
}
