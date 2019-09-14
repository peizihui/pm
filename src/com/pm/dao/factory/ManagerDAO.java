package com.pm.dao.factory;

import com.pm.dao.datasource.Manager;
import org.hibernate.Session;
import org.hibernate.query.Query;

/***
 * 包含管理员表的数据库操作语句
 */
public class ManagerDAO {
    private Session session;

    /***
     * 初始化
     * @param session
     */
    public ManagerDAO(Session session) {
        this.session = session;
    }

    /***
     * 使用ID查询管理员
     * @param id
     * @return 管理员
     */
    public Manager queryManagerByID(int id) {
        return session.get(Manager.class, id);
    }

    /***
     * 使用管理员名字和密码登录系统
     * @param name 管理员名字
     * @param pwd  管理员密码
     * @return 管理员
     */
    public Manager ManagerLogin(String name, String pwd) {

        Query query = session.createQuery("from Manager where mgName= ?1  and mgPwd= ?2");
        query.setParameter(1, name);
        query.setParameter(2, pwd);
        Manager Manager = (Manager) query.uniqueResult();

        return Manager;

    }
}
