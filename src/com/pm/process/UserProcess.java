package com.pm.process;

import com.pm.dao.datasource.User;
import com.pm.dao.factory.ManagerDAO;
import com.pm.dao.factory.PointDao;
import com.pm.dao.factory.UserDAO;
import com.pm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.util.List;

public class UserProcess {
    private Session session;
    private UserDAO userDAO;
    private ManagerDAO managerDAO;
    private PointDao pointDao;

    public UserProcess() {
        session = HibernateUtils.getSession();
        userDAO = new UserDAO(session);
        pointDao = new PointDao(session);
        managerDAO = new ManagerDAO(session);
    }

    public List<User> getAllUsers() {
        try {
            return userDAO.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /***
     * public User queryUserByID(int id){
     *         try{
     *             User user = userDAO.queryUserByID(id);
     *             return user;
     *         }catch (Exception e){
     *             e.printStackTrace();
     *             return null;
     *         }
     *     }
     */
    /***
     * 用户登录进程
     * @param name
     * @param pwd
     * @return
     */
    public User userLogin(String name, String pwd) {
        try {
            User user = userDAO.userLogin(name, pwd);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean frzzeeUserByID(int id) {
        Transaction transaction = session.beginTransaction();
        try {
            userDAO.frzzeeUser(id);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean stopfrzzeeUserByID(int id) {
        Transaction transaction = session.beginTransaction();
        try {
            userDAO.stopfrzzeeUser(id);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean editpwdUser(int id, String pwd) {
        Transaction transaction = session.beginTransaction();
        try {
            userDAO.editpwdUser(id, pwd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e.getMessage());
            return false;
        }
    }


    public boolean insertUser(User user) {
        //开启事务
        Transaction transaction = session.beginTransaction();
        //1.根据username查询该账户是否存在
        User user2 = userDAO.queryIDByUserName(user.getUserName());
        if (user2 != null) {
            JOptionPane.showMessageDialog(null, "用户已存在");
        } else {
            userDAO.insertUser(user);
            //未出现异常提交
            transaction.commit();
            return true;
        }
        return false;
    }

}
