package com.pm.process;

import com.pm.dao.datasource.Manager;
import com.pm.dao.factory.ManagerDAO;
import com.pm.util.HibernateUtils;
import org.hibernate.Session;


public class ManagerProcess {
    private Session session;
    private ManagerDAO ManagerDAO;

    public ManagerProcess(){
        //获取session
        session = HibernateUtils.getSession();
        //初始化
        ManagerDAO = new ManagerDAO(session);
    }

    /***
     * 使用ID查询管理员
     * @param id
     * @return
     *
     * public Manager queryManagerByID(int id){
     *         try{
     *             Manager Manager = ManagerDAO.queryManagerByID(id);
     *             return Manager;
     *         }catch (Exception e){
     *             e.printStackTrace();
     *             return null;
     *         }
     *     }
     */

    /***
     * 登录进程
     * @param name
     * @param pwd
     * @return
     */
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
