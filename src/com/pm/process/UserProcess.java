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
}
