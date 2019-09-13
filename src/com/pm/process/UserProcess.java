package com.pm.process;

import com.pm.dao.datasource.User;
import com.pm.dao.factory.UserDAO;
import com.pm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;


public class UserProcess {
    private Session session;
    private UserDAO userDAO;

    public UserProcess(){
        session = HibernateUtils.getSession();
        userDAO = new UserDAO(session);
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
    public User userLogin (String name, String pwd) {
        try {
            User user = userDAO.userLogin(name,pwd);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertUser(User user){
        //开启事务
        Transaction transaction = session.beginTransaction();
        try{
            //业务逻辑
            //1.根据id查询该账户是否存在
         /*   User user2 = userDAO.queryUserByID(user.getUserName());
            if(user2 != null){
                JOptionPane.showMessageDialog(null, "用户已存在");
            }*/
            userDAO.insertUser(user);
            //未出现异常提交
            transaction.commit();
            return true;
        }catch(Exception e){
            //出现异常回滚
            transaction.rollback();
            //打印异常信息
            System.out.println(e.getMessage());
            return false;
        }
    }

}
