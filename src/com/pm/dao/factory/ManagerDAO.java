package com.pm.dao.factory;

import com.pm.dao.datasource.Manager;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class ManagerDAO {
    private Session session;

    public ManagerDAO(Session session) {
        this.session = session;
    }

    public Manager queryManagerByID(int id){
        return session.get(Manager.class, id);
    }

    public Manager ManagerLogin(String name, String pwd){

        Query query = session.createQuery("from Manager where mgName= ?1  and mgPwd= ?2");
        query.setParameter(1, name);
        query.setParameter(2, pwd);
        Manager Manager = (Manager) query.uniqueResult();

        return Manager;

    }
}
