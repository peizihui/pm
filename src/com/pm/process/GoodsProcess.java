package com.pm.process;

import com.pm.dao.datasource.Goods;
import com.pm.dao.factory.GoodsDAO;
import com.pm.dao.factory.ManagerDAO;
import com.pm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GoodsProcess {

    private Session session;
    private ManagerDAO ManagerDAO;
    private GoodsDAO goodsDAO;

    public GoodsProcess() {
        //获取session
        session = HibernateUtils.getSession();
        //初始化
        ManagerDAO = new ManagerDAO(session);
        goodsDAO = new GoodsDAO(session);
    }

    public List<Goods> getAllGoods(){
        try {
            return goodsDAO.getAllGoods();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleGoodsByID(int id) {
        Transaction transaction = session.beginTransaction();
        try {
            goodsDAO.deleGoodsByID(id);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e.getMessage());
            return false;
        }
    }
}
