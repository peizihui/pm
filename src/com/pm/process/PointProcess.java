package com.pm.process;

import com.pm.dao.datasource.Point;
import com.pm.dao.datasource.User;
import com.pm.dao.factory.PointDao;
import com.pm.dao.factory.UserDAO;
import com.pm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.util.List;

public class PointProcess {
    private Session session;
    private PointDao pointDao;
    private UserDAO userDAO;

    public PointProcess() {
        session = HibernateUtils.getSession();
        pointDao = new PointDao(session);
        userDAO = new UserDAO(session);
    }

    public boolean maddpoints(int addValue, int id) {
        Transaction transaction = session.beginTransaction();
        try {
            int orgValue = 0;
            orgValue = pointDao.getPointByID(id).getPointValue();
            int updatetotal = addValue + orgValue;
            pointDao.maddpoints(updatetotal,id);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e.getMessage());
            return false;
        }
    }
}
