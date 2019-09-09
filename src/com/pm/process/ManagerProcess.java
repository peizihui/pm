package com.pm.process;

import com.pm.dao.datasource.Manager;
import com.pm.dao.factory.ManagerDAO;
import com.pm.util.HibernateUtils;
import org.hibernate.Session;


public class ManagerProcess {
    private Session session;
    private ManagerDAO ManagerDAO;

    public ManagerProcess(){
        session = HibernateUtils.getSession();
        ManagerDAO = new ManagerDAO(session);
    }

    /***
     *
     */
    public Manager queryManagerByID(int id){
        try{
            Manager Manager = ManagerDAO.queryManagerByID(id);
            return Manager;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Manager ManagerLogin (String name, String pwd) {
        try {
            Manager Manager = ManagerDAO.ManagerLogin(name,pwd);
            return Manager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
