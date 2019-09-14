package com.pm.dao.factory;

import com.pm.dao.datasource.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/***
 * 包含用户表的数据库操作语句
 */
public class UserDAO {
    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    /***
     * 使用ID查询用户
     * @param id
     * @return
     */
    public User queryUserByID(String id) {
        return session.get(User.class, id);
    }

    /***
     * 使用用户名字和密码登录系统
     * @param name
     * @param pwd
     * @return
     */
    public List<User> getAllUsers() {
        Query<User> query = session.createQuery("from User", User.class);
        return query.getResultList();
    }

    //插入用户
    public void insertUser(User b) {
        session.save(b);
    }

    //登录
    public User userLogin(String name, String pwd) {
        Query query = session.createQuery("from User where userName= ?1  and userPwd= ?2");
        query.setParameter(1, name);
        query.setParameter(2, pwd);
        User user = (User) query.uniqueResult();
        return user;
    }

    public User getUserByID(int id) {
        Query query = session.createQuery("from User where id = ?1");
        query.setParameter(1, id);
        return (User) query.uniqueResult();
    }

    //冻结用户
    public void frzzeeUser(int id) {
        Query query = session.createQuery("update User set isFreeze = 1 where id=?1");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    //解冻用户
    public void stopfrzzeeUser(int id) {
        Query query = session.createQuery("update User set isFreeze = 0 where id=?1");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    //管理员修改用户密码
    public void editpwdUser(int id, String pwd) {
        Query query = session.createQuery("update User set userPwd=?1 where id=?2");
        query.setParameter(1, pwd);
        query.setParameter(2, id);
        query.executeUpdate();
    }


}
