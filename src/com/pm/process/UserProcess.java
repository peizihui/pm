package com.pm.process;

import com.pm.dao.datasource.User;
import com.pm.dao.factory.UserDAO;
import com.pm.util.HibernateUtils;
import org.hibernate.Session;


public class UserProcess {
    private Session session;
    private UserDAO userDAO;

    public UserProcess(){
        session = HibernateUtils.getSession();
        userDAO = new UserDAO(session);
    }

    public User queryUser(int id){
        try{
            User user = userDAO.queryUserByID(id);
            return user;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            session.close();
        }
    }

}
